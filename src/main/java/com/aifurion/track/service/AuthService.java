package com.aifurion.track.service;

import com.aifurion.track.entity.MainDepartment;
import com.aifurion.track.entity.Permission;
import com.aifurion.track.entity.User;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/3/23 9:27
 */
public interface AuthService {


    User findUserByPhone(String phone);

    String findPatientByPhone(String phone);

    User findUserBySerialNumber(String number);

    boolean registerAccount(User user, String type);


    User findRolesByPhone(String phone);

    List<Permission> findPermissionByRoleId(String id);


    List<MainDepartment> findAllDepartment();


}
