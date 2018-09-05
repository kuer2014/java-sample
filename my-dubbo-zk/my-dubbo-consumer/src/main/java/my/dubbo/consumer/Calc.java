package my.dubbo.consumer;

import my.dubbo.provider.CalcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/4/24 18:22  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Calc {
    @Autowired
    CalcService calcService;
    public Integer add(){
        return calcService.add(2,4);
    }
}
