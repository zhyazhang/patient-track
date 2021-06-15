package com.aifurion.track.service.impl;

import com.aifurion.track.Utils.SaltUtils;
import com.aifurion.track.entity.MainDepartment;
import com.aifurion.track.entity.Permission;
import com.aifurion.track.entity.User;
import com.aifurion.track.entity.UserAndRole;
import com.aifurion.track.mapper.AuthMapper;
import com.aifurion.track.service.AuthService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ：zzy
 * @description：TODO 授权相关方法
 * @date ：2021/3/23 9:27
 */

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;


    @Override
    public String findPatientByPhone(String phone) {

        return authMapper.findPatientByPhone(phone);
    }

    @Override
    public User findUserBySerialNumber(String number) {

        return authMapper.findUserBySerialNumber(number);
    }

    @Override
    public List<MainDepartment> findAllDepartment() {

        return authMapper.findAllDepartment();
    }

    @Override
    public List<Permission> findPermissionByRoleId(String id) {

        return authMapper.findPermissionByRoleId(id);
    }

    @Override
    public User findRolesByPhone(String phone) {
        return authMapper.findRolesByPhone(phone);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean registerAccount(User user, String type) {



        User theUser = authMapper.findUserByPhone(user.getPhone());

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

            UserAndRole userAndRole;


           /* if ("2".equals(type)) {
                user.setEnabled(0);
            } else {
                user.setEnabled(1);
            }*/


            user.setEnabled(1);

            authMapper.registerAccount(user);
            int userID = authMapper.findIdByPhone(user.getPhone());
            authMapper.registerRoleForNewUser(type, userID);

            return true;

        } else {

            return false;
        }


    }

    @Override
    public User findUserByPhone(String phone) {

        return authMapper.findUserByPhone(phone);
    }


}
