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
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/10/20 16:15  by  王帅（wangshuai@cloud-young.com）创建
 */
public class QRCodeUtil {
//    public static OutputStream buildCode(String url) {
//        ByteArrayOutputStream out = QRCode.from(url).to(ImageType.PNG).stream();
//        return out;
//    }

    /**
     * @param url      网址
     * @param filePath 二维码文件保存路径
     * @param fileName 二维码文件名称
     * @return 成功返回true
     * @Descpription:生成指定网址的二维码文件，并保存在指定路径下，默认格式jpg，默认大小400*400
     * @version 1.0  2018/10/20 17:03   by  王帅（wangshuai@cloud-young.com）创建
     */
    public static boolean createQrCode(String url, String filePath, String fileName) {
        return createQrCode(url, filePath, fileName, "jpg", 400, 400);
    }
    /**
     * @param url      网址
     * @param filePath 二维码文件保存路径
     * @param fileName 二维码文件名称
     *  @param extension 二维码文件格式；jpg/png/bmp 等。
     * @param width 二维码文件宽度
     * @param hight 二维码文件高度
     * @return 成功返回true
     * @Descpription:生成指定网址的二维码文件，并保存在指定路径下
     * @version 1.0  2018/10/20 17:03   by  王帅（wangshuai@cloud-young.com）创建
     */
    public static boolean createQrCode(String url, String filePath, String fileName, String extension, int width, int hight) {
        try {
            Map<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, hight, hints);
            File file = new File(filePath, fileName+"."+extension);
            if (file.exists() || ((file.getParentFile().exists() || file.getParentFile().mkdirs()) && file.createNewFile())) {
                writeToFile(bitMatrix, extension, file);
                //System.out.println("成功生成二维码：" + file);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    /**
     * @param
     * @return
     * @Descpription:生成的二维码写入一个给定的流中
     * @version 1.0  2018/10/20 17:03   by  王帅（wangshuai@cloud-young.com）创建
     */
    static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

}

