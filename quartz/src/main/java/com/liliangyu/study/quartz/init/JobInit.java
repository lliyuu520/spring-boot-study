package com.liliangyu.study.quartz.init;

import com.liliangyu.study.quartz.entity.JobEntity;
import com.liliangyu.study.quartz.enums.JobStatusEnum;
import com.liliangyu.study.quartz.service.JobEntityService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
@Component
@Slf4j
public class JobInit implements CommandLineRunner {

    @Autowired
    private JobEntityService jobEntityService;


    @Override
    public void run(String... args) throws Exception {
        loadJobToQuartz();
    }


    private void loadJobToQuartz() {
        log.info("初始化任务......");
        List<JobEntity> list = jobEntityService.list();
        if (list.isEmpty()) {
            log.info("初始化任务......0条");
            return;
        }
        log.info("初始化任务......" + list.size() + "条");

    }

}
