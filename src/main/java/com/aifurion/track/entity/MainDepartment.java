package com.aifurion.track.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：zzy
 * @description：TODO 主科室实体类
 * @date ：2021/4/1 9:38
 */
public class MainDepartment implements Serializable {
    private static final long serialVersionUID = 2765302814828844348L;


    private String id;

    private String maindep;

    private List<SecDepartment> secDepartments;

    public MainDepartment() {
    }

    public MainDepartment(String id, String maindep, List<SecDepartment> secDepartments) {
        this.id = id;
        this.maindep = maindep;
        this.secDepartments = secDepartments;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaindep() {
        return maindep;
    }

    public void setMaindep(String maindep) {
        this.maindep = maindep;
    }

    public List<SecDepartment> getSecDepartments() {
        return secDepartments;
    }

    public void setSecDepartments(List<SecDepartment> secDepartments) {
        this.secDepartments = secDepartments;
    }

    @Override
    public String toString() {
        return "MainDepartment{" +
                "id='" + id + '\'' +
                ", maindep='" + maindep + '\'' +
                ", secDepartments=" + secDepartments +
                '}';
    }
}
