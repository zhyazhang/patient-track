package com.aifurion.track.entity.VO;

import java.io.Serializable;

/**
 * @author ：zzy
 * @description：TODO 病例展示实例封装
 * @date ：2021/4/3 14:16
 */
public class CaseVO implements Serializable {

    private static final long serialVersionUID = 7309805790652851868L;


    //病单id
    private String caseid;
    //病人id
    private String patientid;
    //病人名字
    private String patientname;

    private String patientphone;

    private String patientage;
    //医生id
    private String doctorid;
    //医生名字
    private String doctorname;
    //诊断结果
    private String diagnosis;
    //病况
    private String condition;
    //治疗方式
    private String treatment;
    //病单创建时间
    private String createTime;
    //治疗进度
    private String state;

    private String ward;

    private String hospitalized;

    //主科室id
    private String maindepid;
    //次科室id
    private String secdepid;
    //主科室名字
    private String maindepname;
    //次科室名字
    private String secdepname;

    public CaseVO() {
    }

    public CaseVO(String caseid, String patientid, String patientname, String patientphone, String patientage,
                  String doctorid, String doctorname, String diagnosis, String condition, String treatment,
                  String createTime, String state, String ward, String hospitalized, String maindepid,
                  String secdepid, String maindepname, String secdepname) {
        this.caseid = caseid;
        this.patientid = patientid;
        this.patientname = patientname;
        this.patientphone = patientphone;
        this.patientage = patientage;
        this.doctorid = doctorid;
        this.doctorname = doctorname;
        this.diagnosis = diagnosis;
        this.condition = condition;
        this.treatment = treatment;
        this.createTime = createTime;
        this.state = state;
        this.ward = ward;
        this.hospitalized = hospitalized;
        this.maindepid = maindepid;
        this.secdepid = secdepid;
        this.maindepname = maindepname;
        this.secdepname = secdepname;
    }

    @Override
    public String toString() {
        return "CaseVO{" +
                "caseid='" + caseid + '\'' +
                ", patientid='" + patientid + '\'' +
                ", patientname='" + patientname + '\'' +
                ", patientphone='" + patientphone + '\'' +
                ", patientage='" + patientage + '\'' +
                ", doctorid='" + doctorid + '\'' +
                ", doctorname='" + doctorname + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", condition='" + condition + '\'' +
                ", treatment='" + treatment + '\'' +
                ", createTime='" + createTime + '\'' +
                ", state='" + state + '\'' +
                ", ward='" + ward + '\'' +
                ", hospitalized='" + hospitalized + '\'' +
                ", maindepid='" + maindepid + '\'' +
                ", secdepid='" + secdepid + '\'' +
                ", maindepname='" + maindepname + '\'' +
                ", secdepname='" + secdepname + '\'' +
                '}';
    }

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getPatientphone() {
        return patientphone;
    }

    public void setPatientphone(String patientphone) {
        this.patientphone = patientphone;
    }

    public String getPatientage() {
        return patientage;
    }

    public void setPatientage(String patientage) {
        this.patientage = patientage;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getHospitalized() {
        return hospitalized;
    }

    public void setHospitalized(String hospitalized) {
        this.hospitalized = hospitalized;
    }

    public String getMaindepid() {
        return maindepid;
    }

    public void setMaindepid(String maindepid) {
        this.maindepid = maindepid;
    }

    public String getSecdepid() {
        return secdepid;
    }

    public void setSecdepid(String secdepid) {
        this.secdepid = secdepid;
    }

    public String getMaindepname() {
        return maindepname;
    }

    public void setMaindepname(String maindepname) {
        this.maindepname = maindepname;
    }

    public String getSecdepname() {
        return secdepname;
    }

    public void setSecdepname(String secdepname) {
        this.secdepname = secdepname;
    }
}
