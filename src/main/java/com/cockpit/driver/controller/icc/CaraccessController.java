package com.cockpit.driver.controller.icc;

import com.cockpit.driver.controller.BaseController;
import com.cockpit.driver.entity.icc.Caraccess;
import com.cockpit.driver.mapper.CaraccessMapper;
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
 * 车辆道闸
 */
@RestController
@CrossOrigin
@RequestMapping("/caraccess")
public class CaraccessController extends BaseController<CaraccessMapper, Caraccess> {


    /**
     * 查询车辆道闸信息
     *
     * @param dictionaryVol
     * @return
     */
    @SneakyThrows
    @RequestMapping("/findAllPage")
    public ResultData findAllPage(@RequestBody CaraccessVO dictionaryVol) {
        Page<Caraccess> users = baseBiz.findAll(dictionaryVol.toSpec(),dictionaryVol.toPageable());
        if (users==null) {
            return ResultData.error(ErrorCode.NULL_OBJ.getValue(), ErrorCode.NULL_OBJ.getDesc());
        }
        return ResultData.success(users);
    }



}
