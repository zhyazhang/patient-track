package com.aifurion.track.service.impl;

import com.aifurion.track.entity.Notice;
import com.aifurion.track.entity.VO.NoticeVO;
import com.aifurion.track.mapper.AuthMapper;
import com.aifurion.track.mapper.NoticeMapper;
import com.aifurion.track.service.NoticeService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/4/30 18:05
 */

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private AuthMapper authMapper;

    @Override
    public void viewNotice(String noticeid) {
        String id = authMapper.findUserByPhone((String) SecurityUtils.getSubject().getPrincipal()).getId();
        noticeMapper.viewNotice(id, noticeid);
    }

    @Override
    public List<Notice> getAllReadedNotice(NoticeVO noticeVO) {
        String id = authMapper.findUserByPhone((String) SecurityUtils.getSubject().getPrincipal()).getId();

        noticeVO.setUserId(id);

        return noticeMapper.getReadedNotice(noticeVO);
    }

    @Override
    public Integer getUnReadNoticeCount(String id) {
        return noticeMapper.getUnReadNoticeCount(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteNotice(String id) {

        noticeMapper.deleteNotice(id);
        noticeMapper.deleteUserNotice(id);

    }

    @Override
    public void updateNotice(Notice notice) {
        noticeMapper.updateNotice(notice);
    }

    @Override
    public List<Notice> getAllNotices(Notice notice) {
        return noticeMapper.getAllNotices(notice);
    }

    @Override
    public Notice getNoticeById(String id) {


        return noticeMapper.getNoticeById(id);
    }

    @Override
    public List<Notice> getAllUnReadNotice(NoticeVO noticeVO) {
        String id = authMapper.findUserByPhone((String) SecurityUtils.getSubject().getPrincipal()).getId();

        noticeVO.setUserId(id);

        return noticeMapper.getUnReadNotice(noticeVO);
    }

    @Override
    public void addNotice(Notice notice) {

        String id = authMapper.findUserByPhone((String) SecurityUtils.getSubject().getPrincipal()).getId();
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        notice.setAddtime(ft.format(dNow));
        notice.setUserid(id);
        noticeMapper.addNotice(notice);

    }
}
