package com.cockpit.driver.vo;

import com.cockpit.driver.config.QueryCondition;
import com.cockpit.driver.entity.FaceControllerChannel;
import com.cockpit.driver.enums.MatchType;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

@Data
public class FaceControllerChannelVO  extends BaseQuery<FaceControllerChannel>  {

    /**
     * 作业编号
     */
    @QueryCondition(func = MatchType.equal)
    private String id;


    /**
     * 控制器通道
     */
    @QueryCondition(func = MatchType.equal)
    private String controllerChannelId;


    /**
     * 人脸通道
     */
    @QueryCondition(func = MatchType.equal)
    private String faceChannelId;



    @Override
    public Specification<FaceControllerChannel> toSpec() {
        return super.toSpecWithAnd();
    }
}
