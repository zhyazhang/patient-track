package com.aifurion.blog.service;

import com.aifurion.blog.entity.Permission;
import com.aifurion.blog.entity.User;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/3/23 9:27
 */
public interface UserService {


    User findUserByUsername(String userName);


    void registerAccount(User user);


    User findRolesByUsername(String userName);


    List<Permission> findPermissionByRoleId(String id);



}
