package com.wzy.redis.service;

import com.wzy.redis.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestController
@RefreshScope
@Api("redis服务接口")
public class RedisServiceImpl implements RedisService{

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @ApiOperation(value = "获取一个key的值", notes = "获取string 类型数据")
    @ApiImplicitParam(name = "key", value = "redis key", required = true, dataType = "String", paramType = "String")
    @Override
    public String get(String key) {
        Object value = stringRedisTemplate.opsForValue().get(key);
        if (value != null ) {
            return value.toString();
        }
        return null;
    }

    @ApiOperation(value = "插入一条数据", notes = "插入string 类型数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "redis key", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "value", value = "redis value", required = true, dataType = "String", paramType = "String")}
    )
    @Override
    public String set(String key,String value)
    {
        stringRedisTemplate.opsForValue().set(key, value);
        return value;
    }

    @ApiOperation(value = "插入一条可以过期的数据", notes = "插入string 类型数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "redis key", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "value", value = "redis value", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "second", value = "redis second", required = true, dataType = "Integer", paramType = "Integer")}
    )
    @Override
    public String setEx(String key, String value, Integer second) {
        stringRedisTemplate.opsForValue().set(key,value);
        stringRedisTemplate.expire(key,second, TimeUnit.SECONDS);
        return value;
    }

    @ApiOperation(value = "获取一个map的值", notes = "获取map类型数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "redis key", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "item", value = "redis item", required = true, dataType = "String", paramType = "String")}
    )
    @Override
    public String hget(String key,String item)
    {
        Object value = stringRedisTemplate.opsForHash().get(key,item);
        if (value != null ) {
            return value.toString();
        }
        return null;
    }

    @ApiOperation(value = "插入一条map的值", notes = "插入map类型数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hkey", value = "redis hkey", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "key", value = "redis key", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "value", value = "redis value", required = true, dataType = "String", paramType = "String")}
    )
    @Override
    public void hset(String hkey, String key, String value)
    {
        stringRedisTemplate.opsForHash().put(hkey,key,value);
    }


    @ApiOperation(value = "插入一条map能够过期的值", notes = "插入类型数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hkey", value = "redis hkey", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "key", value = "redis key", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "value", value = "redis value", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "second", value = "redis second", required = true, dataType = "Integer", paramType = "Integer")}
    )
    @Override
    public boolean hsetEx(String hkey, String key, String value, Integer second) {
        stringRedisTemplate.opsForHash().put(hkey,key,value);
        return stringRedisTemplate.expire(hkey,second,TimeUnit.SECONDS);
    }

    @ApiOperation(value = "key值追加值", notes = "追加值 例如统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "redis key", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "num", value = "redis num", required = true, dataType = "Integer", paramType = "Integer")}
    )
    @Override
    public long incr(String key, Integer num) {
        return stringRedisTemplate.opsForValue().increment(key,num);
    }


    @ApiOperation(value = "设置一个key的过期时间", notes = "设置一个key 让它具有过期时间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "redis key", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "second", value = "redis second", required = true, dataType = "Integer", paramType = "Integer")}
    )
    @Override
    public boolean expire(String key, Integer second) {
        return stringRedisTemplate.expire(key,second, TimeUnit.SECONDS);
    }


    @ApiOperation(value = "删除一个key", notes = "根据key删除一条数据")
    @ApiImplicitParam(name = "key", value = "redis key", required = true, dataType = "String", paramType = "String")
    @Override
    public void del(String key) {
        stringRedisTemplate.delete(key);
    }

    @ApiOperation(value = "删除一个map类型的数据", notes = "删除map类型里的数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hkey", value = "redis hkey", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "key", value = "redis key", required = true, dataType = "String", paramType = "String")}
    )
    @Override
    public long hdel(String hkey, String key)
    {
        return stringRedisTemplate.opsForHash().delete(hkey,key);
    }


    @ApiOperation(value = "判断一个key是否存在", notes = "根据key值判断这条数据是否存在")
    @ApiImplicitParam(name = "key", value = "redis key", required = true, dataType = "String", paramType = "String")
    @Override
    public boolean exists(String key) {
        return (boolean)stringRedisTemplate.execute(new RedisCallback() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.exists(key.getBytes());
            }
        });
    }

    @ApiOperation(value = "模糊查询所有key", notes = "根据一个key关键字查询出所有相关key")
    @ApiImplicitParam(name = "key", value = "redis key", required = true, dataType = "String", paramType = "String")
    @Override
    public Object[] keys(String key) {
        Set<String> keys = stringRedisTemplate.keys(key);
        return keys.toArray();
    }
}
