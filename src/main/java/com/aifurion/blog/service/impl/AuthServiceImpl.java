package com.aifurion.blog.service.impl;

import com.aifurion.blog.Utils.SaltUtils;
import com.aifurion.blog.entity.Permission;
import com.aifurion.blog.entity.User;
import com.aifurion.blog.mapper.AuthMapper;
import com.aifurion.blog.service.AuthService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/3/23 9:27
 */

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;


    @Override
    public List<Permission> findPermissionByRoleId(String id) {

        return authMapper.findPermissionByRoleId(id);
    }

    @Override
    public User findRolesByUsername(String userName) {
        return authMapper.findRolesByUsername(userName);
    }

    @Override
    public boolean registerAccount(User user) {


        User theUser = authMapper.findUserByUsername(user.getUsername());


        //判断用户名是否存在
        if (ObjectUtils.isEmpty(theUser)) {

            // 产生20位随机盐
            String salt = SaltUtils.getSalt(20);
            user.setSalt(salt);

            //注册时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String registerTime = simpleDateFormat.format(date);
            user.setRegTime(registerTime);

            //使用md5加密
            Md5Hash hash = new Md5Hash(user.getPassword(), salt, 1024);
            user.setPassword(hash.toHex());
            authMapper.saveAccount(user);

            return true;

        } else {

            return false;
        }


    }

    @Override
    public User findUserByUsername(String userName) {

        return authMapper.findUserByUsername(userName);
    }
}
