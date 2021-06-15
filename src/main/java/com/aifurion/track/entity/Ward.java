package com.aifurion.track.entity;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/4/28 20:21
 */
public class Ward {

    private String id;
    //哪个楼
    private String building;

    private String floor;

    private String room;

    private String bed;
    //是否空
    private String empty;

    public Ward() {
    }

    public Ward(String id, String building, String floor, String room, String bed, String empty) {
        this.id = id;
        this.building = building;
        this.floor = floor;
        this.room = room;
        this.bed = bed;
        this.empty = empty;
    }

    @Override
    public String toString() {
        return "Ward{" +
                "id='" + id + '\'' +
                ", building='" + building + '\'' +
                ", floor='" + floor + '\'' +
                ", room='" + room + '\'' +
                ", bed='" + bed + '\'' +
                ", empty='" + empty + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmpty() {
        return empty;
    }

    public void setEmpty(String empty) {
        this.empty = empty;
    }
}
