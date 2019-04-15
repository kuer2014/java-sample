package com.wang.utils;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018-12-19 20:07  by  王帅（wangshuai@cloud-young.com）创建
 */
public class HttpUtil {
   // @Autowired
    private static RestTemplate restTemplate = new RestTemplate();
    public static void main(String[] args) {
// String res= restTemplate.getForObject("http://xxx.cn/adsadmin//adaccount/getdetail?accountId=58",String.class);
//        System.out.println(res);
        test();
    }
    private static void test(){
        String url ="http://appdev.xxx.com/webapi/ecp/userconf/668";
        String res= restTemplate.getForObject(url,String.class);
        System.out.println("res= "+res);
        Map map=  restTemplate.getForObject(url, Map.class);
        System.out.println("Ok");
    }

}



