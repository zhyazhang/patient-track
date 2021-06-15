package com.aifurion.track.entity.VO;

import java.io.Serializable;

/**
 * @author ：zzy
 * @description：TODO 医生信息封装
 * @date ：2021/4/6 20:00
 */
public class DoctorVO implements Serializable {
    private static final long serialVersionUID = -7476006797185786586L;

    private String nickname;

    private String id;


    public DoctorVO() {
    }

    public DoctorVO(String nickname, String id) {
        this.nickname = nickname;
        this.id = id;
    }

    @Override
    public String toString() {
        return "DoctorVo{" +
                "name='" + nickname + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
