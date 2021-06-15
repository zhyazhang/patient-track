package com.aifurion.track.entity;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/4/30 17:54
 */
public class Notice {


    private String id;

    private String userid;

    private String title;

    private String content;

    private String addtime;

    public Notice() {
    }

    public Notice(String id, String userid, String title, String content, String addtime) {
        this.id = id;
        this.userid = userid;
        this.title = title;
        this.content = content;
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time='" + addtime + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
