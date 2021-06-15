package com.aifurion.track.service.impl;

import com.aifurion.track.entity.VO.CaseVO;
import com.aifurion.track.entity.TheCase;
import com.aifurion.track.entity.Ward;
import com.aifurion.track.mapper.CaseManageMapper;
import com.aifurion.track.mapper.WardMapper;
import com.aifurion.track.service.AuthService;
import com.aifurion.track.service.CaseManageService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author ：zzy
 * @description：TODO 病例相关方法
 * @date ：2021/4/3 14:15
 */

@Service
public class CaseManageServiceImpl implements CaseManageService {

    @Autowired
    private CaseManageMapper caseManageMapper;


    @Autowired
    private AuthService authService;

    @Autowired
    private WardMapper wardMapper;


    @Override
    public void addCase(String doctorid, String phone) {


        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = simpleDateFormat.format(date);

        String pid = authService.findUserByPhone(phone).getId();

        String rid = authService.findUserByPhone((String) SecurityUtils.getSubject().getPrincipal()).getId();

        TheCase theCase = new TheCase();

        theCase.setDid(doctorid);
        theCase.setPid(pid);

        theCase.setRid(rid);
        theCase.setState("0");

        theCase.setCreateTime(createTime);
        caseManageMapper.addCase(theCase);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCase(TheCase theCase) {

        Ward ward = new Ward();
        ward.setBuilding(theCase.getBuilding());
        ward.setFloor(theCase.getFloor());
        ward.setRoom(theCase.getRoom());
        ward.setBed(theCase.getBed());
        System.out.println(theCase);

        if ("2".equals(theCase.getState())) {
            wardMapper.updateWardState(theCase.getWardId(), "1");
        } else {

            if (Objects.equals(theCase.getHospitalized(), "1")) {


                Ward w = wardMapper.getWardIdByWard(ward);

                System.out.println(w);
                if (!Objects.equals(w.getId(), theCase.getWardId())) {
                    //设置病房状态
                    wardMapper.updateWardState(theCase.getWardId(), "1");
                    wardMapper.updateWardState(w.getId(), "0");
                    theCase.setWardId(w.getId());

                }

            }


        }
        System.out.println(theCase);

        caseManageMapper.updateCase(theCase);
    }

    @Override
    public List<CaseVO> getCaseVOs(String nickname, String patientage,
                                   String state, String doctorname, String department,
                                   String patientphone, String doctorphone, String registrarid, String type) {


        return caseManageMapper.getCaseVOs(nickname, patientage, state, doctorname, department, patientphone,
                doctorphone,
                registrarid, type);
    }

    @Override
    public CaseVO getCaseVOByID(String caseid) {

        return caseManageMapper.getCaseVOByID(caseid);
    }

}
