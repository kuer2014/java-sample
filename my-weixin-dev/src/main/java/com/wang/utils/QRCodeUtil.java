package com.wang.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;


/**
 * Description:二维码工具类
 * All Rights Reserved.
 *
 * @version 1.0  2018/10/20 16:15  by  王帅（wangshuai@cloud-young.com）创建
 */
public class QRCodeUtil {

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;
    private static final String CHARACTER_SET = "UTF-8";
    private static final String DEFAULT_FORMAT = "jpg";
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    /**
     * @param url      网址
     * @param filePath 二维码文件保存路径
     * @param fileName 二维码文件名称
     * @return 成功返回true
     * @Descpription:生成指定网址的二维码文件，并保存在指定路径下，默认格式jpg，默认大小400*400
     * @version 1.0  2018/10/20 17:03   by  王帅（wangshuai@cloud-young.com）创建
     */
    public static boolean createQrCode(String url, String filePath, String fileName) {
        return createQrCode(url, filePath, fileName, DEFAULT_FORMAT, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    /**
     * @param url      网址
     * @param filePath 二维码文件保存路径
     * @param fileName 二维码文件名称
     * @param format   二维码文件格式；jpg/png/bmp 等。
     * @param width    二维码文件宽度
     * @param height   二维码文件高度
     * @return 成功返回true
     * @Descpription:生成指定网址的二维码文件，并保存在指定路径下
     * @version 1.0  2018/10/20 17:03   by  王帅（wangshuai@cloud-young.com）创建
     */
    public static boolean createQrCode(String url, String filePath, String fileName, String format, int width, int height) {
        try {
            Map<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, CHARACTER_SET);
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
            File file = new File(filePath, fileName + "." + format);
            if (file.exists() || ((file.getParentFile().exists() || file.getParentFile().mkdirs()) && file.createNewFile())) {
                writeToFile(bitMatrix, format, file);
                //System.out.println("成功生成二维码：" + file);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    private static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    /**
     * @param stream 存储二维码文件的流
     * @return
     * @Descpription:生成的二维码写入一个给定的流中
     * @version 1.0  2018/10/22 18:27   by  王帅（wangshuai@cloud-young.com）创建
     */
    public static boolean createQrCode(String url, OutputStream stream) {
        return createQrCode(url, stream, DEFAULT_FORMAT, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    /**
     * @param stream 存储二维码文件的流
     * @return
     * @Descpription:生成的二维码写入一个给定的流中
     * @version 1.0  2018/10/20 17:03   by  王帅（wangshuai@cloud-young.com）创建
     */
    public static boolean createQrCode(String url, OutputStream stream, String format, int width, int height) {
        try {
            Map<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
            writeToStream(bitMatrix, format, stream);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }

    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        // BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        BufferedImage image = loadImage();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    //11.1测试
    private static BufferedImage loadImage() {
        //Path file = new Path(); BASE_IMAGE_PATH.resolve(fileName);
//        Path fpath2 = Paths.get(fileName);
//        if (!Files.exists(file)) {
//            // try starting with 'core' since the test base is often given as the project root
//            file = Paths.get("core/").resolve(BASE_IMAGE_PATH).resolve(fileName);
//        }
        try {
            File file = new File("/Users/wangshuai/Documents/projects/mycode/my-weixin-dev/src/main/resources/qrcode/test_file2.jpg");
            return ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}

