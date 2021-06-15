package com.aifurion.track.entity;

import java.io.Serializable;

/**
 * @author ：zzy
 * @description：TODO 病单实体类
 * @date ：2021/4/3 14:27
 */
public class TheCase implements Serializable {

    private static final long serialVersionUID = 2139022335408449627L;
    private String id;

    private String pid;

    private String did;
    private String rid;

    private String diagnosis;

    private String condition;

    private String treatment;

    private String createTime;

    private String state;

    private String building;

    private String floor;

    private String room;

    private String bed;

    private String hospitalized;

    private String wardId;

    public TheCase() {
    }

    public TheCase(String id, String pid, String did, String rid, String diagnosis, String condition,
                   String treatment, String createTime, String state, String building, String floor, String room,
                   String bed, String hospitalized, String wardId) {
        this.id = id;
        this.pid = pid;
        this.did = did;
        this.rid = rid;
        this.diagnosis = diagnosis;
        this.condition = condition;
        this.treatment = treatment;
        this.createTime = createTime;
        this.state = state;
        this.building = building;
        this.floor = floor;
        this.room = room;
        this.bed = bed;
        this.hospitalized = hospitalized;
        this.wardId = wardId;
    }

    @Override
    public String toString() {
        return "TheCase{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", did='" + did + '\'' +
                ", rid='" + rid + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", condition='" + condition + '\'' +
                ", treatment='" + treatment + '\'' +
                ", createTime='" + createTime + '\'' +
                ", state='" + state + '\'' +
                ", building='" + building + '\'' +
                ", floor='" + floor + '\'' +
                ", room='" + room + '\'' +
                ", bed='" + bed + '\'' +
                ", hospitalized='" + hospitalized + '\'' +
                ", wardId='" + wardId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
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

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getHospitalized() {
        return hospitalized;
    }

    public void setHospitalized(String hospitalized) {
        this.hospitalized = hospitalized;
    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId;
    }
}
