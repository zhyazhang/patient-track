package com.aifurion.track.entity.VO;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/4/30 14:50
 */
public class WardVO {

    private String id;

    private String nickname;

    private String phone;

    private String age;

    private String secdep;

    private String building;
    private String floor;
    private String room;
    private String bed;

    public WardVO() {
    }

    public WardVO(String id, String nickname, String phone, String age, String secdep, String building,
                  String floor, String room, String bed) {
        this.id = id;
        this.nickname = nickname;
        this.phone = phone;
        this.age = age;
        this.secdep = secdep;
        this.building = building;
        this.floor = floor;
        this.room = room;
        this.bed = bed;
    }

    @Override
    public String toString() {
        return "WardVO{" +
                "id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", age='" + age + '\'' +
                ", secdepname='" + secdep + '\'' +
                ", building='" + building + '\'' +
                ", floor='" + floor + '\'' +
                ", room='" + room + '\'' +
                ", bed='" + bed + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSecdep() {
        return secdep;
    }

    public void setSecdep(String secdep) {
        this.secdep = secdep;
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
}
