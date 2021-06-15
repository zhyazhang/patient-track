package com.aifurion.track.controller;

import com.aifurion.track.common.AjaxResult;
import com.aifurion.track.entity.VO.WardVO;
import com.aifurion.track.entity.Ward;
import com.aifurion.track.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/4/28 20:25
 */

@Controller
@RequestMapping("/ward")
public class WardController {

    @Autowired
    private WardService wardService;

    @GetMapping("/building")
    @ResponseBody
    public AjaxResult getAllWardBuilding() {
        try {
            List<String> allWardBuilding = wardService.getAllWardBuilding();
            return AjaxResult.success(allWardBuilding);
        } catch (Exception e) {
            return AjaxResult.error();
        }


    }

    @GetMapping("/floor")
    @ResponseBody
    public AjaxResult getAllWardFloorByBuilding(Ward ward) {

        try {
            List<String> allWardFloorByBuilding = wardService.getAllWardFloorByBuilding(ward);
            return AjaxResult.success(allWardFloorByBuilding);
        } catch (Exception e) {
            return AjaxResult.error();

        }

    }

    @GetMapping("/room")
    @ResponseBody
    public AjaxResult getAllWardRoomByFloor(Ward ward) {

        try {
            List<String> allWardRoomByFloor = wardService.getAllWardRoomByFloor(ward);
            return AjaxResult.success(allWardRoomByFloor);
        } catch (Exception e) {
            return AjaxResult.error();
        }
    }

    @GetMapping("/bed")
    @ResponseBody
    public AjaxResult getAllWardDedByRoom(Ward ward) {
        try {
            List<String> allWardDedByRoom = wardService.getAllWardDedByRoom(ward);
            return AjaxResult.success(allWardDedByRoom);
        } catch (Exception e) {
            return AjaxResult.error();
        }
    }


    @GetMapping("/view")
    public String toViewWardPage(Model model,WardVO ward) {

        List<WardVO> wardPatient = wardService.getAllWardPatient(ward);
        model.addAttribute("wardPatient", wardPatient);
        return "ward/view_ward";

    }




}
