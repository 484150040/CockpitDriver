package com.cockpit.driver.service.impl;

import com.cockpit.driver.service.ZljService;
import com.isyscore.os.dev.api.dmc.model.builder.GetAttributeValueRequestBuilder;
import com.isyscore.os.dev.api.dmc.model.builder.GetDeviceRequestBuilder;
import com.isyscore.os.dev.api.dmc.model.builder.SetAttributeValueRequestBuilder;
import com.isyscore.os.dev.api.dmc.model.request.GetDeviceGroupRequest;
import com.isyscore.os.dev.api.dmc.model.request.GetDeviceRequest;
import com.isyscore.os.dev.api.dmc.model.result.GetAttributeValueResult;
import com.isyscore.os.dev.api.dmc.model.result.GetDeviceResult;
import com.isyscore.os.dev.api.dmc.model.result.SetAttributeValueResult;
import com.isyscore.os.dev.api.dmc.service.DmcService;
import com.isyscore.os.dev.util.IsyscoreHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZljServiceimpl implements ZljService {
    /**
     * 自动注入设备服务
     */
    @Autowired
    private DmcService dmcService;

    @Override
    public String update(String devId, String identifier,String param) {
        return setAttributeValueRequest(devId,identifier,param);
    }

    @Override
    public String select(String devId, String identifier) {
        return getAttributeValueRequest(devId,identifier);
    }

    @Override
    public String selectDevice(String devId) {
        return getDeviceValueRequest(devId);
    }

    /**
     * 查询设备信息
     *
     * @param devId
     * @return
     */
    private String getDeviceValueRequest(String devId) {
        GetDeviceRequestBuilder builder = new GetDeviceRequestBuilder();
        IsyscoreHashMap headers = new IsyscoreHashMap();
        builder.setHeaders(headers);
        builder.setDevId(devId);
        GetDeviceResult getDeviceResult = dmcService.getDevice(builder);
        return getDeviceResult.getResponse().getBody();
    }

    /**
     * 设置属性
     *
     * @param devId
     * @param identifier
     * @param param
     */
    private String setAttributeValueRequest(String devId, String identifier, String param) {
        SetAttributeValueRequestBuilder builder = new SetAttributeValueRequestBuilder();
        IsyscoreHashMap headers = new IsyscoreHashMap();
        builder.setHeaders(headers);
        builder.setDevId(devId);
        builder.setIdentifier(identifier);
        builder.setParam(param);
        SetAttributeValueResult setAttributeValueResult = dmcService.setAttributeValue(builder);
        return setAttributeValueResult.getResponse().getBody();
    }

    /**
     * 查询设备属性值
     *
     * @param devId
     * @param identifier
     */
    private String getAttributeValueRequest(String devId, String identifier) {
        GetAttributeValueRequestBuilder builder = new GetAttributeValueRequestBuilder();
        IsyscoreHashMap headers = new IsyscoreHashMap();
        builder.setHeaders(headers);
        builder.setDevId(devId);
        builder.setIdentifier(identifier);
        GetAttributeValueResult getAttributeValueResult = dmcService.getAttributeValue(builder);
        return getAttributeValueResult.getResponse().getBody();
    }
}
