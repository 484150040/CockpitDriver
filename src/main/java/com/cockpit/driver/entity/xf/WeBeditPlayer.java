package com.cockpit.driver.entity.xf;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 信息发布
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "webeditplayer", schema = "webeditplayer")
@EntityListeners(AuditingEntityListener.class)
public class WeBeditPlayer {

    @Id
    @Column(name = "id",columnDefinition = "VARCHAR(150) COMMENT '主键id'")
    private String id;
    @Column(name = "name",columnDefinition = "VARCHAR(150) COMMENT '终端名称'")
    private String name;
    @Column(name = "org_id",columnDefinition = "VARCHAR(150) COMMENT '所属机构'")
    private String orgId;
    @Column(name = "ip",columnDefinition = "VARCHAR(150) COMMENT 'IP地址'")
    private String ip;
    @Column(name = "mac",columnDefinition = "VARCHAR(150) COMMENT 'mac地址'")
    private String mac;
    @Column(name = "mask",columnDefinition = "VARCHAR(150) COMMENT '子网掩码'")
    private String mask;
    @Column(name = "gateway",columnDefinition = "VARCHAR(150) COMMENT '默认网关'")
    private String gateway;
    @Column(name = "dns",columnDefinition = "VARCHAR(150) COMMENT 'DNS服务器'")
    private String dns;
    @Column(name = "machine_no",columnDefinition = "VARCHAR(150) COMMENT '机器码'")
    private String machineNo;
    @Column(name = "security_no",columnDefinition = "VARCHAR(150) COMMENT '安全码'")
    private String securityNo;
    @Column(name = "disk_space",columnDefinition = "VARCHAR(150) COMMENT '磁盘空间'")
    private String diskSpace;
    @Column(name = "width",columnDefinition = "INT(11) COMMENT '屏幕宽度'")
    private Integer width;
    @Column(name = "height",columnDefinition = "INT(11) COMMENT '屏幕高度'")
    private Integer height;
    @Column(name = "volume",columnDefinition = "VARCHAR(150) COMMENT '音量'")
    private String volume;
    @Column(name = "status",columnDefinition = "VARCHAR(150) COMMENT '终端状态'")
    private String status;
    @Column(name = "status_change_time",columnDefinition = "DATETIME COMMENT '状态改变时间'")
    private String statusChangeTime;
    @Column(name = "current_program",columnDefinition = "VARCHAR(150) COMMENT '节目名称'")
    private String currentProgram;
    @Column(name = "current_sence",columnDefinition = "VARCHAR(150) COMMENT '场景名称'")
    private String currentSence;
    @Column(name = "version",columnDefinition = "VARCHAR(150) COMMENT '终端版本'")
    private String version;
    @Column(name = "note",columnDefinition = "VARCHAR(150) COMMENT '备注'")
    private String note;
    @Column(name = "create_date",columnDefinition = "DATETIME COMMENT '创建日期'")
    private String createDate;
    @Column(name = "screen_shot",columnDefinition = "VARCHAR(150) COMMENT '终端截图'")
    private String screenShot;
    @Column(name = "system_id",columnDefinition = "VARCHAR(150) COMMENT '系统ID'")
    private String systemId;
    @Column(name = "device_id",columnDefinition = "VARCHAR(150) COMMENT '设备ID'")
    private String deviceId;
    @Column(name = "firmware",columnDefinition = "VARCHAR(150) COMMENT '主键id'")
    private String firmware;
    @Column(name = "cpu_id",columnDefinition = "VARCHAR(150) COMMENT 'CPU ID'")
    private String cpuId;
    @Column(name = "serial_id",columnDefinition = "VARCHAR(150) COMMENT '序列号'")
    private String serialId;
    @Column(name = "longitude",columnDefinition = "VARCHAR(150) COMMENT '经度'")
    private String longitude;
    @Column(name = "latitude",columnDefinition = "VARCHAR(150) COMMENT '纬度'")
    private String latitude;
    @Column(name = "address",columnDefinition = "VARCHAR(150) COMMENT '地址'")
    private String address;
    @Column(name = "monthly_limit_flow",columnDefinition = "VARCHAR(150) COMMENT '每月流量限制'")
    private String monthlyLimitFlow;
    @Column(name = "deviceType",columnDefinition = "VARCHAR(150) COMMENT '设备类型'")
    private String deviceType;
    @Column(name = "brand",columnDefinition = "VARCHAR(150) COMMENT '品牌'")
    private String brand;
    @Column(name = "systemVersion",columnDefinition = "VARCHAR(150) COMMENT '系统版本'")
    private String systemVersion;

}
