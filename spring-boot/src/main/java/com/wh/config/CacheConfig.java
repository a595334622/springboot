package com.wh.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * redis缓存配置
* @ClassName: CacheConfig 
* @Description: TODO redis缓存 
* @author wh
* @date 2018年8月26日 下午12:29:44
 */
@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport{
	/**
	 * 添加redis缓存实例
	* @Title: cacheManager 
	* @param redisTemplate
	* @return CacheManager
	* @author 59533
	* @date 2018年9月11日上午9:39:32
	 */
    @SuppressWarnings("rawtypes")
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
        // 多个缓存的名称,目前只定义了一个
        List<String> cacheName = new ArrayList<String>();
        cacheName.add("testredis");
        
        rcm.setCacheNames(cacheName);
        //设置缓存过期时间(秒)
        rcm.setDefaultExpiration(600);
        return rcm;
    }
    /**
     * redis缓存配置
    * @Title: redisTemplate 
    * @param factory
    * @return RedisTemplate<String,String>
    * @author 59533
    * @date 2018年9月11日上午9:40:04
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

}
