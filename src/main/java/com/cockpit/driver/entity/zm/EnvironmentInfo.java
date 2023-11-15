package com.cockpit.driver.entity.zm;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "environment_info", schema = "environment_info")
@EntityListeners(AuditingEntityListener.class)
public class EnvironmentInfo {

    @Id
    @Column(name = "id",columnDefinition = "VARCHAR(150) COMMENT '环境传感器设备 id'")
    private Long id;

    @Column(name = "pm2_5",columnDefinition = "VARCHAR(150) COMMENT 'pm2_5 颗粒物浓度,ug/m3'")
    private String pm25;

     @Column(name = "pm10",columnDefinition = "VARCHAR(150) COMMENT 'PM10 颗 粒 物 浓度,ug/m3'")
    private String pm10;

     @Column(name = "lightIntensity",columnDefinition = "VARCHAR(150) COMMENT '光照强度,W/m2'")
    private String lightIntensity;

     @Column(name = "noise",columnDefinition = "VARCHAR(150) COMMENT '噪声,dB'")
    private String noise;

     @Column(name = "pa",columnDefinition = "VARCHAR(150) COMMENT '大气气压,hPa:'")
    private String pa;

     @Column(name = "ua",columnDefinition = "VARCHAR(150) COMMENT '大 气 相 对 湿度,%RH'")
    private String ua;

     @Column(name = "ta",columnDefinition = "VARCHAR(150) COMMENT '大气温度,℃'")
    private String ta;

     @Column(name = "precipitation",columnDefinition = "VARCHAR(150) COMMENT '降水量,mm'")
    private String precipitation;

     @Column(name = "windspeed",columnDefinition = "VARCHAR(150) COMMENT '风速，m/s'")
    private String windspeed;

     @Column(name = "windDirection",columnDefinition = "VARCHAR(150) COMMENT '风向'")
    private String windDirection;

     @Column(name = "dust",columnDefinition = "VARCHAR(150) COMMENT '粉尘'")
    private String dust;

     @Column(name = "so2",columnDefinition = "VARCHAR(150) COMMENT '二氧化硫,PPB'")
    private String so2;

     @Column(name = "co",columnDefinition = "VARCHAR(150) COMMENT '一氧化碳,PPB'")
    private String co;

     @Column(name = "co2",columnDefinition = "VARCHAR(150) COMMENT '二氧化碳,PPM'")
    private String co2;

     @Column(name = "no2",columnDefinition = "VARCHAR(150) COMMENT '二氧化氮,PPB'")
    private String no2;

     @Column(name = "o3",columnDefinition = "VARCHAR(150) COMMENT '臭氧,PPB'")
    private String o3;

     @Column(name = "sm",columnDefinition = "VARCHAR(150) COMMENT '平均风速值，m/s'")
    private String sm;

     @Column(name = "sn",columnDefinition = "VARCHAR(150) COMMENT '最小风速，m/s'")
    private String sn;

     @Column(name = "sx",columnDefinition = "VARCHAR(150) COMMENT '最大风速，m/s'")
    private String sx;

     @Column(name = "dm",columnDefinition = "VARCHAR(150) COMMENT '平均风向'")
    private String dm;

     @Column(name = "dn",columnDefinition = "VARCHAR(150) COMMENT '最小风向'")
    private String dn;

     @Column(name = "dx",columnDefinition = "VARCHAR(150) COMMENT '最大风向'")
    private String dx;

     @Column(name = "ch2o",columnDefinition = "VARCHAR(150) COMMENT '甲醛,mg/m³'")
    private String ch2o;

     @Column(name = "ns",columnDefinition = "VARCHAR(150) COMMENT '平均噪声,dB'")
    private String ns;

     @Column(name = "ni",columnDefinition = "VARCHAR(150) COMMENT '最小噪声,dB'")
    private String ni;

     @Column(name = "nx",columnDefinition = "VARCHAR(150) COMMENT '最大噪声,dB'")
    private String nx;

     @Column(name = "tvoc",columnDefinition = "VARCHAR(150) COMMENT '挥 发 性 有 机 化 合物,ppm'")
    private String tvoc;
}
