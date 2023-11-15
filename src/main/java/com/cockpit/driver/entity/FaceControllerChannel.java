package com.cockpit.driver.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 人脸通道与控制器通道信息表
 */
@Data
@Entity
@Table(name = "face_controller_channel", schema = "face_controller_channel")
@EntityListeners(AuditingEntityListener.class)
public class FaceControllerChannel {

    /**
     * id主键
     */
    @Id
    @Column(name = "id")
    private String id;


    /**
     * 人脸通道
     */
    @Column(name = "controller_channel_id")
    private String controllerChannelId;


    /**
     * 控制器通道
     */
    @Column(name = "face_channel_id")
    private String faceChannelId;
}
