package com.cockpit.driver.entity.icc;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "carcapture", schema = "carcapture")
@EntityListeners(AuditingEntityListener.class)
public class Carcapture {

    @Id
    @Column(name = "id",columnDefinition = " VARCHAR(150) COMMENT '主键id'")
    private String id;
    @Column(name = "dev_id",columnDefinition = " VARCHAR(150) COMMENT '设备编码'")
    private String devId;
    @Column(name = "dev_chnNum",columnDefinition = " INT(11) COMMENT '卡口相机通道号'")
    private Integer devChnNum;
    @Column(name = "dev_name",columnDefinition = " VARCHAR(150) COMMENT '卡口相机通道名称'")
    private String devName;
    @Column(name = "parking_car_colorStr",columnDefinition = " VARCHAR(150)")
    private String parkingCarColorStr;
    @Column(name = "dev_chn_name",columnDefinition = " VARCHAR(150) COMMENT '卡口相机通道名称'")
    private String devChnName;
    @Column(name = "car_num",columnDefinition = " VARCHAR(150) COMMENT '车牌号'")
    private String carNum;
    @Column(name = "car_num_color",columnDefinition = " INT(11) COMMENT '车牌颜色,参考停车场-车牌颜色'")
    private Integer carNumcolor;
    @Column(name = "car_num_color_str",columnDefinition = " VARCHAR(150) COMMENT '车牌颜色'")
    private String carNumcolorStr;
    @Column(name = "car_type",columnDefinition = " INT(11) COMMENT '车辆类型（1-内部车，0-外部车）'")
    private Integer carType;
    @Column(name = "car_color",columnDefinition = " INT(11) COMMENT '车辆颜色'")
    private Integer carColor;
    @Column(name = "car_direct",columnDefinition = " VARCHAR(150) COMMENT '行车方向，8-进场，9-出场'")
    private String carDirect;
    @Column(name = "car_direct_str",columnDefinition = " VARCHAR(150) COMMENT '行车方向：驶入,驶出'")
    private String carDirectStr;
    @Column(name = "car_way_code",columnDefinition = " VARCHAR(150) COMMENT '车道号'")
    private String carWayCode;
    @Column(name = "cap_time",columnDefinition = " VARCHAR(150) COMMENT '抓拍时间'")
    private String capTime;
    @Column(name = "car_brand",columnDefinition = "  INT(11) COMMENT '车辆商标'")
    private Integer carBrand;
    @Column(name = "car_img_url",columnDefinition = " VARCHAR(150) COMMENT '抓拍图片存放路径'")
    private String carImgUrl;
    @Column(name = "car_num_pic",columnDefinition = " VARCHAR(150) COMMENT '车牌图片存放路径'")
    private String carNumPic;
    @Column(name = "rec_stat",columnDefinition = " INT(11)")
    private Integer recStat;
    @Column(name = "save_flag",columnDefinition = " INT(11)")
    private Integer saveFlag;
    @Column(name = "dc_clean_flag",columnDefinition = " INT(11)")
    private Integer dcCleanflag;
    @Column(name = "car_inner_category",columnDefinition = " INT(11) COMMENT '车辆进出类型'")
    private Integer carInnerCategory;
    @Column(name = "strobe_state",columnDefinition = " INT(11) COMMENT '道闸状态：0-未开闸等待命令开闸，1-白名单已开闸'")
    private Integer strobeState;
    @Column(name = "cap_time_str",columnDefinition = " VARCHAR(150) COMMENT '抓拍时间 YYYY-MM-DD HH24:MI:SS'")
    private String capTimeStr;
    @Column(name = "car_color_str",columnDefinition = " VARCHAR(150) COMMENT '车辆颜色'")
    private String carColorStr;
    @Column(name = "real_capture_pic_path",columnDefinition = " VARCHAR(150) COMMENT '抓拍图片，小图，参考停车子系统方式'")
    private String realCapturePicPath;
    @Column(name = "original_pic_path",columnDefinition = " VARCHAR(150) COMMENT '抓拍图片，大图，参考停车子系统方式'")
    private String originalPicPath;
    @Column(name = "parking_lot_code",columnDefinition = " VARCHAR(150) COMMENT '停车场编码'")
    private String parkingLotCode;
    @Column(name = "parking_lot",columnDefinition = " VARCHAR(150) COMMENT '停车场名称'")
    private String parkingLot;
    @Column(name = "parking_lot_like_str",columnDefinition = " VARCHAR(150)")
    private String parkingLotLikeStr;
    @Column(name = "owner_name",columnDefinition = " VARCHAR(150)")
    private String ownerName;
    @Column(name = "owner_code",columnDefinition = " VARCHAR(150)")
    private String ownerCode;
    @Column(name = "owner_id",columnDefinition = " VARCHAR(150)")
    private String ownerId;
    @Column(name = "parking_car_logo",columnDefinition = " VARCHAR(150) COMMENT '车标'")
    private String parkingCarLogo;
    @Column(name = "parking_car_type",columnDefinition = " VARCHAR(150) COMMENT '参考车型'")
    private String parkingCarType;
    @Column(name = "department_id",columnDefinition = " VARCHAR(150)")
    private String departmentId;
    @Column(name = "name",columnDefinition = " VARCHAR(150)")
    private String name;
    @Column(name = "departmentName",columnDefinition = " VARCHAR(150)")
    private String departmentName;
}
