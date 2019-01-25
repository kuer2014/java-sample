package com.wang.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-01-21 16:09  by  王帅（wangshuai@cloud-young.com）创建
 */
@Data
public class UserBehaviorDataVo implements Serializable {

    private static final long serialVersionUID = 5028731232524957012L;

    /**
     * 列表显示的字段名
     */
    private String title;

    /**
     * 线索数量
     */
    private Integer clueCount;

    /**
     * 访问用户数量
     */
    private Integer accessUserCount;

    /**
     * 打开次数
     */
    private Integer openTimes;

    /**
     * 转发/分享用户数量
     */
    private Integer shareUserCount;

    /**
     * 转发/分享次数
     */
    private Integer shareTimes;

    /**
     * 转化率
     */
    private Double conversionRate;

}
