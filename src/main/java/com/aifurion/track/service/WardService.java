package com.aifurion.track.service;

import com.aifurion.track.entity.VO.WardVO;
import com.aifurion.track.entity.Ward;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/4/28 20:26
 */
public interface WardService {

    List<String> getAllWardBuilding();

    List<String> getAllWardFloorByBuilding(Ward ward);

    List<String> getAllWardRoomByFloor(Ward ward);

    List<String> getAllWardDedByRoom(Ward ward);

    Ward getWardById(String id);

    List<WardVO> getAllWardPatient(WardVO ward);
}
