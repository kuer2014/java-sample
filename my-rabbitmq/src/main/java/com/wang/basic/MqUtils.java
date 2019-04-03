package com.wang.basic;

import com.rabbitmq.client.ConnectionFactory;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-04-02 09:41  by  王帅（wangshuai@cloud-young.com）创建
 */
public class MqUtils {
    public static final ConnectionFactory getConnectionFactory(){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //factory.setPort(15672);
        factory.setUsername("admin");
        factory.setPassword("n0cxvlfWsRpx");
        return factory;
    }
}
