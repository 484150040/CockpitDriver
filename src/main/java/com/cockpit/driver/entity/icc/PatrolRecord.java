package com.cockpit.driver.entity.icc;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 巡更记录
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "patrolrecord", schema = "patrolrecord")
@EntityListeners(AuditingEntityListener.class)
public class PatrolRecord {

    @Column(name = "duration",columnDefinition = "INT(11) COMMENT '班次时长'")
    private Integer duration;
    @Column(name = "end_time",columnDefinition = "VARCHAR(50) COMMENT '计划结束时间'")
    private String endTime;
    @Column(name = "end_time_str",columnDefinition = "VARCHAR(50) COMMENT '计划结束时间字符串'")
    private String endTimeStr;
    @Column(name = "group_name",columnDefinition = "VARCHAR(50) COMMENT '分组名称'")
    private String groupName;
    @Id
    @Column(name = "id",columnDefinition = "INT(11) COMMENT '记录id'")
    private Integer id;
    @Column(name = "mode")
    private Integer mode;
    @Column(name = "remind_estate")
    private Integer remindEstate;
    @Column(name = "remind_sstate")
    private Integer remindSstate;
    @Column(name = "route_id",columnDefinition = "INT(11) COMMENT '巡更路线id'")
    private Integer routeId;
    @Column(name = "route_name",columnDefinition = "VARCHAR(50)")
    private String routeName;
    @Column(name = "rule_id",columnDefinition = "INT(11) COMMENT '规则id'")
    private Integer ruleId;
    @Column(name = "rule_name",columnDefinition = "VARCHAR(50) COMMENT '规则名称'")
    private String ruleName;
    @Column(name = "schedule_name")
    private String scheduleName;
    @Column(name = "seq",columnDefinition = "INT(11)")
    private Integer seq;
    @Column(name = "sort",columnDefinition = "VARCHAR(50)")
    private String sort;
    @Column(name = "start_time",columnDefinition = "VARCHAR(50) COMMENT '计划开始时间'")
    private String startTime;
    @Column(name = "start_timeStr",columnDefinition = "VARCHAR(50) COMMENT '计划开始时间字符串'")
    private String startTimeStr;
    @Column(name = "stat",columnDefinition = "INT(11) COMMENT '点位状态'")
    private Integer stat;
    @Column(name = "user_names",columnDefinition = "VARCHAR(50) COMMENT '人员名称'")
    private String userNames;
}
