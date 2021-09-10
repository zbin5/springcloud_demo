package com.zb.springcloud.provider1.filter;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.servlet.HandlerInterceptor;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        try{
            log.info("进入拦截器:"+request.getRequestURI());
            // 检查token是否存在
            String token = getToken(request);
            if (StringUtils.isBlank(token)) {
                return false;
            }

            log.info(stringRedisTemplate.opsForValue().get("ceshi"));
            //3 判断是否是有效的token
            OAuth2AccessToken oAuth2AccessToken= tokenStore.readAccessToken(token);
            if(stringRedisTemplate.opsForValue().get(oAuth2AccessToken.getAdditionalInformation().get("jti").toString())==null)
                return false;

            return true;
        }catch (Exception e){
            log.error("拦截器处理异常：",e);
            return false;
        }
    }

    /**
     * 获取token
     */
    private String getToken(HttpServletRequest request) {
        String tokenStr = request.getHeader("Authorization");
        if (StringUtils.isBlank(tokenStr)) {
            return null;
        }
        String token = tokenStr.split(" ")[1];
        if (StringUtils.isBlank(token)) {
            return null;
        }
        return token;
    }


    /**
     * 无效的token
     */
    private Mono<Void> invalidTokenMono(ServerWebExchange exchange) {
        JSONObject json = new JSONObject();
        json.put("status", HttpStatus.UNAUTHORIZED.value());
        json.put("data", "无效的token");
        return buildReturnMono(json, exchange);
    }

    private Mono<Void> noTokenMono(ServerWebExchange exchange) {
        JSONObject json = new JSONObject();
        json.put("status", HttpStatus.UNAUTHORIZED.value());
        json.put("data", "没有token");
        return buildReturnMono(json, exchange);
    }


    private Mono<Void> buildReturnMono(JSONObject json, ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        byte[] bits = json.toJSONString().getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bits);
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        //指定编码，否则在浏览器中会中文乱码
        response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }

}
