package com.aifurion.blog.controller;

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

import javax.validation.constraints.NotNull;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/3/22 20:04
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String getLogin() {

        return "login";

    }

    @PostMapping("/login")
    public String login(@NotNull String username, @NotNull String password) {

        try {

            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(username, password));
            System.out.println("login success");


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


    @PostMapping("/register")
    public String register(User user) {


        try {
            userService.registerAccount(user);
            return "login";

        } catch (Exception e) {
            e.printStackTrace();

            return "register";
        }

    }


    @GetMapping("/logout")
    public String logout() {

        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        return "login";
    }





}
