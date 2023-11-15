package com.cockpit.driver.controller.dh_jt;

import com.alibaba.fastjson.JSON;
import com.cockpit.driver.controller.BaseController;
import com.cockpit.driver.entity.dhjt.Property;
import com.cockpit.driver.mapper.PropertyMapper;
import com.cockpit.driver.utils.ResultData;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 动环设备信息
 */
@RestController
@CrossOrigin
@RequestMapping("/property")
public class PropertyController extends BaseController<PropertyMapper, Property> {


    /**
     * 添加多条记录
     *
     * @param linkedHashMap
     * @return
     */
    @RequestMapping(value = "addall", method = RequestMethod.POST)
    @ResponseBody
    public ResultData addAll(@RequestBody LinkedHashMap linkedHashMap) {
        List<LinkedHashMap> entity = (List<LinkedHashMap>) linkedHashMap.get("data");
        for (LinkedHashMap linkedHashMap1 : entity) {
            Property property = JSON.parseObject(JSON.toJSONString(linkedHashMap1),Property.class);
            baseBiz.save(property);
        }
        return ResultData.success(entity);
    }

}
