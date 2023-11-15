package com.cockpit.driver.service.impl;

import com.alibaba.nacos.client.naming.utils.CollectionUtils;
import com.cockpit.driver.entity.FaceControllerChannel;
import com.cockpit.driver.mapper.FaceControllerChannelMapper;
import com.cockpit.driver.service.FaceControllerChannelService;
import com.cockpit.driver.vo.FaceControllerChannelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaceControllerChannelServiceimpl implements FaceControllerChannelService {

    @Autowired
    private FaceControllerChannelMapper faceControllerChannelMapper;

    @Override
    public List<FaceControllerChannel> selectList(FaceControllerChannelVO faceControllerChannelVO) {
        List<FaceControllerChannel> list = faceControllerChannelMapper.findAll(faceControllerChannelVO.toSpec());
        if (CollectionUtils.isEmpty(list)){
            return new ArrayList<>();
        }
        return list;
    }
}
