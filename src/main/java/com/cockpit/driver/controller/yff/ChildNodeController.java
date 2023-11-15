package com.cockpit.driver.controller.yff;

import com.cockpit.driver.controller.BaseController;
import com.cockpit.driver.entity.yff.GetJfData;
import com.cockpit.driver.mapper.ChildNodeMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 缴费记录
 */
@RestController
@CrossOrigin
@RequestMapping("/childnode")
public class ChildNodeController extends BaseController<ChildNodeMapper, GetJfData> {

}
