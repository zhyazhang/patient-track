package com.aifurion.track.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：zzy
 * @description：TODO 用户实体类
 * @date ：2021/3/22 20:03
 */
public class User implements Serializable {


    private static final long serialVersionUID = -660851000070107785L;

    private String id;

    private String phone;

    private Integer age;

    private String nickname;

    private String password;

    private String salt;

    private Integer enabled;

    private String gender;

    private String secdepid;

    private String maindepid;

    private String email;

    private String serialnumber;

    private String regTime;


    private List<Role> roles;


    public User() {
    }

    public User(String id, String phone, Integer age, String nickname, String password, String salt, Integer enabled, String gender, String secdepid, String maindepid, String email, String serialnumber, String regTime, List<Role> roles) {
        this.id = id;
        this.phone = phone;
        this.age = age;
        this.nickname = nickname;
        this.password = password;
        this.salt = salt;
        this.enabled = enabled;
        this.gender = gender;
        this.secdepid = secdepid;
        this.maindepid = maindepid;
        this.email = email;
        this.serialnumber = serialnumber;
        this.regTime = regTime;
        this.roles = roles;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSecdepid() {
        return secdepid;
    }

    public void setSecdepid(String secdepid) {
        this.secdepid = secdepid;
    }

    public String getMaindepid() {
        return maindepid;
    }

    public void setMaindepid(String maindepid) {
        this.maindepid = maindepid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", age='" + age + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", enabled=" + enabled +
                ", gender='" + gender + '\'' +
                ", secdepid='" + secdepid + '\'' +
                ", maindepid='" + maindepid + '\'' +
                ", email='" + email + '\'' +
                ", serialnumber='" + serialnumber + '\'' +
                ", regTime='" + regTime + '\'' +
                ", roles=" + roles +
                '}';
    }
}
