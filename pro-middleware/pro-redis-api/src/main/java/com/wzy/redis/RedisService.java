package com.wzy.redis;

import com.wzy.common.feign.FeignRequestInterceptor;
import com.wzy.redis.hystrix.RedisServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "redis-service", configuration = FeignRequestInterceptor.class, fallback = RedisServiceHystrix.class)
public interface RedisService {

    @RequestMapping(path = "/get", method = RequestMethod.POST)
    String get(@RequestParam("key") String key);

    @RequestMapping(path = "/set", method = RequestMethod.POST)
    String set(
            @RequestParam("key") String key,
            @RequestParam("value") String value);

    @RequestMapping(path = "/setEx", method = RequestMethod.POST)
    String setEx(
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("second") Integer second);

    @RequestMapping(path = "/hget", method = RequestMethod.POST)
    String hget(
            @RequestParam("hkey") String hkey,
            @RequestParam("key") String key);

    @RequestMapping(path = "/hset", method = RequestMethod.POST)
    void hset(
            @RequestParam("hkey") String hkey,
            @RequestParam("key") String key,
            @RequestParam("value") String value);

    @RequestMapping(path = "/hsetEx", method = RequestMethod.POST)
    boolean hsetEx(
            @RequestParam("hkey") String hkey,
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("second")Integer second);

    @RequestMapping(path = "/incr", method = RequestMethod.POST)
    long incr(
            @RequestParam("key") String key,
            @RequestParam("num") Integer num);

    @RequestMapping(path = "/expire", method = RequestMethod.POST)
    boolean expire(
            @RequestParam("key") String key,
            @RequestParam("second") Integer second);

    @RequestMapping(path = "/del", method = RequestMethod.POST)
    void del(@RequestParam("key") String key);

    @RequestMapping(path = "/hdel", method = RequestMethod.POST)
    long hdel(
            @RequestParam("hkey") String hkey,
            @RequestParam("key") String key);

    @RequestMapping(path = "/exists", method = RequestMethod.POST)
    boolean exists(@RequestParam("key") String key);

    @RequestMapping(path = "/keys", method = RequestMethod.POST)
    Object[] keys(@RequestParam("key") String key);
}
