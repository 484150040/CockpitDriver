package com.cockpit.driver.entity.yff;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "getjfdata", schema = "getjfdata")
@EntityListeners(AuditingEntityListener.class)
public class GetJfData {

    @Id
    @Column(name = "id",columnDefinition = "VARCHAR(150) COMMENT '主键id'")
    private String id;
    @Column(name = "pjcode",columnDefinition = "VARCHAR(150) COMMENT '缴费流水号'")
    private String pjcode;

    @Column(name = "jfje",columnDefinition = "VARCHAR(150) COMMENT '缴费金额'")
    private String jfje;

    @Column(name = "dj",columnDefinition = "VARCHAR(150) COMMENT '单价'")
    private String dj;

    @Column(name = "bcye",columnDefinition = "VARCHAR(150) COMMENT '剩余余额'")
    private String bcye;

    @Column(name = "zhnum",columnDefinition = "VARCHAR(150) COMMENT '缴费户号'")
    private String zhnum;

    @Column(name = "gl",columnDefinition = "VARCHAR(150) COMMENT '购买电量'")
    private String gl;

    @Column(name = "usernm",columnDefinition = "VARCHAR(150) COMMENT '收费人员'")
    private String usernm;
}
