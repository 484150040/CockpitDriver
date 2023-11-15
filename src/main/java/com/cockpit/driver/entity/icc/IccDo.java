package com.cockpit.driver.entity.icc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class IccDo {
    /**
     * icc路径
     */
    @Value("${icc.host}")
    private String path;
    /**
     * username
     */
    @Value("${icc.username}")
    private String username;
    /**
     * 密码
     */
    @Value("${icc.password}")
    private String password;

    /**
     * clientId
     */
    @Value("${icc.clientId}")
    private String clientId;

    /**
     * clientSecret
     */
    @Value("${icc.clientSecret}")
    private String clientSecret;
}
