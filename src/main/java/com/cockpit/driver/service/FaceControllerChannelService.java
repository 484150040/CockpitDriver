package com.cockpit.driver.service;

import com.cockpit.driver.entity.FaceControllerChannel;
import com.cockpit.driver.vo.FaceControllerChannelVO;

import java.util.List;

public interface FaceControllerChannelService {
    /**
     * 通过设备id查询所有关联通道门禁
     * 
     * @param faceControllerChannelVO
     * @return
     */
    List<FaceControllerChannel> selectList(FaceControllerChannelVO faceControllerChannelVO);
}
