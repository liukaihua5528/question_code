package com.question.user.utils;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Date 2021/3/31 23:48
 * @Created by liukaihua
 */
public class RedisUtil {

    private RedisTemplate redisTemplate;

    public RedisUtil(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 模糊查询，获取key
     * @param pattern
     * @return
     */
    public Set<String> getKeys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * 获取所有key
     * @return
     */
    public Set<String> getKeys() {
        return getKeys("*");
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public Boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 根据key删除
     * @param key
     */
    public void del(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 存入redis
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 存入redis并设置失效时间
     * @param key
     * @param value
     * @param expire
     */
    public void set(String key, String value, Integer expire) {
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置失效时间
     * @param key
     * @param expire
     */
    public void expire(String key, int expire) {
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    /**
     * 在原有的值基础上新增字符串到末尾
     * @param key
     * @param value
     */
    public void append(String key, String value) {
        redisTemplate.opsForValue().append(key, value);
    }

    /**
     * 获取原来key键对应的值并重新赋新值
     * @param key
     * @param newValue
     * @return
     */
    public Object getSet(String key, String newValue) {
        return redisTemplate.opsForValue().getAndSet(key, newValue);
    }

    /**
     * 如果键不存在则新增,存在则不改变已经有的值
     * @param key
     * @param value
     * @return
     */
    public boolean setNx(String key, String value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    /**
     * 以增量的方式将long值存储在变量中
     * @param key
     * @param delta
     * @return
     */
    public Long incrBy(String key, Long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

}
