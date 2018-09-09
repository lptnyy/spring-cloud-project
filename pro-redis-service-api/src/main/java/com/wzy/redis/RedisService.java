package com.wzy.redis;

import com.wzy.redis.hystrix.RedisServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "redis-service", fallback = RedisServiceHystrix.class)
public interface RedisService {

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    String get(@RequestParam("key") String key);

    @RequestMapping(path = "/set", method = RequestMethod.GET)
    String set(
            @RequestParam("key") String key,
            @RequestParam("value") String value);

    @RequestMapping(path = "/setEx", method = RequestMethod.GET)
    String setEx(
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("second") Integer second);

    @RequestMapping(path = "/hget", method = RequestMethod.GET)
    String hget(
            @RequestParam("hkey") String hkey,
            @RequestParam("key") String key);

    @RequestMapping(path = "/hset", method = RequestMethod.GET)
    void hset(
            @RequestParam("hkey") String hkey,
            @RequestParam("key") String key,
            @RequestParam("value") String value);

    @RequestMapping(path = "/hsetEx", method = RequestMethod.GET)
    boolean hsetEx(
            @RequestParam("hkey") String hkey,
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("second")Integer second);

    @RequestMapping(path = "/incr", method = RequestMethod.GET)
    long incr(
            @RequestParam("key") String key,
            @RequestParam("num") Integer num);

    @RequestMapping(path = "/expire", method = RequestMethod.GET)
    boolean expire(
            @RequestParam("key") String key,
            @RequestParam("second") Integer second);

    @RequestMapping(path = "/del", method = RequestMethod.GET)
    void del(@RequestParam("key") String key);

    @RequestMapping(path = "/hdel", method = RequestMethod.GET)
    long hdel(
            @RequestParam("hkey") String hkey,
            @RequestParam("key") String key);

    @RequestMapping(path = "/exists", method = RequestMethod.GET)
    boolean exists(@RequestParam("key") String key);

    @RequestMapping(path = "/keys", method = RequestMethod.GET)
    Object[] keys(@RequestParam("key") String key);
}
