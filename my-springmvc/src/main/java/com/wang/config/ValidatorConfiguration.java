package com.wang.config;

//import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/14 20:45  by  王帅（wangshuai@cloud-young.com）创建
 */
//@Configuration
public class ValidatorConfiguration {
//    @Bean
//    public Validator validator(){
//        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
//                .configure()
//                .addProperty( "hibernate.validator.fail_fast", "true" )
//                .buildValidatorFactory();
//        Validator validator = validatorFactory.getValidator();
//
//        return validator;
//    }
}
