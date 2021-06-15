package com.aifurion.track.mapper;

import com.aifurion.track.entity.VO.WardVO;
import com.aifurion.track.entity.Ward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/4/28 20:27
 */

@Mapper
public interface WardMapper {

    List<String> getAllWardBuilding();

    List<String> getAllWardFloorByBuilding(Ward ward);

    List<String> getAllWardRoomByFloor(Ward ward);

    List<String> getAllWardDedByRoom(Ward ward);


    Ward getWardIdByWard(Ward ward);

    Ward getWardById(String id);

    void updateWardState(String id, String empty);

    List<WardVO> getAllWardPatient(WardVO ward);

    Integer getHospitalizedCount();


}
