package com.liliangyu.study.quartz.job;

import lombok.extern.java.Log;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalTime;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
@Log
public class PrintJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("当前时间:" + LocalTime.now());
    }
}
