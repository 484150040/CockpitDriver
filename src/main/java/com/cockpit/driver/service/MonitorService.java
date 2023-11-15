package com.cockpit.driver.service;

import com.cockpit.driver.vo.MonitorVo;

public interface MonitorService {
    /**
     * 查询icc平台URl
     *
     * @param monitorVo
     * @return
     */
    String get(MonitorVo monitorVo);

    /**
     * 查询电梯状态
     *
     * @param monitorVo
     * @return
     */
    String getStatus(MonitorVo monitorVo);
}
