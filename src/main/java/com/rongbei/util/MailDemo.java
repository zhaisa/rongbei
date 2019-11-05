package com.rongbei.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 本类是发送邮件的一个demo，后期可参照此类在实际项目中加上发邮件的功能
 * 
 * @author Administrator
 *
 */
public class MailDemo {

	public static void main(String[] args) throws Exception {

//		EmailSender esend = new EmailSender();
//
//		String content = "";
//		esend.send(content, "text/html;charset=UTF-8");

		 Properties prop=new Properties();
		 prop.setProperty("mail.host", "smtp.163.com");//先要和自己建立链接
		 prop.setProperty("mail.transport.protocol", "smtp");//邮件协议
		 prop.setProperty("mail.smtp.auth", "true");//是否需要安全认证（即用户名、密码）

		// 使用JavaMail发送邮件的5个步骤
		// 1、创建session
		 Session session=Session.getInstance(prop);//单例模式
		// 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
		 session.setDebug(true);

		// 2、通过session得到transport对象
		 Transport ts=session.getTransport();

		// 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人
		 ts.connect("smtp.163.com", "zhaisa21", "182049");

		// 4、创建邮件
		 Message message=createSimpleMail(session);

		// 5、发送邮件
		 ts.sendMessage(message, message.getAllRecipients());
		 ts.close();
	}

	public static MimeMessage createSimpleMail(Session session) throws Exception {
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);

		// 指明邮件的发件人
		message.setFrom(new InternetAddress("zhaisa21@163.com"));

		// 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("zhaisa21@163.com"));

		// 邮件的标题
		message.setSubject("只包含文本的简单邮件");

		// 邮件的文本内容
		message.setContent("你好啊！", "text/html;charset=UTF-8");

		// 返回创建好的邮件对象
		return message;
	}
}
