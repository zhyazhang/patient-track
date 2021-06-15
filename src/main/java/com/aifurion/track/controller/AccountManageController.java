package com.aifurion.track.controller;

import com.aifurion.track.common.AjaxResult;
import com.aifurion.track.entity.MainDepartment;
import com.aifurion.track.entity.User;
import com.aifurion.track.service.AccountManageService;
import com.aifurion.track.service.AuthService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO 个人账户管理类
 * @date ：2021/3/26 8:37
 */

@Controller
@RequestMapping("/account")
public class AccountManageController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AccountManageService accountManageService;


    /**
     * @author: zzy
     * @description: TODO 管理用户状态，1可用，0不可用
     * @date: 2021/4/7 21:10
     * @Param: null
     */

    @PostMapping("/editstatus")
    @ResponseBody
    @RequiresRoles("admin")
    public AjaxResult editUserStatus(Model model, String phonelist, String able) {

        try {
            accountManageService.updateUserStatus(phonelist, able);
            return AjaxResult.success();
        } catch (Exception e) {

            e.printStackTrace();
            return AjaxResult.error("服务器出错，请稍后重试！");

        }

    }


    /**
     * @author: zzy
     * @description: TODO 重置用户密码
     * @date: 2021/4/7 21:11
     * @Param: null
     */
    @PostMapping("/resetpwd")
    @ResponseBody
    public AjaxResult resetUserPwd(Model model, String phonelist) {


        try {
            accountManageService.resetUserPwd(phonelist);
            return AjaxResult.success();
        } catch (Exception e) {

            e.printStackTrace();
            return AjaxResult.error("服务器出错，请稍后重试！");

        }

    }


    /**
     * @author: zzy
     * @description: TODO 获取修改密码页面
     * @date: 2021/4/7 21:11
     * @Param: null
     */
    @GetMapping("/editpwd")
    public String getEditPasswordPage() {

        return "update_password";
    }

    /**
     * @author: zzy
     * @description: TODO 修改用户密码
     * @date: 2021/4/7 21:11
     * @Param: null
     */
    @PostMapping("/editpwd")
    @ResponseBody
    public AjaxResult editPassword(String password) {


        Subject subject = SecurityUtils.getSubject();
        String userphone = (String) subject.getPrincipal();

        try {
            accountManageService.editUserPassword(password, userphone);
            subject.logout();

            return AjaxResult.success();

        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("服务器出错，请稍后重试！");

        }

    }

    /**
     * @author: zzy
     * @description: TODO 修改密码时判断原密码输入是否正确
     * @date: 2021/4/7 21:12
     * @Param: null
     */

    @PostMapping("/ifPWDCorrect")
    @ResponseBody
    public AjaxResult pwdCorrect(String password) {

        Subject subject = SecurityUtils.getSubject();
        String userphone = (String) subject.getPrincipal();
        User user = authService.findUserByPhone(userphone);
        String md5Password = new Md5Hash(password, user.getSalt(), 1024).toHex();


        if (md5Password.equals(user.getPassword())) {
            return AjaxResult.success();

        } else {
            return AjaxResult.error("原密码输入错误！");
        }

    }


    /**
     * @author: zzy
     * @description: TODO 修改个人信息
     * @date: 2021/4/7 21:12
     * @Param: null
     */
    @PostMapping("/edituser")
    @ResponseBody
    public AjaxResult editUser(User user) {


        try {
            accountManageService.editUser(user);
            return AjaxResult.success("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("服务器出错，请稍后重试！");
        }

    }


    /**
     * @author: zzy
     * @description: TODO 返回修改医生个人信息的界面
     * @date: 2021/4/7 21:13
     * @Param: null
     */
    @GetMapping("/editdoctor/{phone}")
    public String getEditDoctorPage(@PathVariable("phone") String userPhone, Model model) {

        User user = null;
        List<MainDepartment> allDepartment = null;

        String flag = "1";


        String roleId =
                authService.findRolesByPhone((String) SecurityUtils.getSubject().getPrincipal()).getRoles().get(0).getId();


        //   String roleId = "1";

        user = authService.findRolesByPhone(userPhone);
        allDepartment = authService.findAllDepartment();

        model.addAttribute("departments", allDepartment);
        model.addAttribute("user", user);
        model.addAttribute("flag", flag);
        model.addAttribute("theRoleId", roleId);


        return "account/edit_doctor";
    }

    /**
     * @author: zzy
     * @description: TODO 返回修改病人的界面
     * @date: 2021/4/7 21:14
     * @Param: null
     */

    @GetMapping("/editpatient/{phone}")
    public String getEditPatientPage(@PathVariable("phone") String userPhone, Model model) {


        User user = null;
        List<MainDepartment> allDepartment = null;


        String flag = "1";

        String roleId =
                authService.findRolesByPhone((String) SecurityUtils.getSubject().getPrincipal()).getRoles().get(0).getId();

        //修改
        user = authService.findRolesByPhone(userPhone);
        allDepartment = authService.findAllDepartment();


        model.addAttribute("departments", allDepartment);
        model.addAttribute("user", user);
        model.addAttribute("flag", flag);

        model.addAttribute("theRoleId", roleId);


        return "account/edit_patient";
    }

    /**
     * @author: zzy
     * @description: TODO 删除用户
     * @date: 2021/4/7 21:14
     * @Param: null
     */

    // @ResponseBody
    @GetMapping("/deleteuser/{phone}")
    public String deletePatientUser(@PathVariable("phone") String userPhone, Model model) {

        String id = authService.findRolesByPhone(userPhone).getRoles().get(0).getId();
        try {
            accountManageService.deleteUserRoleByPhone(userPhone);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if ("2".equals(id)) {
            return "redirect:/account/getusers?type=3";

        } else {
            return "redirect:/account/getusers?type=2";
        }

    }


    /**
     * @author: zzy
     * @description: TODO 得到用户信息，并返回到相应界面
     * @date: 2021/3/31 17:07
     * @Param: type 1:获取所有用户
     * 2：获取所有病人
     * 3：获取所有医生
     */
    @GetMapping("/getusers")
    public String getAllUser(Model model,
                             @RequestParam(required = false, defaultValue = "") String nickname,
                             @RequestParam(required = false, defaultValue = "") String age,
                             @RequestParam(required = false, defaultValue = "") String department,
                             @RequestParam(required = false, defaultValue = "") String phone,
                             @RequestParam(required = false, defaultValue = "") String did,
                             @RequestParam(required = false, defaultValue = "") String pid,
                             @RequestParam(required = false, defaultValue = "") String type,
                             @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {


        //PageHelper 分页插件



        PageHelper.startPage(pageNum, 10);
        List<User> allUsers = accountManageService.getUsers(nickname, age, department, phone, type, did, pid, "", "");
        PageInfo<User> pageUsers = new PageInfo<>(allUsers);
        // model.addAttribute("users", allUsers);
        model.addAttribute("users", pageUsers);


        //判断角色加载相应信息，并返回到相应界面
        switch (type) {
            case "2":
                return "account/manage_doctor";
            case "3":
                return "account/manage_patient";
            case "4":

                List<MainDepartment> allDepartment = authService.findAllDepartment();
                model.addAttribute("departments", allDepartment);
                return "account/manage_registrar";
            default:
                return "account/manage_patient";
        }


    }


    @GetMapping("/gethistoryusers")
    public String getHistoryUser(Model model,
                                 @RequestParam(required = false, defaultValue = "") String nickname,
                                 @RequestParam(required = false, defaultValue = "") String age,
                                 @RequestParam(required = false, defaultValue = "") String department,
                                 @RequestParam(required = false, defaultValue = "") String phone,
                                 @RequestParam(required = false, defaultValue = "") String doctorname,
                                 @RequestParam(required = false, defaultValue = "") String serialnumber,
                                 @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        String did = "";
        String pid = "";
        String type = "2";
        String userPhone = (String) SecurityUtils.getSubject().getPrincipal();
        User rolesByPhone = authService.findRolesByPhone(userPhone);
        String roleName = rolesByPhone.getRoles().get(0).getName();

        if ("doctor".equals(roleName)) {
            type = "3";
            did = rolesByPhone.getId();
        } else if ("patient".equals(roleName)) {
            type = "2";
            pid = rolesByPhone.getId();
        }

        System.out.println("nickname " + nickname + "department " + department + "doctorname " + doctorname +
                "serialnumber " + serialnumber + "did " + did+"pid "+pid);


        PageHelper.startPage(pageNum, 10);
        List<User> allUsers = accountManageService.getUsers(nickname, age, department, phone, type, did, pid,
                doctorname, serialnumber);
        PageInfo<User> pageUser = new PageInfo<>(allUsers);
        model.addAttribute("users", pageUser);
        if ("doctor".equals(roleName)) {
            return "history/all_accepts_patient";
        } else {

            return "history/all_accepts_doctor";
        }

    }


}
