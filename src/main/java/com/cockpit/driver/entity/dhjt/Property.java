package com.cockpit.driver.entity.dhjt;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.LinkedHashMap;

/**
 * 动环计通
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "property", schema = "property")
@EntityListeners(AuditingEntityListener.class)
public class Property  {

    @Id
    @Column(name = "property_id",columnDefinition = " VARCHAR(150) COMMENT '参数 id'")
    private String property_id;
    @Column(name = "property_name",columnDefinition = " VARCHAR(150) COMMENT '参数名称'")
    private String property_name;
    @Column(name = "device_id",columnDefinition = " VARCHAR(150) COMMENT '设备 ID'")
    private String device_id;
    @Column(name = "curvalue",columnDefinition = " VARCHAR(150) COMMENT '当前值'")
    private String curvalue;
    @Column(name = "unit",columnDefinition = " VARCHAR(150) COMMENT '单位'")
    private String unit;
    @Column(name = "curstatus",columnDefinition = " INT(11) COMMENT '状态，值大于 0 表示参数告警，等于0 表示参数正常'")
    private Integer curstatus;
    @Column(name = "value_descript",columnDefinition = " VARCHAR(150) COMMENT '值描述'")
    private String value_descript;
}
