package com.cockpit.driver.service.impl;

import com.cockpit.driver.mapper.CaraccessMapper;
import com.cockpit.driver.service.CaraccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 门禁
 */
@Service
public class AccessServiceimpl implements CaraccessService {

    @Autowired
    private CaraccessMapper caraccessMapper;
}
