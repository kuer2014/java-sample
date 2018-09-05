package my.dubbo.provider;

import org.springframework.stereotype.Service;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/4/24 17:49  by  王帅（wangshuai@cloud-young.com）创建
 */
public class CalcServiceImpl implements CalcService {
    public Integer add(Integer x, Integer y) {
        return x+y;
    }
}
