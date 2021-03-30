package com.aifurion.blog.mapper;

import com.aifurion.blog.entity.Permission;
import com.aifurion.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/3/22 20:05
 */

@Mapper
public interface AuthMapper {

    User findUserByUsername(String userName);

    void saveAccount(User user);

    User findRolesByUsername(String userName);

    List<Permission> findPermissionByRoleId(String id);




}
