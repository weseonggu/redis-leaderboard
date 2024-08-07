package com.example.redis;

import com.example.redis.domain.ItemDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, ItemDto> rankTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, ItemDto> template = new RedisTemplate<>();
        // yml파일에 있는 레디스 설정 정보를 가져오서 연결에 사용
        template.setConnectionFactory(redisConnectionFactory);
        // 레디스 키 타입
        template.setKeySerializer(RedisSerializer.string());
        // 레디스 값 타입
        template.setValueSerializer(RedisSerializer.json());

        return template;
    }

}
