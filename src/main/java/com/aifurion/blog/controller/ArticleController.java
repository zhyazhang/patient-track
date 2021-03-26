package com.aifurion.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：zzy
 * @description：文章相关
 * @date ：2021/3/26 8:41
 */

@Controller
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/list")
    public String getArticleListPage() {


        return "article/list";

    }


    @GetMapping("/publish")
    public String getPublishPage() {


        return "article/publish";

    }


}
