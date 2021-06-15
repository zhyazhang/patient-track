package com.aifurion.track.entity;

import java.io.Serializable;

/**
 * @author ：zzy
 * @description：TODO 权限实体类
 * @date ：2021/3/23 9:34
 */
public class Permission implements Serializable {

    private static final long serialVersionUID = -2883366416409981684L;
    private String id;


    private String name;


    private String url;

    public Permission() {
    }

    public Permission(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
