package com.aifurion.track.controller;

import com.aifurion.track.common.AjaxResult;
import com.aifurion.track.entity.MainDepartment;
import com.aifurion.track.entity.User;
import com.aifurion.track.service.AuthService;
import com.aifurion.track.service.NoticeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author ：zzy
 * @description：TODO 登录授权等操作
 * @date ：2021/3/22 20:04
 */

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;




    /**
     * @author: zzy
     * @description: TODO 回去登录界面
     * @date: 2021/4/7 21:19
     * @Param: null
     */
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }


    /**
     * @author: zzy
     * @description: TODO 加载相应信息，并返回到界面
     * @date: 2021/4/7 21:20
     * @Param: null
     */
    @GetMapping("/index")
    public String getIndex(Model model) {

        Subject subject = SecurityUtils.getSubject();
        if (!ObjectUtils.isEmpty(subject)) {
            String phone = (String) subject.getPrincipal();

            if (!ObjectUtils.isEmpty(phone)) {

                User user = authService.findRolesByPhone(phone);
                String role = user.getRoles().get(0).getName();
                String username = user.getNickname();

                String roleName = "";

                if ("admin".equals(role)) {
                    roleName = "管理员";
                } else if ("doctor".equals(role)) {
                    roleName = username + " 医生";
                } else if ("patient".equals(role)) {
                    roleName = username + " 患者";
                } else {
                    roleName = username;
                }

                model.addAttribute("roleName", roleName);
                model.addAttribute("user", user);
                return "index";
            }
            return "login";

        } else {
            return "login";
        }


    }


    /**
     * @author: zzy
     * @description: TODO 登录--shiro
     *                  通过抛出的异常判断，密码是否正确等
     * @date: 2021/4/7 21:20
     * @Param: null
     */
    @PostMapping("/login")
    @ResponseBody
    public AjaxResult login(@NotNull String phone, @NotNull String password) {

        try {

            //shiro
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(phone, password);
            User user = authService.findUserByPhone(phone);

            if (!ObjectUtils.isEmpty(user)) {
                if (1 == user.getEnabled()) {

                    //shiro
                    subject.login(token);
                    return AjaxResult.success("登录成功！");
                } else {
                    return AjaxResult.error("账号被禁用，请联系管理员");
                }

            } else {
                return AjaxResult.error("不存在此账号，请重试！");
            }


        } catch (UnknownAccountException e) {

            System.out.println("username is error");
            // e.printStackTrace();
            return AjaxResult.error("用户名不存在！");

        } catch (IncorrectCredentialsException e) {

            System.out.println("password is error");
            // e.printStackTrace();
            return AjaxResult.error("密码错误！");

        } catch (RuntimeException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
            return AjaxResult.error("服务器错误，请稍后重试！");

        }

    }

    /**
     * @author: zzy
     * @description: TODO 返回注册页面
     * @date: 2021/4/7 21:22
     * @Param: null
     */
    @GetMapping("/register")
    public String getRegister() {


        return "register";
    }

    @GetMapping("/doctorRegister")
    public String getDoctorRegister(Model model) {


        List<MainDepartment> allDepartment = authService.findAllDepartment();
        // System.out.println(allDepartment);

        model.addAttribute("departments", allDepartment);

        return "register_doctor";
    }


    /**
     * @author: zzy
     * @description: TODO 注册
     * @date: 2021/4/7 21:23
     * @Param: null
     */
    @ResponseBody
    @PostMapping("/register/{type}")
    public AjaxResult register(User user, @PathVariable String type) {


        try {

            boolean registered = authService.registerAccount(user, type);
            if (registered) {
                return AjaxResult.success();

            } else {
                return AjaxResult.error("用户名已存在", 501);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("运行出错，请稍后再试", 502);
        }
    }


    /**
     * @author: zzy
     * @description: TODO 登出
     * @date: 2021/4/7 21:23
     * @Param: null
     */
    @GetMapping("/logout")
    public String logout() {

        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    /**
     * @author: zzy
     * @description: TODO 判断用户名是否存在
     * @date: 2021/3/26 20:03
     * @Param: null
     */

    @PostMapping("/ifUsernameExit")
    @ResponseBody
    public AjaxResult ifUserNameExit(String phone) {

        User user = authService.findUserByPhone(phone);

        if (!ObjectUtils.isEmpty(user)) {
            return AjaxResult.error("用户名已存在", 501);
        } else {
            return AjaxResult.success();
        }

    }

    /**
     * @author: zzy
     * @description: TODO 判断工号是否存在
     * @date: 2021/4/7 21:23
     * @Param: null
     */
    @PostMapping("/ifSerialNumberExit")
    @ResponseBody
    public AjaxResult ifSerialNumberExit(String number) {


        User user = authService.findUserBySerialNumber(number);

        if (!ObjectUtils.isEmpty(user)) {
            return AjaxResult.error("工号已存在，请正确输入！", 501);
        } else {
            return AjaxResult.success();
        }

    }

    /**
     * @author: zzy
     * @description: TODO 挂号时判断病人手机号是否存在
     * @date: 2021/4/7 21:24
     * @Param: null
     */
    @PostMapping("/ifPatientPhoneExit")
    @ResponseBody
    public AjaxResult ifPatientPhoneExit(String phone) {


        String name = authService.findPatientByPhone(phone);

        if (ObjectUtils.isEmpty(name)) {
            return AjaxResult.error();
        } else {
            return AjaxResult.success();
        }

    }


}
