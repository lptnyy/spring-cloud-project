package com.wzy.redis.hystrix;

import com.wzy.redis.RedisService;
import org.springframework.stereotype.Component;

@Component
public class RedisServiceHystrix implements RedisService{

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public String set(String key, String value) {
        return null;
    }

    @Override
    public String setEx(String key, String value, Integer second) {
        return null;
    }

    @Override
    public String hget(String key, String item) {
        return null;
    }

    @Override
    public void hset(String hkey, String key, String value) {

    }

    @Override
    public boolean hsetEx(String hkey, String key, String value, Integer second) {
        return false;
    }

    @Override
    public long incr(String key, Integer num) {
        return 0;
    }

    @Override
    public boolean expire(String key, Integer second) {
        return false;
    }

    @Override
    public void del(String key) {

    }

    @Override
    public long hdel(String hkey, String key) {
        return 0;
    }

    @Override
    public boolean exists(String key) {
        return false;
    }

    @Override
    public Object[] keys(String key) {
        return new Object[0];
    }
}
