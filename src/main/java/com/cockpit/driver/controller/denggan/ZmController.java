package com.cockpit.driver.controller.denggan;

import com.cockpit.driver.controller.BaseController;
import com.cockpit.driver.entity.zm.ZmWarnPage;
import com.cockpit.driver.mapper.ZmWarnPageMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 洲明灯杆信息
 */
@RestController
@CrossOrigin
@RequestMapping("/zmWarnPage")
public class ZmController extends BaseController<ZmWarnPageMapper, ZmWarnPage> {

}
