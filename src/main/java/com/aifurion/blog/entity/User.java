package com.aifurion.blog.entity;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/3/22 20:03
 */
public class User {

    private String id;

    private String username;

    private String nickname;

    private String password;

    private Integer enabled;

    private String email;

    private String userface;

    private String regTime;

    private String salt;

    private List<Role> roles;


    public User() {
    }


    public User(String id, String username, String nickname, String password,
                Integer enabled, String email, String userface, String regTime,
                String salt, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
        this.userface = userface;
        this.regTime = regTime;
        this.salt = salt;
        this.roles = roles;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", email='" + email + '\'' +
                ", userface='" + userface + '\'' +
                ", regTime='" + regTime + '\'' +
                ", salt='" + salt + '\'' +
                ", roles=" + roles +
                '}';
    }
}
