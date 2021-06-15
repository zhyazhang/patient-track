package com.aifurion.track.controller;

import com.aifurion.track.common.AjaxResult;
import com.aifurion.track.entity.Notice;
import com.aifurion.track.entity.VO.NoticeVO;
import com.aifurion.track.service.NoticeService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/4/30 16:35
 */

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/toAdd")
    public String toNoticeAdd() {
        return "notice/notice_add";
    }


    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addNotice(Notice notice) {

        try {
            noticeService.addNotice(notice);
            return AjaxResult.success();
        } catch (Exception e) {

            return AjaxResult.error();

        }

    }

    @GetMapping("/getUnRead")
    public String getUnReadNotice(Model model, NoticeVO noticeVO) {


        try {
            List<Notice> unReadNotice = noticeService.getAllUnReadNotice(noticeVO);
            model.addAttribute("notices", unReadNotice);
            model.addAttribute("type", "unread");
        } catch (Exception e) {
            e.printStackTrace();

        }


        return "notice/notice_other_manage";


    }

    @GetMapping("/getReaded")
    public String getReadedNotice(Model model, NoticeVO noticeVO) {


        try {
            List<Notice> unReadNotice = noticeService.getAllReadedNotice(noticeVO);
            model.addAttribute("notices", unReadNotice);
            model.addAttribute("type", "readed");
        } catch (Exception e) {
            e.printStackTrace();

        }
        return "notice/notice_other_manage";


    }

    @GetMapping("/getNoticeById")
    @ResponseBody
    public AjaxResult getNoticeById(String id) {

        try {
            Notice notice = noticeService.getNoticeById(id);
            return AjaxResult.success(notice);
        } catch (Exception e) {
            return AjaxResult.error();
        }

    }


    @GetMapping("/notices")
    public String getAllNotices(Model model, Notice notice) {

        try {
            List<Notice> allNotices = noticeService.getAllNotices(notice);
            model.addAttribute("notices", allNotices);

        } catch (Exception e) {
            e.printStackTrace();


        }
        return "notice/notice_manage";


    }


    @PostMapping("/update")
    @ResponseBody
    public AjaxResult updateNotice(Notice notice) {

        try {
            noticeService.updateNotice(notice);
            return AjaxResult.success();
        } catch (Exception e) {
            return AjaxResult.error();
        }

    }


    @GetMapping("/delete/{id}")
    public String deleteNotice(@PathVariable("id") String id) {

        try {
            noticeService.deleteNotice(id);
            return "redirect:/notice/notices";
        } catch (Exception e) {
            return "redirect:/notice/notices";
        }

    }

    @GetMapping("/toUpdate/{id}")
    public String toUpdateNotice(@PathVariable("id") String id, Model model) {

        try {

            Notice notice = noticeService.getNoticeById(id);
            model.addAttribute("notice", notice);

        } catch (Exception e) {

            e.printStackTrace();
        }
        return "notice/notice_update";


    }

    @GetMapping("/toView/{id}")
    public String toViewNotice(@PathVariable("id") String id, Model model) {

        try {

            Notice notice = noticeService.getNoticeById(id);
            noticeService.viewNotice(id);
            model.addAttribute("notice", notice);

        } catch (Exception e) {

            e.printStackTrace();
        }
        return "notice/notice_view";


    }


}
