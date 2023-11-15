package com.cockpit.driver.entity.yff;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "cbdata", schema = "cbdata")
@EntityListeners(AuditingEntityListener.class)
public class Cbdata {

    @Column(name = "xm",columnDefinition = "VARCHAR(150) COMMENT '姓名'")
    private String xm;

    @Column(name = "mph",columnDefinition = "VARCHAR(150) COMMENT '门牌号'")
    private String mph;

    @Column(name = "zz",columnDefinition = "VARCHAR(150) COMMENT '住址'")
    private String zz;

    @Column(name = "cbz",columnDefinition = "VARCHAR(150) COMMENT '抄表值'")
    private String cbz;

    @Id
    @Column(name = "cbrq",columnDefinition = "VARCHAR(150) COMMENT '抄表日期'")
    private Date cbrq;

    @Column(name = "cbfs",columnDefinition = "VARCHAR(150) COMMENT '抄表方式'")
    private String cbfs;
}
