package com.cockpit.driver.controller.icc;

import com.cockpit.driver.controller.BaseController;
import com.cockpit.driver.entity.icc.Parkinglot;
import com.cockpit.driver.mapper.ParkinglotMapper;
import com.cockpit.driver.utils.ErrorCode;
import com.cockpit.driver.utils.ResultData;
import com.cockpit.driver.vo.ParkinglotVO;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 车辆余位
 */
@RestController
@CrossOrigin
@RequestMapping("/parkinglot")
public class ParkinglotController extends BaseController<ParkinglotMapper, Parkinglot> {


    /**
     * 查看车辆余位
     *
     * @param parkinglotVO
     * @return
     */
    @SneakyThrows
    @RequestMapping("/findAllPage")
    public ResultData findAllPage(@RequestBody ParkinglotVO parkinglotVO) {
        Page<Parkinglot> users = baseBiz.findAll(parkinglotVO.toSpec(),parkinglotVO.toPageable());
        if (users==null) {
            return ResultData.error(ErrorCode.NULL_OBJ.getValue(), ErrorCode.NULL_OBJ.getDesc());
        }
        return ResultData.success(users);
    }



}
