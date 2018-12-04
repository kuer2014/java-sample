package com.wang.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/3/8 下午4:30  by  王帅（wangshuai@cloud-young.com）创建
 */
public class InitHello implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return null;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return null;
    }
}
