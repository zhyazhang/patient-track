package com.aifurion.blog.common;

import org.springframework.util.ObjectUtils;

import java.util.HashMap;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/3/23 19:43
 */
public class AjaxResult extends HashMap<String, Object> {

    private static final long serialVersionUID = -2026940795598330604L;

    /* 状态码*/
    private final String codeTag = "code";

    /* 消息*/
    private final String msgTag = "msg";

    /* 数据对象*/
    private final String dataTag = "data";


    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public AjaxResult() {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param type 状态类型
     * @param msg  返回内容
     */
    public AjaxResult(CodeType type, String msg) {
        super.put(codeTag, type.value());
        super.put(msgTag, msg);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param type 状态类型
     * @param msg  返回内容
     * @param data 数据对象
     */
    public AjaxResult(CodeType type, String msg, Object data) {
        super.put(codeTag, type.value());
        super.put(msgTag, msg);
        if (!ObjectUtils.isEmpty(data)) {
            super.put(dataTag, data);
        }
    }

    /**
     * 方便链式调用
     *
     * @param key   键
     * @param value 值
     * @return 数据对象
     */
    @Override
    public AjaxResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static AjaxResult success() {
        return success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static AjaxResult success(Object data) {
        return success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static AjaxResult success(String msg) {
        return success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static AjaxResult success(String msg, Object data) {
        return new AjaxResult(CodeType.SUCCESS, msg, data);
    }


    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static AjaxResult warn(String msg) {
        return AjaxResult.warn(msg, null);
    }

    /**
     * 返回警告消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static AjaxResult warn(String msg, Object data) {
        return new AjaxResult(CodeType.WARN, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static AjaxResult error() {
        return AjaxResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static AjaxResult error(String msg) {
        return AjaxResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static AjaxResult error(String msg, Object data) {
        return new AjaxResult(CodeType.ERROR, msg, data);
    }



    /**
     * 返回状态消息
     *
     * @return 状态消息
     */
    public static AjaxResult status() {
        return status("状态");
    }

    /**
     * 返回状态数据
     *
     * @return 状态消息
     */
    public static AjaxResult status(Object data) {
        return status("状态", data);
    }

    /**
     * 返回状态消息
     *
     * @param msg 返回内容
     * @return 状态消息
     */
    public static AjaxResult status(String msg) {
        return status(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 状态消息
     */
    public static AjaxResult status(String msg, Object data) {
        return new AjaxResult(CodeType.STATUS, msg, data);
    }













}
