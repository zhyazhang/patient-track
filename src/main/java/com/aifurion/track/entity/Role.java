package com.aifurion.track.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：zzy
 * @description：TODO 角色实体类
 * @date ：2021/3/23 9:33
 */
public class Role implements Serializable {


    private static final long serialVersionUID = 3780622062486725133L;
    private String id;

    private String name;

    private List<Permission> permissions;

    public Role() {
    }

    public Role(String id, String name, List<Permission> permissions) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
