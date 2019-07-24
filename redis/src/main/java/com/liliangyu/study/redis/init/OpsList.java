package com.liliangyu.study.redis.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liliangyu
 * @date 2019/6/24
 */
@Component
@Slf4j
public class OpsList implements CommandLineRunner {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void run(String... args) throws Exception {

        String key = "R:RedPacket:Que:1";
        List o = redisTemplate.opsForList().range(key, 0, -1);
        if (null != o) {
            log.info(o.toString());
        }
    }
}
