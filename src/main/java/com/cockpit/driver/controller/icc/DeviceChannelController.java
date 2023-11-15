package com.cockpit.driver.controller.icc;

import com.cockpit.driver.controller.BaseController;
import com.cockpit.driver.entity.icc.DeviceChannel;
import com.cockpit.driver.mapper.DeviceChannelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 设备通道信息
 */
@RestController
@CrossOrigin
@RequestMapping("/deviceChannel")
public class DeviceChannelController extends BaseController<DeviceChannelMapper, DeviceChannel> {

}
