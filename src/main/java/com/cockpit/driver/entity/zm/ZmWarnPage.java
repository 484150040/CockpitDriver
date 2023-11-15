package com.cockpit.driver.entity.zm;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 洲明灯杆告警信息
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "zm_warn_page", schema = "zm_warn_page")
@EntityListeners(AuditingEntityListener.class)
public class ZmWarnPage {

    @Id
    @Column(name = "id",columnDefinition = "VARCHAR(150) COMMENT '主键id'")
    private String id;
    @Column(name = "name",columnDefinition = "VARCHAR(150) COMMENT '名称'")
    private String name;
    @Column(name = "levelName",columnDefinition = "VARCHAR(150) COMMENT '告警名称'")
    private String levelName;
    @Column(name = "primaryClass",columnDefinition = "INT(11) COMMENT '设备类别id'")
    private Integer primaryClass;
    @Column(name = "primaryClassName",columnDefinition = "VARCHAR(150) COMMENT '设备类别名'")
    private String primaryClassName;
    @Column(name = "firstAlarmTime",columnDefinition = "VARCHAR(150) COMMENT '首次告警时间'")
    private String firstAlarmTime;
    @Column(name = "lastAlarmTime",columnDefinition = "VARCHAR(150) COMMENT '最后告警时间'")
    private String lastAlarmTime;
    @Column(name = "level",columnDefinition = "INT(11) COMMENT '告警级别1.提示2.次要3.重要4.紧急'")
    private Integer level;
    @Column(name = "source",columnDefinition = "VARCHAR(150) COMMENT '告警源，设备'")
    private String source;
    @Column(name = "serialNum",columnDefinition = "VARCHAR(150) COMMENT '设备序列号'")
    private String serialNum;
    @Column(name = "dealUserName",columnDefinition = "VARCHAR(150) COMMENT '处理用户名'")
    private String dealUserName;
    @Column(name = "confirmUserName",columnDefinition = "VARCHAR(150) COMMENT '确认用户名'")
    private String confirmUserName;
    @Column(name = "code",columnDefinition = "VARCHAR(150) COMMENT '告警编码'")
    private String code;
    @Column(name = "deviceId",columnDefinition = "VARCHAR(150) ")
    private String deviceId;
    @Column(name = "extendFiled",columnDefinition = "VARCHAR(150) COMMENT '扩展字'")
    private String extendFiled;
    @Column(name = "address",columnDefinition = "VARCHAR(150) COMMENT '地址'")
    private String address;
    @Column(name = "poleId",columnDefinition = "VARCHAR(150) COMMENT '灯杆-id'")
    private String poleId;
    @Column(name = "poleName",columnDefinition = "VARCHAR(150) COMMENT '灯杆-name'")
    private String poleName;
    @Column(name = "alarmPicUrl",columnDefinition = "VARCHAR(150) COMMENT '告警图片'")
    private String alarmPicUrl;
    @Column(name = "projectId",columnDefinition = "VARCHAR(150) COMMENT '项目id'")
    private String projectId;
    @Column(name = "number",columnDefinition = "VARCHAR(150) COMMENT '智慧杆编号'")
    private String number;
    @Column(name = "newAlarm",columnDefinition = "INT(11) COMMENT '是否新告警'")
    private Integer newAlarm;
}
