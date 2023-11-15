package com.cockpit.driver.controller.icc;

import com.cockpit.driver.controller.BaseController;
import com.cockpit.driver.entity.icc.PatrolRecord;
import com.cockpit.driver.mapper.PatrolRecordMapper;
import com.cockpit.driver.utils.ErrorCode;
import com.cockpit.driver.utils.ResultData;
import com.cockpit.driver.vo.PatrolRecordVO;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ResourceBundle;

/**

 * 电子巡更
 */
@RestController
@CrossOrigin
@RequestMapping("/patrolrecord")
public class PatrolRecordController extends BaseController<PatrolRecordMapper, PatrolRecord> {


    private ResourceBundle resourceBundle;
    /**
     * 查询巡更记录
     *
     * @param patrolRecordVO
     * @return
     */
    @SneakyThrows
    @RequestMapping("/findAllPage")
    public ResultData findAllPage(@RequestBody PatrolRecordVO patrolRecordVO) {
        Page<PatrolRecord> users = baseBiz.findAll(patrolRecordVO.toSpec(),patrolRecordVO.toPageable());
        if (users==null) {
            return ResultData.error(ErrorCode.NULL_OBJ.getValue(), ErrorCode.NULL_OBJ.getDesc());
        }
        return ResultData.success(users);
    }

}
