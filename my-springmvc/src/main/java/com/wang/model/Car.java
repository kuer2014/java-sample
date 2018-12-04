package com.wang.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/4/3 上午11:10  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Car {
    public Car() {

    }

    public Car(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private Integer id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
      //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", locale = "zh", timezone = "GMT+8")
    private Date marketDate;
    public Date getMarketDate() {
        return marketDate;
    }

    public void setMarketDate(Date marketDate) {
        this.marketDate = marketDate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
