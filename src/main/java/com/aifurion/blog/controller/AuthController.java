package com.aifurion.blog.controller;

import com.aifurion.blog.common.AjaxResult;
import com.aifurion.blog.entity.User;
import com.aifurion.blog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;

/**
 * @author ：zzy
 * @description：登录授权等
 * @date ：2021/3/22 20:04
 */

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String getLogin() {

        return "login";

    }


    @GetMapping("/index")
    public String getIndex() {

        return "index";

    }


    @PostMapping("/login")
    public String login(@NotNull String username, @NotNull String password) {

        try {

            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(username, password));



            return "index";


        } catch (UnknownAccountException e) {

            System.out.println("username is error");
            e.printStackTrace();
        } catch (IncorrectCredentialsException e) {

            System.out.println("password is error");
            e.printStackTrace();

        } catch (RuntimeException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        }

        return "login";

    }

    @GetMapping("/register")
    public String getRegister() {


        return "register";
    }


    @ResponseBody
    @PostMapping("/register")
    public AjaxResult register(User user) {

        System.out.println(user + "-------------");

        try {
            userService.registerAccount(user);

            System.out.println(AjaxResult.success());
            return AjaxResult.success();

        } catch (Exception e) {
            e.printStackTrace();

            return AjaxResult.error();
        }
    }




/*
    @PostMapping("/register")
    public String register(User usermanage) {


        try {
            userService.registerAccount(usermanage);
            return "login";

        } catch (Exception e) {
            e.printStackTrace();

            return "register";
        }

    }*/


    @GetMapping("/logout")
    public String logout() {

        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        return "login";
    }


    @GetMapping("/test")
    public String test() {

        return "char";

    }


}
