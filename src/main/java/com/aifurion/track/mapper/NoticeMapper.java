package com.aifurion.track.mapper;

import com.aifurion.track.entity.Notice;
import com.aifurion.track.entity.VO.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/4/30 18:06
 */

@Mapper
public interface NoticeMapper {

    void addNotice(Notice notice);

    List<Notice> getUnReadNotice(NoticeVO noticeVO);

    List<Notice> getReadedNotice(NoticeVO noticeVO);


    Notice getNoticeById(String id);

    List<Notice> getAllNotices(Notice notice);

    void updateNotice(Notice notice);

    void deleteNotice(String id);

    void deleteUserNotice(String id);

    Integer getUnReadNoticeCount(String id);


    void viewNotice(String userid, String noticeid);


}
