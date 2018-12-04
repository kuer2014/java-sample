package com.wang.controller.operatefile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.MalformedURLException;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018-12-04 11:40  by  王帅（wangshuai@cloud-young.com）创建
 */
@Controller
@RequestMapping("/upload")
public class UploadTestController {
    @RequestMapping("/image")
    public String getImagePage(Model model) {
        return "upload/image";
    }
    ///对应前端：1，普通提交，会刷新页面
    @RequestMapping(path = "/uploadImg1", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg1(@RequestPart("imgFile") MultipartFile imgFile, HttpServletRequest req) {
        String realPath = req.getServletContext().getRealPath("/WEB-INF/statics/image");
        String imgFileName = imgFile.getOriginalFilename();
        try {
            File createPath = new File(realPath);
            if (!createPath.exists())
                createPath.mkdirs();
            File targetFile = new File(realPath + "/" + imgFileName);
            imgFile.transferTo(targetFile);
            // savePic(imgFile.getInputStream(),realPath,imgFileName);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        String imgPath = "/image/" + imgFileName;
        return imgPath;
    }

    ///对应前端：2，ajax上传，支持多文件  和 3，ajax上传，不需要from标签的上传
    @RequestMapping(path = "/uploadImg2", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg2(MultipartHttpServletRequest request) {  //接收多文件上传的参数,Part[] aaa
        MultipartFile file = request.getFile("imgFile");// 根据名称获取文件上传域,与页面input的name相同
        MultipartFile file2 = request.getFile("imgFile2");
//        Servlet3.0以后，加入新的api:Part
//      try {
//          Part part = request.getPart("imgFile");//根据名称获取文件上传域
//          part.getContentType();
//      }catch (IOException ioe){
//
//      }catch (ServletException ioe){}
        //request.getParts();//获取所有的文件上传域
        String realPath = request.getServletContext().getRealPath("/WEB-INF/statics/image");
        File imageFile = new File(realPath + "/" + file.getOriginalFilename());// 上传后的文件保存目录及名字
        try {
            file.transferTo(imageFile);// 将上传文件保存到相应位置
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        String imgPath = "/image/" + file.getOriginalFilename();
        return imgPath;
    }
///类似于uploadImg2,但文件接收方式不同，使用了 @RequestPart 注解
    @RequestMapping(path = "/uploadImg3", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg3(@RequestPart("imgFile") MultipartFile imgFile, HttpServletRequest req) {
        String realPath = req.getServletContext().getRealPath("/WEB-INF/statics/image");
        String imgFileName = imgFile.getOriginalFilename();
        try {
            File createPath = new File(realPath);
            if (!createPath.exists())
                createPath.mkdirs();
            File targetFile = new File(realPath + "/" + imgFileName);
            imgFile.transferTo(targetFile);
            // savePic(imgFile.getInputStream(),realPath,imgFileName);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        String imgPath = "/image/" + imgFileName;
        return imgPath;
    }

    private void savePic(InputStream inputStream, String path, String fileName) {
        OutputStream os = null;
        try {
            // String path = "D:\\testFile\\";
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("testpath")
    @ResponseBody
    public String testpath(ServletRequest req) {
        String path = req.getServletContext().getContextPath();
        System.out.println("path:" + path);
        String realPath = req.getServletContext().getRealPath("/WEB-INF/upload");
        System.out.println("realPath:" + realPath);
        try {
            String resourcePath = req.getServletContext().getResource("/WEB-INF/upload").getPath();
            System.out.println("resourcePath:" + resourcePath);
            String resourceFile = req.getServletContext().getResource("/WEB-INF/upload").getFile();
            System.out.println("resourceFile:" + resourceFile);
        } catch (MalformedURLException me) {

        }
        return "ok";
    }
}
