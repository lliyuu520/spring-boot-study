package com.liliangyu.study.quartz.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liliangyu.study.quartz.entity.JobEntity;
import com.liliangyu.study.quartz.response.AjaxResult;
import com.liliangyu.study.quartz.service.JobEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
@RestController
@RequestMapping("/jobEntity")
@Slf4j
public class JobEntityController {
    @Autowired
    private JobEntityService jobEntityService;

    @PostMapping("/list")
    public AjaxResult addOne() {
        log.info("查询任务:" );
        try {
            Page<JobEntity> page = new Page<>();
             jobEntityService.page(page);
            return AjaxResult.success(page);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            return AjaxResult.serverExcetion();
        }
    }

    @PostMapping("/add")
    public AjaxResult addOne(@Validated @RequestBody JobEntity jobEntity) {
        log.info("添加任务:" + jobEntity);
        try {
            jobEntity.setCreateTime(LocalDateTime.now());
            jobEntityService.saveJob(jobEntity);
            return AjaxResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            return AjaxResult.serverExcetion();
        }
    }

    @PostMapping("/run")
    public AjaxResult run(Long id) {
        log.info("启动任务:" + id);
        try {
            jobEntityService.triggerJob(id);
            return AjaxResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            return AjaxResult.serverExcetion();
        }
    }

    @PostMapping("/pause")
    public AjaxResult pause(Long id) {
        log.info("暂停任务:" + id);
        try {
            jobEntityService.pauseJob(id);
            return AjaxResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            return AjaxResult.serverExcetion();
        }
    }

    @PostMapping("/resume")
    public AjaxResult resume(Long id) {
        log.info("恢复任务:" + id);
        try {
            jobEntityService.resumeJob(id);
            return AjaxResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            return AjaxResult.serverExcetion();
        }
    }

    @PostMapping("/remove")
    public AjaxResult remove(Long id) {
        log.info("移除任务:" + id);
        try {
            jobEntityService.resumeJob(id);
            return AjaxResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            return AjaxResult.serverExcetion();
        }
    }

}
