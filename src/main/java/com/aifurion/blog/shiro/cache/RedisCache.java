package com.aifurion.blog.shiro.cache;

import com.aifurion.blog.Utils.ApplicationContextUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Collection;
import java.util.Set;

/**
 * @author ：zzy
 * @description：TODO 自定义redis缓存
 * @date ：2021/1/15 9:27
 */

public class RedisCache<K,V> implements Cache<K,V> {

    private String cacheName;

    public RedisCache() {
    }

    public RedisCache(String cacheName) {
        this.cacheName = cacheName;
    }


    @Override
    public V get(K k) throws CacheException {

        RedisTemplate redisTemplate = getRedisTemplate();
        V value = (V) redisTemplate.opsForHash().get(this.cacheName, k.toString());
        return value;
    }

    @Override
    public V put(K k, V v) throws CacheException {

        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.opsForHash().put(this.cacheName,k.toString(),v);
        return null;
    }

    @Override
    public V remove(K k) throws CacheException {

        return (V) getRedisTemplate().opsForHash().delete(this.cacheName, k.toString());
    }

    @Override
    public void clear() throws CacheException {
        getRedisTemplate().opsForHash().delete(this.cacheName);

    }

    @Override
    public int size() {

        return getRedisTemplate().opsForHash().size(this.cacheName).intValue();
    }

    @Override
    public Set<K> keys() {
        return getRedisTemplate().opsForHash().keys(this.cacheName);
    }

    @Override
    public Collection<V> values() {
        return getRedisTemplate().opsForHash().values(this.cacheName);
    }


    public RedisTemplate getRedisTemplate() {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
