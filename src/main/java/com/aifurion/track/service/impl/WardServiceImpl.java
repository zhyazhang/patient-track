package com.aifurion.track.service.impl;

import com.aifurion.track.entity.VO.WardVO;
import com.aifurion.track.entity.Ward;
import com.aifurion.track.mapper.WardMapper;
import com.aifurion.track.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/4/28 20:26
 */

@Service
public class WardServiceImpl implements WardService {

    @Autowired
    private WardMapper wardMapper;


    @Override
    public List<WardVO> getAllWardPatient(WardVO ward) {

        return wardMapper.getAllWardPatient(ward);
    }

    @Override
    public List<String> getAllWardBuilding() {
        return wardMapper.getAllWardBuilding();
    }

    @Override
    public List<String> getAllWardFloorByBuilding(Ward ward) {
        return wardMapper.getAllWardFloorByBuilding(ward);
    }

    @Override
    public List<String> getAllWardRoomByFloor(Ward ward) {
        return wardMapper.getAllWardRoomByFloor(ward);
    }

    @Override
    public List<String> getAllWardDedByRoom(Ward ward) {
        return wardMapper.getAllWardDedByRoom(ward);
    }


    @Override
    public Ward getWardById(String id) {
        return wardMapper.getWardById(id);
    }
}
