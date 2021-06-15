package com.aifurion.track.entity;

import java.io.Serializable;

/**
 * @author ：zzy
 * @description：TODO 次科室 实体类
 * @date ：2021/4/1 9:40
 */
public class SecDepartment implements Serializable {
    private static final long serialVersionUID = 5656076569866126486L;


    private String id;

    private String secdep;


    public SecDepartment() {
    }


    public SecDepartment(String id, String secdep) {
        this.id = id;
        this.secdep = secdep;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecdep() {
        return secdep;
    }

    public void setSecdep(String secdep) {
        this.secdep = secdep;
    }

    @Override
    public String toString() {
        return "SecDepartment{" +
                "id='" + id + '\'' +
                ", secdep='" + secdep + '\'' +
                '}';
    }
}
