package com.wang.my.model;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/20 13:21  by  王帅（wangshuai@cloud-young.com）创建
 */
public class EmailEntity {

    private String receiver;
    private String subject;
    private String text;
    private String content;
    private  String attachPath;
    /***
     * 附件完整路径
     */
    public String getAttachPath() {
        return attachPath;
    }

    /***
     * 附件完整路径
     * @param attachPath
     */
    public void setAttachPath(String attachPath) {
        this.attachPath = attachPath;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
