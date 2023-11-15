package com.cockpit.driver.entity.icc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 设备通道查询数据
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "device_channel", schema = "device_channel")
@EntityListeners(AuditingEntityListener.class)
public class DeviceChannel {

    @Id
    @Column(name = "id",columnDefinition = " INT(11) COMMENT '主键id'")
    private Integer id;
    @Column(name = "device_code",columnDefinition = " VARCHAR(150) COMMENT '设备编号'")
    private String deviceCode;
    @Column(name = "unit_type",columnDefinition = " INT(11) COMMENT '单元类型'")
    private Integer unitType;
    @Column(name = "unit_seq",columnDefinition = " INT(11) COMMENT '单元序号'")
    private Integer unitSeq;
    @Column(name = "channel_seq",columnDefinition = " INT(11) COMMENT '通道序号'")
    private Integer channelSeq;
    @Column(name = "channel_code",columnDefinition = " VARCHAR(150) COMMENT '通道code'")
    private String channelCode;
    @Column(name = "channel_name",columnDefinition = " VARCHAR(150) COMMENT '通道名称'")
    private String channelName;
    @Column(name = "owner_code",columnDefinition = " VARCHAR(150) COMMENT '所属组织编码'")
    private String ownerCode;
    @Column(name = "is_online",columnDefinition = " INT(11) COMMENT '在线状态'")
    private Integer isOnline;
    @Column(name = "stat",columnDefinition = " INT(11) COMMENT '状态'")
    private Integer stat;
    @Column(name = "is_virtual",columnDefinition = " INT(11) COMMENT '是否是虚拟通道'")
    private Integer isVirtual;
    @Column(name = "create_time",columnDefinition = " VARCHAR(150) COMMENT '创建时间'")
    private String createTime;
}
