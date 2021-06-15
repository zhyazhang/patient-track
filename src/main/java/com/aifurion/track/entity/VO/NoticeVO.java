package com.aifurion.track.entity.VO;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/5/2 16:47
 */
public class NoticeVO {

    private String userId;

    private String title;

    private String pushUserName;

    public NoticeVO() {
    }

    public NoticeVO(String userId, String title, String pushUserName) {
        this.userId = userId;
        this.title = title;
        this.pushUserName = pushUserName;
    }

    @Override
    public String toString() {
        return "NoticeVO{" +
                "userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", pushUserName='" + pushUserName + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPushUserName() {
        return pushUserName;
    }

    public void setPushUserName(String pushUserName) {
        this.pushUserName = pushUserName;
    }
}
