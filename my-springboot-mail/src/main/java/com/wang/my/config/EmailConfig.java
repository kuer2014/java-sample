package com.wang.my.config;

import com.wang.my.model.EmailEntity;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.codec.EncodingException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/20 13:22  by  王帅（wangshuai@cloud-young.com）创建
 */
@Component
public class EmailConfig {
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @Value("${stmp.host}")
    private String host;
    @Value("${stmp.account}")
    private String account;
    @Value("${stmp.password}")
    private String password;

    @Value("${mail.smtp.auth}")
    private String isAuth;
    @Value("${mail.smtp.timeout}")
    private String outTime;

    @Bean(name = "JavaMailSenderImpl")
    public JavaMailSenderImpl getMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setUsername(account);
        javaMailSender.setPassword(password);
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", isAuth);
        properties.put("mail.smtp.timeout", outTime);
        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }

    /**
     * @param
     * @return
     * @Descpription:发送简单文本邮件
     * @version 1.0  2018/9/20 14:28   by  王帅（wangshuai@cloud-young.com）创建
     */
    public void sendSimpleMail(EmailEntity email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(account);
        String receiver = email.getReceiver();
        String receivers[] = receiver.split(";");
        simpleMailMessage.setTo(receivers);
        simpleMailMessage.setSubject(email.getSubject());
        simpleMailMessage.setText(email.getContent());
        getMailSender().send(simpleMailMessage);
    }

    /**
     * @param
     * @return
     * @Descpription:发送带附件邮件
     * @version 1.0  2018/9/20 17:19   by  王帅（wangshuai@cloud-young.com）创建
     */
    public void sendMimeMail(EmailEntity email) {
        MimeMessage mimMessage = getMailSender().createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimMessage, true, "UTF-8");
            messageHelper.setFrom(account);
            String receiver = email.getReceiver();
            messageHelper.setTo(receiver);
            String receivers[] = receiver.split(";");
            messageHelper.setTo(receivers);

            messageHelper.setSubject(email.getSubject());
            messageHelper.setText(email.getContent(), true);// Set the second
            // Param to True
            if (Files.exists(Paths.get(email.getAttachPath()))) {
                FileSystemResource res = new FileSystemResource(new File(email.getAttachPath()));
                //messageHelper.addInline("pic", res);//用于邮件正文中引用的图片等
                messageHelper.addAttachment("pic", res);//附件
            }
            getMailSender().send(mimMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param
     * @return html 邮件内容
     * @Descpription:借助freeMarker模板引擎生成html格式邮件内容
     * @version 1.0  2018/9/20 14:26   by  王帅（wangshuai@cloud-young.com）创建
     */
    public String resolveFreemarkerTemplate(Map params, String templateRoute) {
        String content = "";
        try {
            // 根据模板内容，动态把map中的数据填充进去，生成HTML
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templateRoute);
            // map中的key，对应模板中的${key}表达式
            content = FreeMarkerTemplateUtils.processTemplateIntoString(template, params);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return content;
    }
}

