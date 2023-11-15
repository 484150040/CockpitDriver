package com.cockpit.driver.vo;

import com.cockpit.driver.config.QueryCondition;
import com.cockpit.driver.entity.icc.Caraccess;
import com.cockpit.driver.enums.MatchType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.Column;
import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CaraccessVO extends BaseQuery<Caraccess> {
    /**
     * 作业编号
     */
    @QueryCondition(func = MatchType.equal)
    private String id;


    /**
     *车牌号码
     */
    @Column(name = "carNum")
    private String carNum;

    /**
     *车辆停车状态(0-入场，1-已出场，2-只有出场信息，3-强制出场)
     */
    @Column(name = "carStatus")
    private Integer carStatus;

    /**
     *车辆类型（1-内部车，0-外部车）
     */
    @Column(name = "carType")
    private Integer carType;

    /**
     *车辆类型展示字段
     */
    @Column(name = "carTypeStr")
    private String carTypeStr;

    /**
     *入场图片存放路径
     */
    @Column(name = "enterImg")
    private String enterImg;

    /**
     *入场卡口相机通道编码
     */
    @Column(name = "enterItcDevChnid")
    private String enterItcDevChnid;

    /**
     *入场口相机通道名称
     */
    @Column(name = "enterItcDevChnname")
    private String enterItcDevChnname;

    /**
     *入场方式:0-刷卡 1-自动识别
     */
    @Column(name = "enterMode")
    private Integer enterMode;

    /**
     *入场车牌图片存放路径
     */
    @Column(name = "enterNumImg")
    private String enterNumImg;

    /**
     *入场道闸通道编码
     */
    @Column(name = "enterSluiceDevChnid")
    private String enterSluiceDevChnid;

    /**
     *入场道闸通道名称
     */
    @Column(name = "enterSluiceDevChnname")
    private String enterSluiceDevChnname;


    /**
     *入场时间字符串
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String enterTimeStr;


    /**
     *入场车道号
     */
    @Column(name = "enterWayCode")
    private String enterWayCode;


    /**
     *是否ETC用户(0:否 1：是)
     */
    @Column(name = "etcType")
    private String etcType;


    /**
     *出场车牌号
     */
    @Column(name = "exitCarNum")
    private String exitCarNum;


    /**
     *出场图片存放路径
     */
    @Column(name = "exitImg")
    private String exitImg;


    /**
     *出场卡口相机通道编码
     */
    @Column(name = "exitItcDevChnid")
    private String exitItcDevChnid;


    /**
     *出场卡口相机通道名称
     */
    @Column(name = "exitItcDevChnname")
    private String exitItcDevChnname;


    /**
     *出场车牌图片
     */
    @Column(name = "exitNumImg")
    private String exitNumImg;


    /**
     *出场道闸通道编码
     */
    @Column(name = "exitSluiceDevChnid")
    private String exitSluiceDevChnid;


    /**
     *出场道闸通道名称
     */
    @Column(name = "exitSluiceDevChnname")
    private String exitSluiceDevChnname;


    /**
     *出场时间字符串
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String exitTimeStr;


    /**
     *入场车道号
     */
    @Column(name = "exitWayCode")
    private String exitWayCode;


    /**
     *入场抓拍图片
     */
    @Column(name = "originalPicPathEnter")
    private String originalPicPathEnter;


    /**
     *出场抓拍图片
     */
    @Column(name = "originalPicPathExit")
    private String originalPicPathExit;


    /**
     *用户类别：0-临时用户；1-储值用户；2-月卡用户；3-长期用户
     */
    @Column(name = "ownerType")
    private Integer ownerType;


    /**
     *停车场名称
     */
    @Column(name = "parkingLot")
    private String parkingLot;


    /**
     *停车场编码
     */
    @Column(name = "parkingLotCode")
    private String parkingLotCode;


    /**
     *停车收费金额
     */
    @Column(name = "payedMoney")
    private BigDecimal payedMoney;


    /**
     *入场抓拍图片小图
     */
    @Column(name = "realCapturePicPathEnter")
    private String realCapturePicPathEnter;


    /**
     *出场抓拍图片小图
     */
    @Column(name = "realCapturePicPathExit")
    private String realCapturePicPathExit;


    /**
     *车标
     */
    @Column(name = "parkingCarLogo")
    private String parkingCarLogo;


    /**
     *车身颜色,
     */
    @Column(name = "parkingCarColor")
    private String parkingCarColor;

    /**
     * 入场开始时间
     */
    private Date enterstartTime;

    /**
     * 入场结束时间
     */
    private Date enterendDate;

    /**
     * 入场开始时间
     */
    private Date exitstartTime;

    /**
     * 入场结束时间
     */
    private Date exitendDate;

    @Override
    public Specification<Caraccess> toSpec() {
        Specification<Caraccess> spec = super.toSpecWithAnd();
        return ((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            predicatesList.add(spec.toPredicate(root, criteriaQuery, criteriaBuilder));
            if (enterstartTime != null) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.greaterThanOrEqualTo(
                                        root.get("enterTimeStr"), enterstartTime)));
            }
            if (enterendDate != null) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.lessThanOrEqualTo(
                                        root.get("enterTimeStr"), enterendDate)));
            }
            if (exitstartTime != null) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.greaterThanOrEqualTo(
                                        root.get("exitTimeStr"), exitstartTime)));
            }
            if (exitendDate != null) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.lessThanOrEqualTo(
                                        root.get("exitTimeStr"), exitendDate)));
            }
            return criteriaBuilder.and(predicatesList.toArray(new Predicate[predicatesList.size()]));
        });
    }
}
