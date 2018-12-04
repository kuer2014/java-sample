package com.wang.model;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/4/3 下午4:06  by  王帅（wangshuai@cloud-young.com）创建
 */
public class CarValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return Car.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        //把校验信息注册到Error的实现类里
        ValidationUtils.rejectIfEmpty(errors,"name",null,"姓名不能为空!");
        Car car = (Car) o;
        if(StringUtils.isEmpty(car.getId())){
            errors.rejectValue("id",null,"id不能为空!!!!");
        }
    }
}
