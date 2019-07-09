package com.liliangyu.study.quartz.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
@Data
 abstract class BaseEntity implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer delStatus;
}
