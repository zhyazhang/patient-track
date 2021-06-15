package com.aifurion.track.service;

import com.aifurion.track.entity.VO.CaseVO;
import com.aifurion.track.entity.TheCase;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/4/3 14:14
 */
public interface CaseManageService {

    List<CaseVO> getCaseVOs(String nickname, String patientage, String state, String doctorname,String department, String patientphone,
                            String doctorphone,String registrarid,String type);

    CaseVO getCaseVOByID(String caseid);




    void updateCase(TheCase theCase);

    void addCase(String doctorid,String phone);


}
