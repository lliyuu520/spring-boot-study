package com.liliangyu.study.quartz.response;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
 enum AjaxResultEnum {
    /**
     * 成功
     */
    SUCCESS(0,"SUCCESS"),
    /**
     * 服务器异常
     */
    SERVER_EXCEPTION(500,"serverException");
    private Integer key;
    private String value;

    AjaxResultEnum(Integer key, String value) {
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
