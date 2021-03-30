package com.aifurion.blog.controller;

import com.aifurion.blog.common.AjaxResult;
import com.aifurion.blog.entity.User;
import com.aifurion.blog.service.AuthService;
import com.aifurion.blog.shiro.ShiroCacheHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

/**
 * @author ：zzy
 * @description：登录授权等操作
 * @date ：2021/3/22 20:04
 */

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @GetMapping("/login")
    public String getLogin() {

        return "login";

    }


    @GetMapping("/index")
    public String getIndex() {

        return "index";

    }


    @PostMapping("/login")
    @ResponseBody
    public AjaxResult login(@NotNull String username, @NotNull String password) {


        try {

            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);

            subject.login(token);


            return AjaxResult.success("登录成功！");


        } catch (UnknownAccountException e) {

            System.out.println("username is error");
            e.printStackTrace();
            return AjaxResult.error("用户名不存在！");

        } catch (IncorrectCredentialsException e) {

            System.out.println("password is error");
            e.printStackTrace();
            return AjaxResult.error("密码错误！");

        } catch (RuntimeException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
            return AjaxResult.error("服务器错误，请稍后重试！");

        }

    }

    @GetMapping("/register")
    public String getRegister() {


        return "register";
    }


    @ResponseBody
    @PostMapping("/register")
    public AjaxResult register(User user) {

        try {
            boolean registered = authService.registerAccount(user);

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
    public AjaxResult ifUserNameExit(String username) {

        User user = authService.findUserByUsername(username);

        if (!ObjectUtils.isEmpty(user)) {
            return AjaxResult.error("用户名已存在", 501);
        } else {
            return AjaxResult.success();
        }

    }


    @GetMapping("/test")
    public String test() {

        return "char";

    }


}
