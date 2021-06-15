package com.aifurion.track.controller;

import com.aifurion.track.common.AjaxResult;
import com.aifurion.track.entity.*;
import com.aifurion.track.entity.VO.CaseVO;
import com.aifurion.track.entity.VO.DepartmentDoctorVO;
import com.aifurion.track.service.AuthService;
import com.aifurion.track.service.CaseManageService;
import com.aifurion.track.service.DepartmentManageService;
import com.aifurion.track.service.WardService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ：zzy
 * @description：TODO 病例管理
 * @date ：2021/3/30 10:02
 */

@Controller
@RequestMapping("/case")
public class CaseManageController {


    @Autowired
    private AuthService authService;

    @Autowired
    private CaseManageService caseManageService;

    @Autowired
    private DepartmentManageService departmentManageService;

    @Autowired
    private WardService wardService;


    @GetMapping("/info")
    public String getCaseInfoPage() {

        return "case/case_info";
    }

    @GetMapping("/track")
    public String getCaseTrackPage() {

        return "case/case_track";
    }

    /**
     * @author: zzy
     * @description: TODO 管理病例，传递相应的参数搜索到相应的病例
     * @date: 2021/4/7 21:24
     * @Param: null
     */
    @GetMapping("/manage")
    public String getManageCasePage(Model model,
                                    @RequestParam(required = false, defaultValue = "") String nickname,
                                    @RequestParam(required = false, defaultValue = "") String patientage,
                                    @RequestParam(required = false, defaultValue = "") String state,
                                    @RequestParam(required = false, defaultValue = "") String type,
                                    @RequestParam(required = false, defaultValue = "") String doctorname,
                                    @RequestParam(required = false, defaultValue = "") String department,
                                    @RequestParam(required = false, defaultValue = "") String patientphone,
                                    @RequestParam(required = false, defaultValue = "") String doctorphone,
                                    @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {


        String userphone = (String) SecurityUtils.getSubject().getPrincipal();
        User user = authService.findRolesByPhone(userphone);
        String rolesName = user.getRoles().get(0).getName();
        String registrarid = "";
        List<CaseVO> allCaseVO = new ArrayList<>();

        if ("doctor".equals(rolesName)) {
            if ("".equals(doctorphone)) {
                doctorphone = userphone;

            }

            type = "all";

        } else if ("patient".equals(rolesName)) {

            if ("".equals(patientphone)) {
                patientphone = userphone;

            }

            type = "all";

        } else if ("admin".equals(rolesName)) {
            type = "all";
        } else if ("registrar".equals(rolesName)) {

            List<DepartmentDoctorVO> departmentDoctorVOS =
                    departmentManageService.getDoctorDepartmentByRegistrarId(user.getId());
            registrarid = user.getId();
            model.addAttribute("depDoctors", departmentDoctorVOS);
            model.addAttribute("registrarid", registrarid);
        }

        PageHelper.startPage(pageNum, 10);
        allCaseVO = caseManageService.getCaseVOs(nickname, patientage, state, doctorname, department, patientphone,
                doctorphone, registrarid, type);
        PageInfo<CaseVO> pageCases = new PageInfo<>(allCaseVO);

        model.addAttribute("allCase", pageCases);
        return "case/manage_case";
    }

    /**
     * @author: zzy
     * @description: TODO 查看某个病例
     * @date: 2021/4/7 21:25
     * @Param: null
     */
    @GetMapping("/viewcase/{id}")
    public String getCaseViewPage(@PathVariable("id") String caseid, Model model) {

        CaseVO caseVO = caseManageService.getCaseVOByID(caseid);

        List<String> buildings = wardService.getAllWardBuilding();
        String wardId = caseVO.getWard();

        String userphone = (String) SecurityUtils.getSubject().getPrincipal();
        User user = authService.findRolesByPhone(userphone);
        String rolesName = user.getRoles().get(0).getName();

        Ward ward = wardService.getWardById(wardId);

        model.addAttribute("thecase", caseVO);
        model.addAttribute("buildings", buildings);
        model.addAttribute("ward", ward);
        model.addAttribute("state", caseVO.getState());
        model.addAttribute("rolesName", rolesName);

        return "case/view_case";
    }

    /**
     * @author: zzy
     * @description: TODO 更新病例
     * @date: 2021/4/7 21:25
     * @Param: null
     */

    @PostMapping("/update")
    @ResponseBody
    public AjaxResult updateCase(TheCase theCase) {
        try {
            caseManageService.updateCase(theCase);
            return AjaxResult.success("病例更新成功！");

        } catch (Exception e) {
            e.printStackTrace();

            return AjaxResult.error("服务器异常，请稍后重试！");

        }
    }

    /**
     * @author: zzy
     * @description: TODO 添加病例
     * @date: 2021/4/7 21:26
     * @Param: null
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addCase(String doctorid, String phone) {

        try {
            caseManageService.addCase(doctorid, phone);
            return AjaxResult.success("挂号成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("服务器异常，请稍后重试！");

        }

    }


}
