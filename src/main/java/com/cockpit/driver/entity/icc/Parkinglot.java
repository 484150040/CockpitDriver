package com.cockpit.driver.entity.icc;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 车场余数
 */
@Data
@Entity
@Table(name = "parkinglot", schema = "parkinglot")
@EntityListeners(AuditingEntityListener.class)
public class Parkinglot {

    /**
     * id主键
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     *绑定车场的车辆数
     */
    @Column(name = "car_num")
    private String carNum;

    /**
     *余位数
     */
    @Column(name = "idle_lot")
    private Integer idleLot;


    /**
     *入口数
     */
    @Column(name = "entrance_num")
    private Integer entranceNum;


    /**
     *出口数
     */
    @Column(name = "exitus_num")
    private Integer exitusNum;

    /**
     *绑定的LED数
     */
    @Column(name = "led_num")
    private Integer ledNum;

    /**
     *场区名称
     */
    @Column(name = "parking_lot")
    private String parkingLot;

    /**
     *场区编号
     */
    @Column(name = "parking_lot_code")
    private String parkingLotCode;

    /**
     *总车位数
     */
    @Column(name = "total_lot")
    private String totalLot;

    /**
     *使用了的车位数
     */
    @Column(name = "used_lot")
    private String usedLot;
}
