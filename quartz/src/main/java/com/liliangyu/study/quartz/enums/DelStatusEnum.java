package com.liliangyu.study.quartz.enums;

/**
 * 任务状态
 * @author liliangyu
 */
 public enum DelStatusEnum {
    /**
     * 逻辑删除数据
     */
    DELETE(1),
    /**
     * 正常数据
     */
    NONE(0);


    private Integer key;

    DelStatusEnum(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

}
