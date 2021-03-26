package com.aifurion.blog.common;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/3/23 19:47
 */
public enum CodeType {


    /**
     * 成功
     */
    SUCCESS(200),
    /**
     * 警告
     */
    WARN(301),
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
