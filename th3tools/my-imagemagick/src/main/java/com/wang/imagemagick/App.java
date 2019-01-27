package com.wang.imagemagick;

import org.im4java.core.CompositeCmd;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018-12-26 10:05  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
               //processImg1();
       // processImg2();
        processImg3();

//        查看安装配置使用：
//        $magick> identify -list configure
//
//        查看安装时支持的图片文件格式：//
//        $magick> identify -list format
    }
    /**
     * @Descpription:图片合成
     * @version 1.0  2018-12-28 14:30   by  王帅（wangshuai@cloud-young.com）创建
     * @param
     * @return
     */
    private static void processImg3() {
        //命令行示例：convert timg.png t1.png -geometry +75+180 -composite d_over.jpg
        String classPath = App.class.getClassLoader().getResource("").getPath();
        IMOperation operation = new IMOperation();
        operation.addImage(classPath + "img/ab.jpg");

        operation.draw("image over 100,100 400,400 '"+classPath + "img/2.jpg'");

        operation.addImage(classPath + "img/ab2.jpg");

        //CompositeCmd cmd = new CompositeCmd();
        ConvertCmd cmd = new ConvertCmd();
        try {
            cmd.run(operation);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /**
     * @Descpription:为图片添加文字
     * @version 1.0  2018-12-28 14:29   by  王帅（wangshuai@cloud-young.com）创建
     * @param
     * @return
     */
    private static void processImg2() {
        String classPath = App.class.getClassLoader().getResource("").getPath();
        IMOperation operation = new IMOperation();
       operation.addImage(classPath + "img/ab.jpg");
       //添加文字
        operation.font("宋体").gravity("southeast").pointsize(18).fill("#FF0000")

                .draw("rotate -15 text 50,25 juziku.com")//倾斜-15度 text:文字对象  50:右边距,25:下边距
                //.rotate(30d)
        ;
        operation.addImage(classPath + "img/drawText.jpg");

        ConvertCmd cmd = new ConvertCmd();
        try {
            cmd.run(operation);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /**
     * @Descpription:图片基本设置，如大小，旋转等
     * @version 1.0  2018-12-28 14:26   by  王帅（wangshuai@cloud-young.com）创建
     * @param
     * @return
     */
    private static void processImg1() {
        String classPath = App.class.getClassLoader().getResource("").getPath();
        IMOperation operation = new IMOperation();
         operation.addImage(classPath + "img/ab.jpg");
        operation.rotate(90d);//旋转 顺时针90度
        /**
         * width：  裁剪的宽度
         * height： 裁剪的高度
         * x：       裁剪的起始横坐标
         * y：       裁剪的起始纵坐标
         */
      //  operation.crop(100,70,100,110);

       // operation.resize(500);//宽度500，按比例设置大小
        operation.addImage(classPath + "img/ab1.jpg");

        ConvertCmd cmd = new ConvertCmd();
        // cmd.setSearchPath("C:\\Program Files\\ImageMagick-7.0.5-Q16");  //Windows需要设置，Linux不需要
        try {
            cmd.run(operation);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
