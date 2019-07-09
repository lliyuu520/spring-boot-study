package com.liliangyu.study.redis;

import com.liliangyu.study.redis.init.OpsList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liliangyu
 * @date 2019/6/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private OpsList opsList;

    @Test
    public void test1() {
        try {

            opsList.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
