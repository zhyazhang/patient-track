package com.aifurion.track.service.impl;

import com.aifurion.track.entity.VO.DataVO;
import com.aifurion.track.entity.VO.MonthDataVO;
import com.aifurion.track.entity.VO.WeekDataVO;
import com.aifurion.track.mapper.DataShowMapper;
import com.aifurion.track.mapper.WardMapper;
import com.aifurion.track.service.DataShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO 数据展示相关方法
 * @date ：2021/4/5 13:17
 */

@Service
public class DataShowServiceImpl implements DataShowService {

    @Autowired
    private DataShowMapper dataShowMapper;

    @Autowired
    private WardMapper wardMapper;


    /**
     * @author: zzy
     * @description: TODO 加载首页显示的所有数据
     * @date: 2021/4/7 12:57
     * @Param: null
     */
    @Override
    public DataVO loadData() {

        DataVO dataVO = new DataVO();
        Integer countTodayRegisterUser = dataShowMapper.getCountTodayRegisterUser();
        Integer countCase = dataShowMapper.getCountCase();
        Integer countDoctor = dataShowMapper.getCountDoctor();
        Integer countPatient = dataShowMapper.getCountPatient();
        Integer countTodayCreateCase = dataShowMapper.getCountTodayCreateCase();
        Integer countUser = dataShowMapper.getCountUser();
        List<WeekDataVO> countWeek = dataShowMapper.getCountWeek();
        List<MonthDataVO> countMonth = dataShowMapper.getCountMonth();
        Integer hospitalizedCount = wardMapper.getHospitalizedCount();


        dataVO.setTodayRegisterCount(countTodayRegisterUser);
        dataVO.setTodayCreateCaseCount(countTodayCreateCase);
        dataVO.setTodayCreateCaseCount(countCase);
        dataVO.setDoctorCount(countDoctor);
        dataVO.setPatientCount(countPatient);
        dataVO.setUserCount(countUser);
        dataVO.setCaseCount(countCase);
        dataVO.setHospitalized(hospitalizedCount);


        dataVO.setWeekDataVOS(countWeek);
        dataVO.setMonthDataVOS(countMonth);
        return dataVO;
    }
}
