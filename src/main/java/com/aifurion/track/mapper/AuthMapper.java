package com.aifurion.track.mapper;

import com.aifurion.track.entity.MainDepartment;
import com.aifurion.track.entity.Permission;
import com.aifurion.track.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO 授权相关持久化方法
 * @date ：2021/3/22 20:05
 */

@Mapper
public interface AuthMapper {

    User findUserByPhone(String phone);

    String findPatientByPhone(String phone);

    User findUserBySerialNumber(String number);

    int registerAccount(User user);

    int findIdByPhone(String phone);

    int registerRoleForNewUser(String roleid, int patientId);

    User findRolesByPhone(String phone);

    List<Permission> findPermissionByRoleId(String id);

    List<MainDepartment> findAllDepartment();


}
