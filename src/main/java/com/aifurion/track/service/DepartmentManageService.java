package com.aifurion.track.service;

import com.aifurion.track.entity.VO.DepartmentDoctorVO;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/4/6 19:50
 */
public interface DepartmentManageService {


    List<DepartmentDoctorVO> getDoctorDepartmentByRegistrarId(String userid);


}
