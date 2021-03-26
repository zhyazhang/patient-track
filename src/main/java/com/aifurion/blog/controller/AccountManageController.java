package com.aifurion.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：zzy
 * @description：个人账户管理
 * @date ：2021/3/26 8:37
 */

@Controller
@RequestMapping("/account")
public class AccountManageController {


    @GetMapping("/personal")
    public String getPersonalManagePage() {


        return "account/personal";

    }


    @GetMapping("/homepage")
    public String getHomePage() {


        return "account/homepage";

    }


}
