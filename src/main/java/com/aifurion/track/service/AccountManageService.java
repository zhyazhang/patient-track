package com.aifurion.track.service;

import com.aifurion.track.entity.User;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/3/30 18:59
 */
public interface AccountManageService {

    List<User> getUsers(String nickname, String age, String department, String phone, String type, String did,
                        String pid, String doctorname, String serialnumber);

    void deleteUserRoleByPhone(String phone);


    void editUser(User user);


    void updateUserStatus(String phone, String able);

    void resetUserPwd(String phone);

    void editUserPassword(String password, String userphone);


}
