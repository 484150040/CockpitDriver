package com.cockpit.driver.controller.icc;

import com.cockpit.driver.controller.BaseController;
import com.cockpit.driver.entity.icc.Caraccess;
import com.cockpit.driver.entity.icc.Carcapture;
import com.cockpit.driver.mapper.CarcaptureMapper;
import com.cockpit.driver.utils.ErrorCode;
import com.cockpit.driver.utils.ResultData;
import com.cockpit.driver.vo.CaraccessVO;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 过车数据
 */
@RestController
@CrossOrigin
@RequestMapping("/carcapture")
public class CarcaptureController extends BaseController<CarcaptureMapper, Carcapture> {



}
