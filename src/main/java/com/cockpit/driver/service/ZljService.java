package com.cockpit.driver.service;

public interface ZljService {

    /**
     * 设置属性
     *
     * @param devId
     * @param param
     */
    String update(String devId, String identifier,String param);


    /**
     * 查询属性
     *
     * @param devId
     * @param identifier
     * @return
     */
    String select(String devId, String identifier);

    /**
     * 查询设备
     *
     * @param devId
     * @return
     */
    String selectDevice(String devId);
}
