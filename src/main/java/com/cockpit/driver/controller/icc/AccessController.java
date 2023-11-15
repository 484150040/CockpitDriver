package com.cockpit.driver.controller.icc;

import com.cockpit.driver.controller.BaseController;
import com.cockpit.driver.entity.icc.Access;
import com.cockpit.driver.mapper.AccessMapper;
import com.cockpit.driver.utils.ErrorCode;
import com.cockpit.driver.utils.ResultData;
import com.cockpit.driver.vo.AccessVO;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 门禁信息
 */
@RestController
@CrossOrigin
@RequestMapping("/access")
public class AccessController extends BaseController<AccessMapper, Access> {


    /**
     * 查询门禁信息
     *
     * @param devId
     * @param startTime
     * @param endTime
     * @param page
     * @param size
     * @return
     */
    @SneakyThrows
    @RequestMapping("/findAllPage")
    public ResultData findAllPage(String devId,Long startTime,Long endTime,Integer page,Integer size) {
        AccessVO accessVO = new AccessVO();
        accessVO.setDevId(devId);
        accessVO.setStartTime(startTime);
        accessVO.setEndDate(endTime);
        accessVO.setPageSize(size);
        accessVO.setPageIndex(page);
        Page<Access> users = baseBiz.findAll(accessVO.toSpec(),accessVO.toPageable());
        if (users==null) {
            return ResultData.error(ErrorCode.NULL_OBJ.getValue(), ErrorCode.NULL_OBJ.getDesc());
        }
        return ResultData.success(users);
    }



}
