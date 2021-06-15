package com.aifurion.track.entity.VO;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：zzy
 * @description：TODO 首页数据展示封装
 * @date ：2021/4/5 13:40
 */
public class DataVO implements Serializable {

    private static final long serialVersionUID = -4568004076115593914L;
    private Integer todayRegisterCount;

    private Integer userCount;

    private Integer doctorCount;

    private Integer patientCount;

    private Integer todayCreateCaseCount;

    private Integer caseCount;

    private Integer hospitalized;

    private List<WeekDataVO> weekDataVOS;

    private List<MonthDataVO> monthDataVOS;

    public DataVO() {
    }

    public DataVO(Integer todayRegisterCount, Integer userCount, Integer doctorCount, Integer patientCount,
                  Integer todayCreateCaseCount, Integer caseCount, Integer hospitalized, List<WeekDataVO> weekDataVOS
            , List<MonthDataVO> monthDataVOS) {
        this.todayRegisterCount = todayRegisterCount;
        this.userCount = userCount;
        this.doctorCount = doctorCount;
        this.patientCount = patientCount;
        this.todayCreateCaseCount = todayCreateCaseCount;
        this.caseCount = caseCount;
        this.hospitalized = hospitalized;
        this.weekDataVOS = weekDataVOS;
        this.monthDataVOS = monthDataVOS;
    }

    public Integer getTodayRegisterCount() {
        return todayRegisterCount;
    }

    public void setTodayRegisterCount(Integer todayRegisterCount) {
        this.todayRegisterCount = todayRegisterCount;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getDoctorCount() {
        return doctorCount;
    }

    public void setDoctorCount(Integer doctorCount) {
        this.doctorCount = doctorCount;
    }

    public Integer getPatientCount() {
        return patientCount;
    }

    public void setPatientCount(Integer patientCount) {
        this.patientCount = patientCount;
    }

    public Integer getTodayCreateCaseCount() {
        return todayCreateCaseCount;
    }

    public void setTodayCreateCaseCount(Integer todayCreateCaseCount) {
        this.todayCreateCaseCount = todayCreateCaseCount;
    }

    public Integer getCaseCount() {
        return caseCount;
    }

    public void setCaseCount(Integer caseCount) {
        this.caseCount = caseCount;
    }

    public Integer getHospitalized() {
        return hospitalized;
    }

    public void setHospitalized(Integer hospitalized) {
        this.hospitalized = hospitalized;
    }

    public List<WeekDataVO> getWeekDataVOS() {
        return weekDataVOS;
    }

    public void setWeekDataVOS(List<WeekDataVO> weekDataVOS) {
        this.weekDataVOS = weekDataVOS;
    }

    public List<MonthDataVO> getMonthDataVOS() {
        return monthDataVOS;
    }

    public void setMonthDataVOS(List<MonthDataVO> monthDataVOS) {
        this.monthDataVOS = monthDataVOS;
    }
}
