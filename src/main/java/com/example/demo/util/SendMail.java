package com.example.demo.util;

import sun.applet.Main;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.concurrent.CyclicBarrier;

public class SendMail {

    public static void sendMail() throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.ssl.enable", false);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.host", "mail.wanhuida.net");
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.host", "smtp.outlook.office365.com");
//        properties.put("mail.smtp.port", "587");
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", true);
//        properties.put("mail.smtp.socketFactory.fallback","true");
//        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        properties.put("mail.smtp.connectiontimeout", "360000");
//        properties.put("mail.smtp.timeout", "360000");
        // 得到回话对象
         Session session = Session.getInstance(properties);
         // 获取邮件对象
         Message message = new MimeMessage(session);
         // 设置发件人邮箱地址
         message.setFrom(new InternetAddress("ipssystem@wanhuida.net"));
         // 设置收件人邮箱地址
//         message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("ipssystem@wanhuida.net"),new InternetAddress("ipssystem@wanhuida.net"),new InternetAddress("ipssystem@wanhuida.net")});
         message.setRecipient(Message.RecipientType.TO, new InternetAddress("1104113465@qq.com"));//一个收件人
         // 设置邮件标题
         message.setSubject("测试邮件");
         // 设置邮件内容
         message.setText("邮件内容邮件内容邮件内容xmqtest");
         // 得到邮差对象
         Transport transport = session.getTransport();
         // 连接自己的邮箱账户
         transport.connect("ipssystem@wanhuida.net", "Qwer=-09");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
         // 发送邮件
         transport.sendMessage(message, message.getAllRecipients());
         transport.close();
    }

    public static void main(String[] args) throws MessagingException {

        int threadNum = 20;
        CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 完成最后任务");
            }
        });

        for(int i = 0; i < threadNum; i++) {
            new Thread(new sendMailThread(barrier)).start();
        }

    }
}
