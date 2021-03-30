package com.aifurion.blog.controller;

import com.aifurion.blog.common.AjaxResult;
import com.aifurion.blog.entity.User;
import com.aifurion.blog.service.AuthService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：zzy
 * @description：个人账户管理
 * @date ：2021/3/26 8:37
 */

@Controller
@RequestMapping("/account")
public class AccountManageController {

    @Autowired
    private AuthService authService;


    @GetMapping("/personal")
    public String getPersonalManagePage(Model model) {

        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        User user = authService.findUserByUsername(username);

        user.setSalt("");
        user.setPassword("");

        model.addAttribute(user);

        return "account/personal";

    }


    @GetMapping("/homepage")
    public String getHomePage() {


        return "account/homepage";

    }


}
