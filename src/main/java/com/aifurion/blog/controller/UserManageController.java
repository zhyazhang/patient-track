package com.aifurion.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：zzy
 * @description：用户管理
 * @date ：2021/3/26 8:47
 */


@Controller
@RequestMapping("/user")
public class UserManageController {


    @GetMapping("/manage")
    public String getUserManagePage() {


        return "usermanage/usermanage";

    }

}
