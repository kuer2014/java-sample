package com.wang;

import com.wang.utils.QRCodeUtil;

import javax.imageio.ImageIO;
import java.io.OutputStream;
import java.util.Dictionary;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/10/20 16:15  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {

     QRCodeUtil.createQrCode("https://www.baidu.com/"
             ,"/Users/wangshuai/Documents/projects/mycode/my-weixin-dev/src/main/resources/qrcode"
             ,"123"
     ,"bmp",200,200);

    }
}
