package com.aifurion.blog.service.impl;

import com.aifurion.blog.Utils.SaltUtils;
import com.aifurion.blog.entity.Permission;
import com.aifurion.blog.entity.User;
import com.aifurion.blog.mapper.UserMapper;
import com.aifurion.blog.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/3/23 9:27
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<Permission> findPermissionByRoleId(String id) {

        return userMapper.findPermissionByRoleId(id);
    }

    @Override
    public User findRolesByUsername(String userName) {
        return userMapper.findRolesByUsername(userName);
    }

    @Override
    public void registerAccount(User user) {

        /*

        产生20位随机盐

         */
        String salt = SaltUtils.getSalt(20);
        user.setSalt(salt);


        /*

        使用md5加密

         */
        Md5Hash hash = new Md5Hash(user.getPassword(), salt, 1024);
        user.setPassword(hash.toHex());
        userMapper.saveAccount(user);

    }

    @Override
    public User findUserByUsername(String userName) {

        return userMapper.findUserByUsername(userName);
    }
}
