package com.cockpit.driver.entity.dhjt;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 动环计通告警
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "dh_alarm", schema = "dh_alarm")
@EntityListeners(AuditingEntityListener.class)
public class DhAlarm {

    @Id
    @Column(name = "event_id",columnDefinition = " VARCHAR(150) COMMENT '事件ID'")
    private String event_id;
    @Column(name = "event_name",columnDefinition = " VARCHAR(150) COMMENT '事件名称'")
    private String event_name;
    @Column(name = "alarm_value",columnDefinition = " VARCHAR(150) COMMENT '告警值'")
    private Double alarm_value;
    @Column(name = "alarm_value_descript",columnDefinition = " VARCHAR(150) COMMENT '告警值描述'")
    private String alarm_value_descript;
    @Column(name = "alarm_time",columnDefinition = " VARCHAR(150) COMMENT '更新时间'")
    private String alarm_time;
    @Column(name = "device_id",columnDefinition = " VARCHAR(150) COMMENT '设备 ID'")
    private String device_id;
    @Column(name = "device_name",columnDefinition = " VARCHAR(150) COMMENT '设备名称'")
    private String device_name;
    @Column(name = "category_name",columnDefinition = " VARCHAR(150) COMMENT '分类名称'")
    private String category_name;
    @Column(name = "area_name",columnDefinition = " VARCHAR(150) COMMENT '区域名称'")
    private String area_name;
    @Column(name = "event_level_name",columnDefinition = " VARCHAR(150) COMMENT '告警等级'")
    private String event_level_name;
    @Column(name = "release_type",columnDefinition = " VARCHAR(150) ")
    private Integer release_type;
}
