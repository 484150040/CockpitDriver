package com.cockpit.driver.vo;

import com.cockpit.driver.config.QueryCondition;
import com.cockpit.driver.entity.icc.Parkinglot;
import com.cockpit.driver.enums.MatchType;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

@Data
public class ParkinglotVO extends BaseQuery<Parkinglot> {

    /**
     * 作业编号
     */
    @QueryCondition(func = MatchType.equal)
    private String devId;

    /**
     *场区名称
     */
    @QueryCondition(func = MatchType.like)
    private String parkingLot;

    /**
     *场区编号
     */
    @QueryCondition(func = MatchType.equal)
    private String parkingLotCode;

    @Override
    public Specification<Parkinglot> toSpec() {
        return super.toSpecWithAnd();
    }
}
