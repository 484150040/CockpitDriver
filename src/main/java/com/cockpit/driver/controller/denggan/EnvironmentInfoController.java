package com.cockpit.driver.controller.denggan;

import com.cockpit.driver.controller.BaseController;
import com.cockpit.driver.entity.zm.EnvironmentInfo;
import com.cockpit.driver.mapper.EnvironmentInfoMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 洲明数据灯杆信息
 */
@RestController
@CrossOrigin
@RequestMapping("/environmentInfo")
public class EnvironmentInfoController extends BaseController<EnvironmentInfoMapper, EnvironmentInfo> {

}
