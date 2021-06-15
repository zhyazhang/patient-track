package com.aifurion.track.entity.VO;

import java.io.Serializable;

/**
 * @author ：zzy
 * @description：TODO 首页---每周数据
 * @date ：2021/4/5 17:02
 */
public class WeekDataVO implements Serializable {


    private static final long serialVersionUID = -5942791407319892946L;

    private Integer thecount;

    private String theday;

    private String theweek;


    public WeekDataVO() {
    }

    @Override
    public String toString() {
        return "WeekDataVO{" +
                "thecount=" + thecount +
                ", theday='" + theday + '\'' +
                ", theweek='" + theweek + '\'' +
                '}';
    }

    public Integer getThecount() {
        return thecount;
    }

    public void setThecount(Integer thecount) {
        this.thecount = thecount;
    }

    public String getTheday() {
        return theday;
    }

    public void setTheday(String theday) {
        this.theday = theday;
    }

    public String getTheweek() {
        return theweek;
    }

    public void setTheweek(String theweek) {
        this.theweek = theweek;
    }

    public WeekDataVO(Integer thecount, String theday, String theweek) {
        this.thecount = thecount;
        this.theday = theday;
        this.theweek = theweek;
    }
}
