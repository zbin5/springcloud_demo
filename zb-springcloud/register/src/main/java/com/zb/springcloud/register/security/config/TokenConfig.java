package com.zb.springcloud.register.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @Author:
 * @Description:
 * @Date: Create in 10:59 2021/8/26
 * @UpdateBy:
 */
@Configuration
public class TokenConfig {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter()) {
            @Override
            public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
                //添加Jwt Token白名单,将Jwt以jti为Key存入redis中，并保持与原Jwt有一致的时效性
                if (token.getAdditionalInformation().containsKey("jti")) {
                    String jti = token.getAdditionalInformation().get("jti").toString();
                    stringRedisTemplate.opsForValue().set(jti, token.getValue(),60*10, TimeUnit.MINUTES);
                }
                super.storeAccessToken(token, authentication);
            }

            @Override
            public void removeAccessToken(OAuth2AccessToken token) {
                if (token.getAdditionalInformation().containsKey("jti")) {
                    String jti = token.getAdditionalInformation().get("jti").toString();
                    stringRedisTemplate.delete(jti);
                }
                super.removeAccessToken(token);
            }
        };
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(com.zb.springcloud.common.utils.security.TokenConfig.token_key);
        return converter;
    }

    /**
     * 配置令牌管理
     */
    @Bean
    public AuthorizationServerTokenServices tokenService(ClientDetailsService clientDetailsService, TokenStore tokenStore
            , JwtAccessTokenConverter accessTokenConverter) {
        DefaultTokenServices service = new DefaultTokenServices();
        service.setClientDetailsService(clientDetailsService);
        service.setSupportRefreshToken(true);
        service.setTokenStore(tokenStore);
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Collections.singletonList(accessTokenConverter));
        service.setTokenEnhancer(tokenEnhancerChain);
        return service;
    }

    /**
     * 授权码存储方式
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(DataSource dataSource) {
        return new JdbcAuthorizationCodeServices(dataSource);
    }

}
