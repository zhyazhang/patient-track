package com.aifurion.track.mapper;

import com.aifurion.track.entity.VO.CaseVO;
import com.aifurion.track.entity.TheCase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO 病单相关持久化方法
 * @date ：2021/4/3 14:15
 */

@Mapper
public interface CaseManageMapper {


    List<CaseVO> getCaseVOs(String nickname, String patientage,
                                   String state,String doctorname, String department,
                                   String patientphone, String doctorphone,String registrarid,String type);

    List<CaseVO> getDoctorAllCaseVO(String doctorID);

    CaseVO getCaseVOByID(String caseID);

    void updateCase(TheCase theCase);

    void addCase(TheCase theCase);


}
