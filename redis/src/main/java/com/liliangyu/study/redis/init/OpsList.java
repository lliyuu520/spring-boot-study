package com.liliangyu.study.redis.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

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

        String key = "R:SendedReward:1";
        Object o = redisTemplate.opsForHash().get(key, "1");
        if (null != o) {
            log.info(key+"-"+"-"+1+"="+o.toString());
        }
        o = redisTemplate.opsForHash().get(key, "2");
        if (null != o) {
            log.info(key+"-"+"-"+2+"="+o.toString());
        }
        o = redisTemplate.opsForHash().get(key, "3");
        if (null != o) {
            log.info(key+"-"+3+"="+o.toString());
        }
        o = redisTemplate.opsForHash().get(key, "4");
        if (null != o) {
            log.info(key+"-"+4+"="+o.toString());
        }
        o = redisTemplate.opsForHash().get(key, "5");
        if (null != o) {
            log.info(key+"-"+5+"="+o.toString());

        }
        o = redisTemplate.opsForHash().get(key, "6");
        if (null != o) {
            log.info(key+"-"+6+"="+o.toString());

        }
        o = redisTemplate.opsForHash().get(key, "7");
        if (null != o) {
            log.info(key+"-"+7+"="+o.toString());
        }

         key = "R:RewardLeft:1";
         o = redisTemplate.opsForHash().get(key, "1");
        if (null != o) {
            log.info(key+"-"+1+"="+o.toString());
        }
        o = redisTemplate.opsForHash().get(key, "2");
        if (null != o) {
            log.info(key+"-"+2+"="+o.toString());
        }
        o = redisTemplate.opsForHash().get(key, "3");
        if (null != o) {
            log.info(key+"-"+3+"="+o.toString());
        }
        o = redisTemplate.opsForHash().get(key, "4");
        if (null != o) {
            log.info(key+"-"+4+"="+o.toString());
        }
        o = redisTemplate.opsForHash().get(key, "5");
        if (null != o) {
            log.info(key+"-"+5+"="+o.toString());

        }
        o = redisTemplate.opsForHash().get(key, "6");
        if (null != o) {
            log.info(key+"-"+6+"="+o.toString());

        }
        o = redisTemplate.opsForHash().get(key, "7");
        if (null != o) {
            log.info(key+"-"+7+"="+o.toString());
        }
    }
}
