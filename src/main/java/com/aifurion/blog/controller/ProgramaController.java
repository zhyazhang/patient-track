package com.aifurion.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：zzy
 * @description：栏目设置
 * @date ：2021/3/26 8:45
 */


@Controller
@RequestMapping("/programa")
public class ProgramaController {

    @GetMapping("/programa")
    public String getProgramaPage() {


        return "programa/programa";

    }


}
