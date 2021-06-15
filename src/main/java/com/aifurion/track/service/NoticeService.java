package com.aifurion.track.service;

import com.aifurion.track.entity.Notice;
import com.aifurion.track.entity.VO.NoticeVO;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/4/30 18:05
 */
public interface NoticeService {

    void addNotice(Notice notice);

    List<Notice> getAllUnReadNotice(NoticeVO noticeVO);

    List<Notice> getAllReadedNotice(NoticeVO noticeVO);

    Notice getNoticeById(String id);

    List<Notice> getAllNotices(Notice notice);

    void updateNotice(Notice notice);

    void deleteNotice(String id);

    Integer getUnReadNoticeCount(String id);

    void viewNotice(String noticeid);

}
