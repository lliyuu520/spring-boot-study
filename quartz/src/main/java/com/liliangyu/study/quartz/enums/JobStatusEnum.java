package com.liliangyu.study.quartz.enums;

/**
 * 任务状态
 * @author liliangyu
 */
 public enum JobStatusEnum{
    /**
     * 运行中
     */
    RUNNING(1,"RUNNING"),
    /**
     * 已删除
     */
    DELETE(2,"DELETE"),
    /**
     * 已暂停
     */
    PAUSED(3,"PAUSED");

    private Integer key;
    private String value;

    JobStatusEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
