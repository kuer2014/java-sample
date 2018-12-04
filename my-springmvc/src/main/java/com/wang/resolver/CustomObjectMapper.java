package com.wang.resolver;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;

/**
 * Description:Json 序列化格式控制类
 * All Rights Reserved.
 *
 * @version 1.0  2018/4/3 下午12:05  by  王帅（wangshuai@cloud-young.com）创建
 */
@Component("jacksonObjectMapper")
public class CustomObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = 1L;

    @PostConstruct //影响Servlet生命周期的注解:@PostConstruct和@PreDestroy。
    //被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。
    //PostConstruct在构造函数之后执行,init()方法之前执行。PreDestroy（）方法在destroy()方法执行之后执行
    //注：@PostConstruct和@PreDestroy 标注不属于 Spring，它是在J2EE库- common-annotations.jar。
    public void afterPropertiesSet() throws Exception {
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//        enable(SerializationFeature.WRITE_NULL_MAP_VALUES);
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        setDateFormat(sdf);
    }
}
