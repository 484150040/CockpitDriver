package com.cockpit.driver.entity.icc;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 车辆通行记录
 */
@Data
@Entity
@Table(name = "caraccess", schema = "caraccess")
@EntityListeners(AuditingEntityListener.class)
public class Caraccess {

    /**
     * id主键
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     *车牌号码
     */
    @Column(name = "car_num")
    private String carNum;

    /**
     *车辆停车状态(0-入场，1-已出场，2-只有出场信息，3-强制出场)
     */
    @Column(name = "car_status")
    private Integer carStatus;

    /**
     *车辆类型（1-内部车，0-外部车）
     */
    @Column(name = "car_type")
    private Integer carType;

    /**
     *车辆类型展示字段
     */
    @Column(name = "car_type_str")
    private String carTypeStr;

    /**
     *入场图片存放路径
     */
    @Column(name = "enter_img")
    private String enterImg;

    /**
     *入场卡口相机通道编码
     */
    @Column(name = "enter_itc_dev_chnid")
    private String enterItcDevChnid;

    /**
     *入场口相机通道名称
     */
    @Column(name = "enter_itc_dev_chnname")
    private String enterItcDevChnname;

    /**
     *入场方式:0-刷卡 1-自动识别
     */
    @Column(name = "enter_mode")
    private Integer enterMode;

    /**
     *入场车牌图片存放路径
     */
    @Column(name = "enter_num_img")
    private String enterNumImg;

    /**
     *入场道闸通道编码
     */
    @Column(name = "enter_sluice_dev_chnid")
    private String enterSluiceDevChnid;

    /**
     *入场道闸通道名称
     */
    @Column(name = "enter_sluice_dev_chnname")
    private String enterSluiceDevChnname;


    /**
     *入场时间
     */
    @Column(name = "enter_time")
    private String enterTime;


    /**
     *入场时间字符串
     */
    @Column(name = "enter_time_str")
    private String enterTimeStr;


    /**
     *入场车道号
     */
    @Column(name = "enter_way_code")
    private String enterWayCode;


    /**
     *是否ETC用户(0:否 1：是)
     */
    @Column(name = "etc_type")
    private String etcType;


    /**
     *出场车牌号
     */
    @Column(name = "exit_car_num")
    private String exitCarNum;


    /**
     *出场图片存放路径
     */
    @Column(name = "exit_img")
    private String exitImg;


    /**
     *出场卡口相机通道编码
     */
    @Column(name = "exit_itc_dev_chnid")
    private String exitItcDevChnid;


    /**
     *出场卡口相机通道名称
     */
    @Column(name = "exit_itc_dev_chnname")
    private String exitItcDevChnname;


    /**
     *出场车牌图片
     */
    @Column(name = "exit_num_img")
    private String exitNumImg;


    /**
     *出场道闸通道编码
     */
    @Column(name = "exit_sluice_dev_chnid")
    private String exitSluiceDevChnid;


    /**
     *出场道闸通道名称
     */
    @Column(name = "exit_sluice_dev_chnname")
    private String exitSluiceDevChnname;


    /**
     *出场时间
     */
    @Column(name = "exit_time")
    private String exitTime;


    /**
     *出场时间字符串
     */
    @Column(name = "exit_time_str")
    private String exitTimeStr;


    /**
     *入场车道号
     */
    @Column(name = "exit_way_code")
    private String exitWayCode;


    /**
     *入场抓拍图片
     */
    @Column(name = "original_pic_path_enter")
    private String originalPicPathEnter;


    /**
     *出场抓拍图片
     */
    @Column(name = "original_pic_path_exit")
    private String originalPicPathExit;


    /**
     *用户类别：0-临时用户；1-储值用户；2-月卡用户；3-长期用户
     */
    @Column(name = "owner_type")
    private Integer ownerType;


    /**
     *停车场名称
     */
    @Column(name = "parking_lot")
    private String parkingLot;


    /**
     *停车场编码
     */
    @Column(name = "parking_lot_code")
    private String parkingLotCode;


    /**
     *停车收费金额
     */
    @Column(name = "payed_money")
    private BigDecimal payedMoney;


    /**
     *入场抓拍图片小图
     */
    @Column(name = "real_capture_pic_path_enter")
    private String realCapturePicPathEnter;


    /**
     *出场抓拍图片小图
     */
    @Column(name = "real_capture_pic_path_exit")
    private String realCapturePicPathExit;


    /**
     *车标
     */
    @Column(name = "parking_car_logo")
    private String parkingCarLogo;


    /**
     *车身颜色,
     */
    @Column(name = "parking_car_color")
    private String parkingCarColor;
}
