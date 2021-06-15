package com.aifurion.track.service.impl;

import com.aifurion.track.entity.VO.DepartmentDoctorVO;
import com.aifurion.track.mapper.DepartmentManageMapper;
import com.aifurion.track.service.DepartmentManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/4/6 19:51
 */

@Service
public class DepartmentManageServiceImpl implements DepartmentManageService {

    @Autowired
    private DepartmentManageMapper departmentManageMapper;



    @Override
    public List<DepartmentDoctorVO> getDoctorDepartmentByRegistrarId(String userid) {


        return departmentManageMapper.getDoctorDepartmentByRegistrarId(userid);
    }
}
