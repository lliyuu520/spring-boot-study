package com.liliangyu.study.quartz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liliangyu.study.quartz.entity.JobEntity;
import org.quartz.SchedulerException;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
public interface JobEntityService extends IService<JobEntity> {


    /**
     * 新增job
     * @param quartz 任务
     * @throws ClassNotFoundException 未找到该类
     * @throws SchedulerException 任务执行保存
     */
    void saveJob(JobEntity quartz)throws ClassNotFoundException,SchedulerException;

    /**
     * 手动触发
     * @param id id
     * @throws SchedulerException 任务触发失败
     */
    void triggerJob(Long id)throws SchedulerException;

    /**
     * 暂停job
     * @param id
     * @throws SchedulerException 任务
     */
    void pauseJob(Long  id) throws SchedulerException;

    /**
     * 恢复job
     * @param id id
      * @throws SchedulerException 任务触发失败
     */
    void resumeJob(Long  id)throws SchedulerException;

    /**
     * 移除job
     * @param id id
     * @throws SchedulerException 任务报错
     */
    void removeJob(Long  id)throws SchedulerException;


    /**
     * 修改
     * @param quartz 任务
     */
    void updateJob(JobEntity quartz);


}
