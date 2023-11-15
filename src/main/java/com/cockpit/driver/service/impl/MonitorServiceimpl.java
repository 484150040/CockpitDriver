package com.cockpit.driver.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cockpit.driver.entity.icc.IccDo;
import com.cockpit.driver.service.MonitorService;
import com.cockpit.driver.utils.DHhttpCleentUtil;
import com.cockpit.driver.vo.MonitorVo;
import com.dahuatech.icc.oauth.http.DefaultClient;
import com.dahuatech.icc.oauth.http.IClient;
import lombok.SneakyThrows;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.cockpit.driver.utils.HttpClientUtil.sendGet;


/**
 * 大华ICC平台
 */
@Service
public class MonitorServiceimpl implements MonitorService {
    private static final Logger log = LoggerFactory.getLogger(MonitorServiceimpl.class);
    @Autowired
    private DHhttpCleentUtil dHhttpCleentUtil;

    private IClient iClient = null;
    @Autowired
    private IccDo iccDo;

    @Value("${camera.url}")
    private String url;

    @SneakyThrows
    @Override
    public String get(MonitorVo monitorVo) {
        iClient = new DefaultClient(iccDo.getPath(),iccDo.getUsername(),iccDo.getPassword(),iccDo.getClientId(),iccDo.getClientSecret());
        String responseBody="";
        try {
            String channelId = monitorVo.getChannelId();
            String dataType = monitorVo.getDataType();
            String streamType = monitorVo.getStreamType();
            Map<String, Object> param = new HashMap<>();
            Map<String, Object> data = new HashMap<>();
            data.put("channelId",channelId);
            data.put("streamType",streamType);
//            data.put("type",dataType);
            data.put("dataType",dataType);
            param.put("data",data);
            String datas = dHhttpCleentUtil.post("/evo-apigw/admin/API/MTS/Video/StartVideo",param,iClient);
//            String datas = dHhttpCleentUtil.post("/evo-apigw/admin/API/video/stream/realtime",param,iClient);
            log.info(datas);
            //服务出参
            JSONObject roots = JSONObject.parseObject(datas);
            JSONObject jsonObject = JSONObject.parseObject(roots.getString("data"));
//            responseBody  = jsonObject.getString("url")+"?token="+iClient.getAccessToken().getAccess_token();
            responseBody  = jsonObject.getString("url")+"?token="+jsonObject.getInteger("token")+"&&trackID=0";
        } catch (Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage(),e);
        }
        return responseBody;
    }

    @SneakyThrows
    @Override
    public String getStatus(MonitorVo monitorVo) {
        String channelId = monitorVo.getChannelId().replace("$","");
        String body = sendGet(url+"?deviceId="+channelId,new HashMap<>());
        if (StringUtils.isEmpty(body)){
            return null;
        }
        return body;
    }

}
