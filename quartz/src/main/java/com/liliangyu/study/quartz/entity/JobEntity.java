package com.liliangyu.study.quartz.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
@TableName("t_job_entity")
@Data
@EqualsAndHashCode(callSuper = true)

public class JobEntity extends BaseEntity {

    /**
     * /任务名称
     */
    @NotNull
    private String jobName;
    /**
     * 任务分组
     */
    @NotNull
    private String jobGroup;
    /**
     * 描述
     */
    @NotNull
    private String description;
    /**
     * 执行类名称
     */
    @NotNull
    private String jobClassname;
    /**
     * 表达式
     */
    @NotNull
    private String cronExpression;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    /**
     * 删除
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime delTime;
    /**
     * 任务状态
     */

    private Integer jobStatus;

}
