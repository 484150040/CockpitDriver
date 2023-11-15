package com.cockpit.driver.controller.wl;

import com.cockpit.driver.service.ZljService;
import com.cockpit.driver.utils.ErrorCode;
import com.cockpit.driver.utils.ResultData;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.cockpit.driver.utils.HttpClientUtil.json2map;

/**
 * 物联设备属性
 */
@RestController
@CrossOrigin
@RequestMapping("/deviceItem")
public class DeviceItemController {

    @Autowired
    private ZljService zljService;

    /**
     * 查询属性
     *
     * @return
     */
    @RequestMapping("/select")
    private ResultData select(String devId, String identifier){
        try{
            String body = zljService.select(devId,identifier);
            if (StringUtils.isEmpty(body)){
                return ResultData.error(ErrorCode.NULL_OBJ.getValue(),ErrorCode.NULL_OBJ.getDesc());
            }
            Map<String,Object> map = json2map(body);
            return ResultData.success(map.get("data"));
        }catch (Exception e){
            return ResultData.error(ErrorCode.ERROR_OBJ.getValue(),ErrorCode.ERROR_OBJ.getDesc());
        }
    }

    /**
     * 查询设备
     *
     * @return
     */
    @RequestMapping("/selectDevice")
    private ResultData selectDevice(String devId){
        try{
            String body = zljService.selectDevice(devId);
            if (StringUtils.isEmpty(body)){
                return ResultData.error(ErrorCode.NULL_OBJ.getValue(),ErrorCode.NULL_OBJ.getDesc());
            }
            Map<String,Object> map = json2map(body);
            return ResultData.success(map.get("data"));
        }catch (Exception e){
            return ResultData.error(ErrorCode.ERROR_OBJ.getValue(),ErrorCode.ERROR_OBJ.getDesc());
        }
    }




    /**
     * 设置属性
     *
     * @return
     */
    @RequestMapping("/update")
    private ResultData update(String devId,String identifier,String param){
        try{
            String body = zljService.update(devId,identifier,param);
            if (StringUtils.isEmpty(body)){
                return ResultData.error(ErrorCode.NULL_OBJ.getValue(),ErrorCode.NULL_OBJ.getDesc());
            }
            Map<String,Object> map = json2map(body);
            return ResultData.success(map.get("data"));
        }catch (Exception e){
            return ResultData.error(ErrorCode.ERROR_OBJ.getValue(),ErrorCode.ERROR_OBJ.getDesc());
        }
    }


}
