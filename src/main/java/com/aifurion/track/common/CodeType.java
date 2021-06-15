package com.aifurion.track.common;

/**
 * @author ：zzy
 * @description：TODO 返回信息的状态码
 * @date ：2021/3/23 19:47
 */
public enum CodeType {


    /**
     * 状态
     */

    STATUS(100),

    /**
     * 成功
     */
    SUCCESS(200),

    /**
     * 警告
     */
    WARN(300),

    /**
     * 错误
     */
    ERROR(500);


    private final int value;

    CodeType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

}
