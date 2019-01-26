package com.wang.my;

import com.wang.my.config.EmailConfig;
import com.wang.my.model.EmailEntity;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringbootMailApplicationTests {
    @Autowired
    EmailConfig mc;

    @Test
    public void contextLoads() {
        System.out.println(123);
    }

    @Test
    public void sendMail() {
        EmailEntity email = new EmailEntity();
        email.setReceiver("wangshuai@cloud-young.com");
        email.setContent("welcome Email Sender");
        email.setSubject("Spring Boot Java EE Developer");
        mc.sendSimpleMail(email);
        System.out.println("ok");
    }
    /**
     * @Descpription:带附件
     * @version 1.0  2019-01-26 18:24   by  王帅（wangshuai@cloud-young.com）创建
     * @param
     * @return
     */
    @Test
    public void sendAttachMail() {
        EmailEntity email = new EmailEntity();
        email.setReceiver("wangshuai@cloud-young.com");
        email.setContent("请看附件");
        email.setSubject("带附件的");
        String attachPath=MySpringbootMailApplicationTests.class.getClassLoader().getResource("").getPath() +"error.png";
        System.out.println(attachPath);
        email.setAttachPath(attachPath);
        mc.sendMimeMail(email);
        System.out.println("附件 ok");
    }

    /**
     * @Descpription:html模板邮件
     * @version 1.0  2018/9/21 10:34   by  王帅（wangshuai@cloud-young.com）创建
     * @param
     * @return
     */
    @Test
    public void sendHtmlTemplateMail() {
        EmailEntity email = new EmailEntity();
        email.setReceiver("wangshuai@cloud-young.com");
        Map<String, String> param = new HashMap<>();
        param.put("code", "326362");
        String templateFile = "mailtemplate/hello.html";
        String mailContent="";
        try{
            Path path =Paths.get(MySpringbootMailApplicationTests.class.getClassLoader().getResource("").getPath() +templateFile);
            // web 环境获取方式：Path path =Paths.get(request.getSession().getServletContext().getRealPath(request.getContextPath() + "/static/images/email-logo.png"));
       String template= new String(Files.readAllBytes(path)) ;
            mailContent=  template.replace("{code}","326362");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        email.setContent(mailContent);
        email.setSubject("html生成的邮件");
        mc.sendSimpleMail(email);
        System.out.println("ok");
    }
    /**
     * @Descpription:此方式建议在已使用freeMarker的情况下使用
     * mailtemplate/codeEmail.ftl 模板文件放在views目录下
     * @version 1.0  2018/9/20 16:15   by  王帅（wangshuai@cloud-young.com）创建
     * @param
     * @return
     */
    @Test
    public void sendFreemarkerTemplateMail() {
        EmailEntity email = new EmailEntity();
        email.setReceiver("wangshuai@cloud-young.com");
        Map<String, String> param = new HashMap<>();
        param.put("code", "326362");
        String templateFile = "mailtemplate/codeEmail.ftl";
        String mailContent = mc.resolveFreemarkerTemplate(param, templateFile);
        email.setContent(mailContent);
        email.setSubject("freeMarker生成的邮件");
        mc.sendSimpleMail(email);
        System.out.println("ok");
    }
}
