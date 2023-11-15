package com.cockpit.driver.vo;

import com.cockpit.driver.config.QueryCondition;
import com.cockpit.driver.entity.icc.PatrolRecord;
import com.cockpit.driver.enums.MatchType;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class PatrolRecordVO extends BaseQuery<PatrolRecord> {
    /**
     * 作业编号
     */
    @QueryCondition(func = MatchType.equal)
    private String devId;



    /**
     * 入场开始时间
     */
    private Date startTime;

    /**
     * 入场结束时间
     */
    private Date endDate;


    @Override
    public Specification<PatrolRecord> toSpec() {
        Specification<PatrolRecord> spec = super.toSpecWithAnd();
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
