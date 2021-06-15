package com.aifurion.track.mapper;

import com.aifurion.track.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO 账号相关持久化方法
 * @date ：2021/3/30 18:59
 */

@Mapper
public interface AccountManageMapper {


    List<User> getUsers(String nickname, String age, String department, String phone, String type, String did,
                        String pid, String doctorname, String serialnumber);

    String findDepartmentNameByID(String departmentID);

    void deleteUserByPhone(String phone);

    void deleteRoleOfUserByUserID(String userID);

    void editUser(User user);

    void updateUserStatus(String phone, String able);

    void editUserPassword(String password, String salt, String userphone);


}
