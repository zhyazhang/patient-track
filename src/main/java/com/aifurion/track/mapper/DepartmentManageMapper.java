package com.aifurion.track.mapper;

import com.aifurion.track.entity.VO.DepartmentDoctorVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO 挂号时，挂号员获取相关信息的持久化方法
 * @date ：2021/4/6 19:47
 */
@Mapper
public interface DepartmentManageMapper {


    List<DepartmentDoctorVO> getDoctorDepartmentByRegistrarId(String userid);



}
