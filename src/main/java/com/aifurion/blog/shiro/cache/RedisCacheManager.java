package com.aifurion.blog.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/1/15 9:25
 */
public class RedisCacheManager implements CacheManager {
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {

        return new RedisCache<K, V>(s);
    }
}
