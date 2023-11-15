package com.cockpit.driver.controller.yff;

import com.cockpit.driver.controller.BaseController;
import com.cockpit.driver.entity.yff.Cbdata;
import com.cockpit.driver.mapper.CbdataMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 抄表记录
 */
@RestController
@CrossOrigin
@RequestMapping("/cbdata")
public class CbdataController extends BaseController<CbdataMapper, Cbdata> {

}
