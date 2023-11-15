package com.cockpit.driver.vo;

import com.cockpit.driver.config.QueryCondition;
import com.cockpit.driver.entity.icc.Access;
import com.cockpit.driver.enums.MatchType;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class AccessVO extends BaseQuery<Access> {
    /**
     * 作业编号
     */
    @QueryCondition(func = MatchType.equal)
    private String devId;

    /**
     * 设备名称
     */
    @QueryCondition(func = MatchType.like)
    private String devName;


    /**
     * 开门方向
     */
    @QueryCondition(func = MatchType.equal)
    private String direction;


    /**
     * 开门方式
     */
    @QueryCondition(func = MatchType.equal)
    private String openType;


    /**
     * 开门时间
     */
    @QueryCondition(func = MatchType.equal)
    private Long time;

    /**
     * 姓名
     */
    @QueryCondition(func = MatchType.equal)
    private String personName;


    /**
     * 身份证
     */
    @QueryCondition(func = MatchType.equal)
    private String paperNumber;


    /**
     * 入场开始时间
     */
    private Long startTime;

    /**
     * 入场结束时间
     */
    private Long endDate;


    @Override
    public Specification<Access> toSpec() {
        Specification<Access> spec = super.toSpecWithAnd();
        return ((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            predicatesList.add(spec.toPredicate(root, criteriaQuery, criteriaBuilder));
            if (startTime != null) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.greaterThanOrEqualTo(
                                        root.get("time"), startTime)));
            }
            if (endDate != null) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.lessThanOrEqualTo(
                                        root.get("time"), endDate)));
            }
            return criteriaBuilder.and(predicatesList.toArray(new Predicate[predicatesList.size()]));
        });
    }
}
