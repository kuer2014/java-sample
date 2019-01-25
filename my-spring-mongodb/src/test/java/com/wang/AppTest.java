package com.wang;

import com.wang.model.TestM;
import com.wang.model.UserBehaviorDataVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-01-21 15:40  by  王帅（wangshuai@cloud-young.com）创建
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mongodb.xml")
//@ContextConfiguration(locations = { "/spring-mongodb.xml" })
//@PropertySource("classpath:log4j.properties")
public class AppTest {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Value("${mongo.collectionName}")
    private String collectionName;

    @Autowired
    private TestM testM;
    @Test
    public void Test2(){
        System.out.println(testM.getName());
    }
    @Test
    public void test1(){
        Aggregation aggregation = newAggregation(
                match(Criteria.where("source").is(1)),
                project("createTimeHour", "createTimeDay", "clueInfo", "platformType")
                        .and("carInfo.serialName").as("serialName")
                        .and("dealerInfo.organizationType").as("organizationType")
                        .and("dealerInfo.orgId").as("orgId")
                        .and("dealerInfo.dealerId").as("dealerId")
                        .and("dealerInfo.dealerFullName").as("dealerName")
                        .and("dealerInfo.provinceName").as("provinceName")
                        .and("dealerInfo.provinceId").as("provinceId")
                        .and("dealerInfo.cityName").as("cityName")
                        .and("dealerInfo.cityId").as("cityId")
                        .and("clue_flag").applyCondition(ConditionalOperators.Cond.newBuilder().when(Criteria.where("operationType").is(400)).then(1).otherwise(0))
                        .and("share_flag").applyCondition(ConditionalOperators.Cond.newBuilder().when(Criteria.where("operationType").is(300)).then(1).otherwise(0))
                        .and("view_flag").applyCondition(ConditionalOperators.Cond.newBuilder().when(Criteria.where("operationType").is(200)).then(1).otherwise(0))
                        .and("open_flag").applyCondition(ConditionalOperators.Cond.newBuilder().when(Criteria.where("operationType").is(100)).then(1).otherwise(0))
                        .and("share_person").applyCondition(ConditionalOperators.Cond.newBuilder().when(Criteria.where("operationType").is(300)).then("$wxUserInfo.openId").otherwise("$$REMOVE"))
                        .and("open_person").applyCondition(ConditionalOperators.Cond.newBuilder().when(Criteria.where("operationType").is(100)).then("$wxUserInfo.openId").otherwise("$$REMOVE"))
                ,
                group("createTimeHour")
                        .sum("clue_flag").as("clueCount")
                        .sum("share_flag").as("shareTimes")
                        .sum("open_flag").as("openTimes")
                        .addToSet("open_person").as("openUserSet")
                        .addToSet("share_person").as("shareUserSet")
                ,
                project("clueCount", "shareTimes", "openTimes")
                        .and("_id").as("title")
                        .and("openUserSet").size().as("accessUserCount")
                        .and("shareUserSet").size().as("shareUserCount"),
                sort(Sort.by("title").descending()),
                skip(Long.valueOf((1) * 10)),
                limit(10)
        );
        AggregationResults<UserBehaviorDataVo> result = mongoTemplate.aggregate(aggregation, collectionName, UserBehaviorDataVo.class);
      //  afterHandler(result.getMappedResults());
        System.out.println( result.getMappedResults().get(0));
    }
}
