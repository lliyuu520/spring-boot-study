package com.liliangyu.study.quartz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liliangyu.study.quartz.entity.JobEntity;
import com.liliangyu.study.quartz.enums.DelStatusEnum;
import com.liliangyu.study.quartz.enums.JobStatusEnum;
import com.liliangyu.study.quartz.mapper.JobEntityMapper;
import com.liliangyu.study.quartz.service.JobEntityService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class JobEntityServiceImpl extends ServiceImpl<JobEntityMapper, JobEntity> implements JobEntityService {

    @Autowired
    private Scheduler scheduler;

    @Override
    public void saveJob(JobEntity quartz)throws ClassNotFoundException,SchedulerException {
        schedulerJob(quartz);
        quartz.setDelStatus(DelStatusEnum.NONE.getKey());
        quartz.setJobStatus(JobStatusEnum.RUNNING.getKey());
        this.save(quartz);
    }

    @Override
    public void triggerJob(Long id) throws SchedulerException {
        JobEntity jobEntity = this.getById(id);

        if (jobEntity != null) {
            JobKey key = new JobKey(jobEntity.getJobName(), jobEntity.getJobGroup());
            scheduler.triggerJob(key);
            log.info("任务ID"+id+"触发成功");
        }else {
            log.error("任务ID"+id+"不存在!已忽略");
        }
    }

    @Override
    public void pauseJob(Long id)  throws SchedulerException{
        JobEntity jobEntity = this.getById(id);
        if (jobEntity != null) {
            JobKey key = new JobKey(jobEntity.getJobName(), jobEntity.getJobGroup());
            scheduler.pauseJob(key);
            jobEntity.setJobStatus(JobStatusEnum.PAUSED.getKey());
            jobEntity.setUpdateTime(LocalDateTime.now());
            updateById(jobEntity);
            log.info("任务ID"+id+"暂停成功");
        }else {
            log.error("任务ID"+id+"不存在!已忽略");
        }
    }

    @Override
    public void resumeJob(Long id)throws SchedulerException {
        JobEntity jobEntity = this.getById(id);
        if (jobEntity != null) {
            JobKey key = new JobKey(jobEntity.getJobName(), jobEntity.getJobGroup());
            scheduler.resumeJob(key);
            jobEntity.setJobStatus(JobStatusEnum.RUNNING.getKey());
            jobEntity.setUpdateTime(LocalDateTime.now());
            updateById(jobEntity);
            log.info("任务ID"+id+"恢复成功");
        }else {
            log.error("任务ID"+id+"不存在!已忽略");
        }
    }

    @Override
    public void removeJob(Long id)throws SchedulerException {
        JobEntity jobEntity = this.getById(id);
        if (jobEntity != null) {
            String jobName = jobEntity.getJobName();
            String jobGroup = jobEntity.getJobGroup();
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(JobKey.jobKey(jobName, jobGroup));
            jobEntity.setJobStatus(JobStatusEnum.DELETE.getKey());
            jobEntity.setDelTime(LocalDateTime.now());
            updateById(jobEntity);
            log.info("任务ID"+id+"删除成功");
        }else {
            log.error("任务ID"+id+"不存在!已忽略");
        }
    }

    @Override
    public void updateJob(JobEntity quartz) {

    }

    /**
     * 执行任务
     * @param job 任务
     * @throws ClassNotFoundException 未找到类
     * @throws SchedulerException 任务保错
     */
    private void schedulerJob(JobEntity job)throws ClassNotFoundException,SchedulerException {

        //构建job信息
        String jobClassname = job.getJobClassname();
        Class cls = Class.forName(jobClassname);
        JobDetail jobDetail = JobBuilder.newJob(cls).withIdentity(job.getJobName(), job.getJobGroup()).withDescription(job.getDescription()).build();

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression().trim());
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup())
                .startNow().withSchedule(cronScheduleBuilder).build();
        //交由Scheduler安排触发
        scheduler.scheduleJob(jobDetail, trigger);

    }
}
