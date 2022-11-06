package com.ongsat.video.web.task;

import com.ongsat.video.web.common.constant.RedisConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

@Slf4j
@Configuration
@EnableScheduling
public class ClearRedisIpLimitTask {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Scheduled(cron = "0 0 0 * * ?")
    private void configureTasks() {
        Set<String> keys = redisTemplate.keys(RedisConstant.IP_LIMIT + "*");
        log.info("开始清除redis limit, length: {}", keys.size());
        for (String key : keys) {
            redisTemplate.opsForValue().set(key, 0);
        }
    }

}
