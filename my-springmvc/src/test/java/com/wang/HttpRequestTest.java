package com.wang;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-03-08 14:43  by  王帅（wangshuai@cloud-young.com）创建
 */
public class HttpRequestTest {
    private static RestTemplate restTemplate = new RestTemplate();
    @Test
    public   void test(){
        String url ="http://appdev.xxx.com/webapi/ecp/userconf/668";
        String res= restTemplate.getForObject(url,String.class);
        System.out.println("res= "+res);
        ResultVo object=  restTemplate.getForObject(url, ResultVo.class);
        System.out.println("Ok");
        Map map=  restTemplate.getForObject(url, Map.class);
        System.out.println("Ok");
    }
   @Test
    public void testJson(){
       String url ="http://appdev.xxx.com/webapi/ecp/userconf/668";
       String res= restTemplate.getForObject(url,String.class);
       try{
           JSONObject jo= JSON.parse(res, JSONObject.class);
           System.out.println(jo);
       } catch (Exception ex){
           ex.printStackTrace();
       }
   }
}
class  ResultVo{
    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(String systemDate) {
        this.systemDate = systemDate;
    }

    public long getSystemTimeMillis() {
        return systemTimeMillis;
    }

    public void setSystemTimeMillis(long systemTimeMillis) {
        this.systemTimeMillis = systemTimeMillis;
    }

    boolean result;
    String errorCode;
    String errorMessage;
    String systemDate;
    long systemTimeMillis;
}