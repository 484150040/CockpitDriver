package com.cockpit.driver.controller.icc;

import com.cockpit.driver.service.MonitorService;
import com.cockpit.driver.utils.ErrorCode;
import com.cockpit.driver.utils.ResultData;
import com.cockpit.driver.vo.MonitorVo;
import lombok.SneakyThrows;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.cockpit.driver.utils.HttpClientUtil.json2map;

/**
 * 大华ICC平台
 */
@RestController
@CrossOrigin
@RequestMapping("/monitor")
public class MonitorController {


    @Autowired
    private MonitorService monitorService;
    /**
     * 查询配置信息
     *
     * @return
     */
    @SneakyThrows
    @RequestMapping("/getMonitorUrl")
    public ResultData getMonitorUrl(String channelId,String dataType,String streamType) {
        MonitorVo monitorVo = new MonitorVo();
        monitorVo.setChannelId(channelId);
        monitorVo.setDataType(dataType);
        monitorVo.setStreamType(streamType);
        System.out.println(monitorVo.toString());
        String url = monitorService.get(monitorVo);
        if (StringUtils.isEmpty(url)){
            return ResultData.error(ErrorCode.NULL_OBJ.getValue(), ErrorCode.NULL_OBJ.getDesc());
        }
        return ResultData.success(url);
    }

    /**
     * 查询电梯状态
     *
     * @return
     */
    @SneakyThrows
    @RequestMapping("/getMonitorStatus")
    public ResultData getMonitorStatus(String channelId) {
        MonitorVo monitorVo = new MonitorVo();
        monitorVo.setChannelId(channelId);
        String body = monitorService.getStatus(monitorVo);
        if (StringUtils.isEmpty(body)){
            return ResultData.error(ErrorCode.NULL_OBJ.getValue(), ErrorCode.NULL_OBJ.getDesc());
        }
        Map<String,Object> map = json2map(body);
        for (String s : map.keySet()) {
            map.put(s,map.get(s).toString().replace(".0",""));
        }
        return ResultData.success(map);
    }


    /**
     * 云台控制
     *
     * @return
     */
    @SneakyThrows
    @RequestMapping("/operateDirect")
    public ResultData operateDirect(String channelId) {
        MonitorVo monitorVo = new MonitorVo();
        monitorVo.setChannelId(channelId);
        String body = monitorService.getStatus(monitorVo);
        if (StringUtils.isEmpty(body)){
            return ResultData.error(ErrorCode.NULL_OBJ.getValue(), ErrorCode.NULL_OBJ.getDesc());
        }
        Map<String,Object> map = json2map(body);
        for (String s : map.keySet()) {
            map.put(s,map.get(s).toString().replace(".0",""));
        }
        return ResultData.success(map);
    }

}
