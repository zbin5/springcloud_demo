package com.zb.springcloud.common.utils.redis;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedisLockUtil {
    private static final String redisLock = "redislock";

    /**
     * 获取锁
     * @return
     */
    public static Boolean setLock(String key, RedisTemplate redisTemplate) {
        SessionCallback<Boolean> sessionCallback = new SessionCallback<Boolean>() {
            List<Object> exec = null;

            @Override
            @SuppressWarnings("unchecked")
            public Boolean execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                redisTemplate.opsForValue().setIfAbsent(redisLock+key, redisLock);
                redisTemplate.expire(redisLock+key, 10, TimeUnit.MINUTES);
                exec = operations.exec();
                if (exec.size() > 0) {
                    return (Boolean) exec.get(0);
                }
                return false;
            }
        };
        return (Boolean) redisTemplate.execute(sessionCallback);
    }

    /**
     * 释放锁
     * @return
     */
    public static void releaseLock(String key,RedisTemplate redisTemplate){
        redisTemplate.delete(redisLock+key);
    }
}
