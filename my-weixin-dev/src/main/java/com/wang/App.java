package com.wang;

import com.wang.utils.QRCodeUtil;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
        createQRCodeFile();
       // createQRCodeStream();
    }

    private static void createQRCodeFile() {
        boolean result = QRCodeUtil.createQrCode("https://www.baidu.com/"
                , "/Users/wangshuai/Documents/projects/mycode/my-weixin-dev/src/main/resources/qrcode"
                , "test_file2-1"
                //  , "jpg", 200, 200
        );
        System.out.println(result);
    }

    private static void createQRCodeStream() {
        try {
            // 第1步、使用File类找到一个文件
            File f = new File("/Users/wangshuai/Documents/projects/mycode/my-weixin-dev/src/main/resources/qrcode/test1.jpg");    // 声明File对象
            // 第2步、通过子类实例化父类对象
            OutputStream out = null;    // 准备好一个输出的对象
            out = new FileOutputStream(f);    // 通过对象多态性，进行实例化
            boolean result = QRCodeUtil.createQrCode("https://www.baidu.com/"
                    , out
                    //  , "jpg", 200, 200
            );
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
