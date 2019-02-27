package base;

import com.rongbei.util.XmlParser_zhengshi;

/**
 * 本类是进行全局配置的类，包括调试浏览器、等待时间、以及项目测试结束后，发送邮件的相关配置等
 * 解析的是config/Config.xml文件
 * 
 * @author Administrator
 *
 */
public class Config {

	public static String debugBrowser;// 单个用例调试时默认启动的浏览器类型
	public static int browserWaitTime;// 浏览器加载的最长等待时间，单位为s
	public static int objectWaitTime;// 对象查找的最长等待时间，单位为s
	public static int pageWaitTime;// 页面加载完成的最长等待时间，单位为s
	public static String objectRespository;// 本次运行依赖的页面对象库路径
	public static int retryTimes;// 失败用例重复执行次数
	public static String SMTPserver;// 邮箱服务器类型
	public static String from;// 发件人邮箱地址
	public static String username;// 发件人邮箱用户名
	public static String password;// 发件人邮箱密码
	public static String to;// 收件人邮箱地址，多个地址时以英文逗号分隔
	public static String copyTo;// 抄送人邮箱地址，多个地址时以英文逗号分隔
	public static String filePath;// 需要添加的附件文件路径
	public static String subject;// 邮件主题

	static {
		XmlParser_zhengshi webXp = new XmlParser_zhengshi("config/Config.xml");
		debugBrowser = webXp.getSingleElementText("/config/debugBrowser");
		browserWaitTime = Integer.valueOf(webXp.getSingleElementText("/config/browserWaitTime"));
		objectWaitTime = Integer.valueOf(webXp.getSingleElementText("/config/objectWaitTime"));
		pageWaitTime = Integer.valueOf(webXp.getSingleElementText("/config/pageWaitTime"));
		objectRespository = webXp.getSingleElementText("/config/objectRespository");
		retryTimes = Integer.valueOf(webXp.getSingleElementText("/config/retryTimes"));
		SMTPserver = webXp.getSingleElementText("/config/mail/smtp");
		from = webXp.getSingleElementText("/config/mail/from");
		username = webXp.getSingleElementText("/config/mail/username");
		password = webXp.getSingleElementText("/config/mail/password");
		to = webXp.getSingleElementText("/config/mail/setTo");
		copyTo = webXp.getSingleElementText("/config/mail/copyTo");
		filePath = webXp.getSingleElementText("/config/mail/filePath");
		subject = webXp.getSingleElementText("/config/mail/subject");
	}

}
