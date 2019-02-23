package base;

/**
 * 本类是自定义的异常处理的基类，继承于系统的RuntimeException接口
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class HuiceException extends RuntimeException {

	public HuiceException(String message) {
		super(message);// 调用父类的构造方法
	}
}
