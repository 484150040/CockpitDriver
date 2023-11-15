package com.cockpit.driver.entity.icc;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 门禁通行记录
 */
@Data
@Entity
@Table(name = "access", schema = "access")
@EntityListeners(AuditingEntityListener.class)
public class Access {

    /**
     * id主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;


    /**
     * 设备编号
     */
    @Column(name = "dev_id")
    private String devId;
    /**
     * 设备名称
     */
    @Column(name = "dev_name")
    private String devName;


    /**
     * 开门方向
     */
    @Column(name = "direction")
    private String direction;


    /**
     * 开门方式
     */
    @Column(name = "open_type")
    private String openType;


    /**
     * 开门时间
     */
    @Column(name = "time")
    private Long time;

    /**
     * 姓名
     */
    @Column(name = "person_name")
    private String personName;


    /**
     * 身份证
     */
    @Column(name = "paper_number")
    private String paperNumber;


    /**
     * 录入照片
     */
    @Column(name = "person_image")
    private String personImage;


    /**
     * 记录照片
     */
    @Column(name = "record_image")
    private String recordImage;

}
