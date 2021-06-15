package com.aifurion.track.entity.VO;

import java.io.Serializable;

/**
 * @author ：zzy
 * @description：TODO 首页---每月数据
 * @date ：2021/4/5 17:02
 */
public class MonthDataVO implements Serializable {
    private static final long serialVersionUID = 8627345922242660671L;


    private Integer thecount;


    private String theday;

    private String themonth;

    public MonthDataVO() {
    }

    public MonthDataVO(Integer thecount, String theday, String themonth) {
        this.thecount = thecount;
        this.theday = theday;
        this.themonth = themonth;
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

    public String getThemonth() {
        return themonth;
    }

    public void setThemonth(String themonth) {
        this.themonth = themonth;
    }
}
