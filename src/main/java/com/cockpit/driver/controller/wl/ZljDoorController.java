package com.cockpit.driver.controller.wl;

import com.alibaba.nacos.client.naming.utils.CollectionUtils;
import com.cockpit.driver.entity.FaceControllerChannel;
import com.cockpit.driver.service.FaceControllerChannelService;
import com.cockpit.driver.service.ZljService;
import com.cockpit.driver.utils.ErrorCode;
import com.cockpit.driver.utils.ResultData;
import com.cockpit.driver.vo.FaceControllerChannelVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.cockpit.driver.utils.HttpClientUtil.json2map;

/**
 * 门禁设置通道
 */
@RestController
@CrossOrigin
@RequestMapping("/zljdoor")
public class ZljDoorController {

    @Autowired
    private ZljService zljService;

    @Autowired
    private FaceControllerChannelService faceControllerChannelService;


    /**
     * 设置属性门禁控制
     *
     * @return
     */
    @RequestMapping("/updateDoor")
    private ResultData updateDoor(String devId,String identifier,String param){
        try{
            String body = zljService.update(devId,identifier,param);

            if (StringUtils.isEmpty(body)){
                return ResultData.error(ErrorCode.NULL_OBJ.getValue(),ErrorCode.NULL_OBJ.getDesc());
            }
            FaceControllerChannelVO faceControllerChannelVO = new FaceControllerChannelVO();
            faceControllerChannelVO.setFaceChannelId(devId);
            List<FaceControllerChannel> faceControllerChannelList = faceControllerChannelService.selectList(faceControllerChannelVO);
            if (CollectionUtils.isEmpty(faceControllerChannelList)){
                Map<String,Object> map = json2map(body);
                return ResultData.success(map.get("data"));
            }
            for (FaceControllerChannel faceControllerChannel : faceControllerChannelList) {
                zljService.update(faceControllerChannel.getControllerChannelId(),identifier,param);
            }
            Map<String,Object> map = json2map(body);
            return ResultData.success(map.get("data"));
        }catch (Exception e){
            return ResultData.error(ErrorCode.ERROR_OBJ.getValue(),ErrorCode.ERROR_OBJ.getDesc());
        }
    }


}
