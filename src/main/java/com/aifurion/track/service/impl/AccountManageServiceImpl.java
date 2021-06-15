package com.aifurion.track.service.impl;

import com.aifurion.track.Utils.SaltUtils;
import com.aifurion.track.entity.User;
import com.aifurion.track.mapper.AccountManageMapper;
import com.aifurion.track.mapper.AuthMapper;
import com.aifurion.track.service.AccountManageService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO 账号相关方法
 * @date ：2021/3/30 18:59
 */

@Service
public class AccountManageServiceImpl implements AccountManageService {


    @Autowired
    private AccountManageMapper accountManageMapper;

    @Autowired
    private AuthMapper authMapper;

    @Value("${var.defaultPwd}")
    private String defaultPwd;


    @Override
    public void editUserPassword(String password, String userphone) {

        String salt = SaltUtils.getSalt(20);

        String md5Password = new Md5Hash(password, salt, 1024).toHex();

        accountManageMapper.editUserPassword(md5Password, salt, userphone);


    }

    @Override
    public void updateUserStatus(String phonelist, String able) {

        String[] phones = phonelist.split("\\.");
        for (String phone : phones) {
            accountManageMapper.updateUserStatus(phone, able);
        }

    }

    @Override
    public void resetUserPwd(String phonelist) {

        String[] phones = phonelist.split("\\.");

        for (String phone : phones) {



            String salt = SaltUtils.getSalt(20);
            String md5Password = new Md5Hash(defaultPwd, salt, 1024).toHex();
            accountManageMapper.editUserPassword(md5Password, salt, phone);
        }


    }

    @Override
    public void editUser(User user) {

        if ("-1".equals(user.getMaindepid())) {
            user.setMaindepid(null);
        }
        if ("-1".equals(user.getSecdepid())) {
            user.setSecdepid(null);

        }

        //System.out.println(user);
        accountManageMapper.editUser(user);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserRoleByPhone(String phone) {

        int id = authMapper.findIdByPhone(phone);
        accountManageMapper.deleteRoleOfUserByUserID(String.valueOf(id));
        accountManageMapper.deleteUserByPhone(phone);
    }

    /**
     * @author: zzy
     * @description: TODO 获取所有用户
     * @date: 2021/3/31 16:24
     * @Param: type 1:获取所有用户
     * 2：获取所有病人
     * 3：获取所有医生
     */
    @Override
    public List<User> getUsers(String nickname, String age, String department, String phone, String type, String did,
                               String pid,String doctorname,String serialnumber) {


        List<User> allUsers = null;

        allUsers = accountManageMapper.getUsers(nickname, age, department, phone, type, did, pid,doctorname,serialnumber);

        return allUsers;
    }


}
