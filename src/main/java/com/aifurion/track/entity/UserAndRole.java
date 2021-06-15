package com.aifurion.track.entity;

import java.io.Serializable;

/**
 * @author ：zzy
 * @description：TODO 用户和角色实体类
 * @date ：2021/4/1 21:06
 */
public class UserAndRole implements Serializable {

    private static final long serialVersionUID = -6530419446584539538L;

    private String id;

    private String roleid;

    private String userid;

    public UserAndRole() {
    }

    public UserAndRole(String id, String roleid, String userid) {
        this.id = id;
        this.roleid = roleid;
        this.userid = userid;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "UserAndRole{" +
                "id='" + id + '\'' +
                ", roleid='" + roleid + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }
}

