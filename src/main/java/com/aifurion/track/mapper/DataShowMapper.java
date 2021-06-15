package com.aifurion.track.mapper;

import com.aifurion.track.entity.VO.MonthDataVO;
import com.aifurion.track.entity.VO.WeekDataVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO 数据展示相关持久化方法
 * @date ：2021/4/5 13:17
 */


@Mapper
public interface DataShowMapper {


    Integer getCountTodayRegisterUser();

    Integer getCountUser();

    Integer getCountPatient();

    Integer getCountDoctor();

    Integer getCountTodayCreateCase();

    Integer getCountCase();

    List<WeekDataVO> getCountWeek();

    List<MonthDataVO> getCountMonth();





}
