package com.aifurion.track.controller;

import com.aifurion.track.entity.VO.DataVO;
import com.aifurion.track.service.AuthService;
import com.aifurion.track.service.DataShowService;
import com.aifurion.track.service.NoticeService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/4/5 13:16
 */
@Controller
@RequestMapping("/data")
public class DataShowController {

    @Autowired
    private DataShowService dataShowService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private AuthService authService;

    /**
     * @author: zzy
     * @description: TODO 首页加载相应数据，进行展示
     * @date: 2021/4/7 21:26
     * @Param: null
     */
    @GetMapping("/home")
    public String getHomePage(Model model) {


        String id = authService.findRolesByPhone((String) SecurityUtils.getSubject().getPrincipal()).getId();

        DataVO dataVO = dataShowService.loadData();

        Integer unReadNoticeCount = noticeService.getUnReadNoticeCount(id);

        model.addAttribute("datas", dataVO);
        model.addAttribute("unReadNoticeCount", unReadNoticeCount);

        return "home";

    }

}
