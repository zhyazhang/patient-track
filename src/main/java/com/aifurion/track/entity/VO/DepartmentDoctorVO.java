package com.aifurion.track.entity.VO;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：zzy
 * @description：TODO 科室封装
 * @date ：2021/4/6 20:16
 */
public class DepartmentDoctorVO implements Serializable {

    private static final long serialVersionUID = 8830957798297011778L;
    private String secdepid;

    private String secdep;

    private List<DoctorVO> doctorVOS;


    public DepartmentDoctorVO() {
    }

    public DepartmentDoctorVO(String secdepid, String secdep, List<DoctorVO> doctorVOS) {
        this.secdepid = secdepid;
        this.secdep = secdep;
        this.doctorVOS = doctorVOS;
    }


    @Override
    public String toString() {
        return "DepartmentDoctorVO{" +
                "secdepid='" + secdepid + '\'' +
                ", secdep='" + secdep + '\'' +
                ", doctorVOS=" + doctorVOS +
                '}';
    }


    public String getSecdepid() {
        return secdepid;
    }

    public void setSecdepid(String secdepid) {
        this.secdepid = secdepid;
    }

    public String getSecdep() {
        return secdep;
    }

    public void setSecdep(String secdep) {
        this.secdep = secdep;
    }

    public List<DoctorVO> getDoctorVOS() {
        return doctorVOS;
    }

    public void setDoctorVOS(List<DoctorVO> doctorVOS) {
        this.doctorVOS = doctorVOS;
    }
}
