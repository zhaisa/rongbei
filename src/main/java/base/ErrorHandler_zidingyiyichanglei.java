package base;

/**
 * 本类是自定义的异常处理类，指定了发生异常或错误时，要继续或者停止的操作
 * case中有调用本类的方法的地方，出现异常就会继续或者停止测试，并将message写到日志文件中
 * 
 * @author Administrator
 *
 */
public class ErrorHandler_zidingyiyichanglei {

	/**
	 * 在系统日志和测试报告中记录自定义信息message
	 * 
	 * @param message  要输出的自定义信息
	 * @param isReport  是否将自定义信息输出到测试报告中
	 */
	public static void continueRunning(String message) {
		Log.error(message);// 调用日志类中的方法，将message写到日志文件中
	}

	/**
	 * 在程序中捕获到异常后，记录message和异常的堆栈信息到日志。并在报告中输出自定义信息message
	 * 
	 * @param cause  捕获到的原始异常
	 * @param message  要输出的自定义信息
	 * @param isReport  是否将自定义信息输出到测试报告中
	 */
	public static void continueRunning(Throwable cause, String message) {
		Log.error(message, cause);
	}

	/**
	 * 抛出HuiceException，并在系统日志和测试报告中记录自定义信息message
	 * 
	 * @param message  要输出的自定义信息
	 * @param isReport  是否将自定义信息输出到测试报告中
	 */
	public static void stopRunning(String message) {
		Log.error(message);
		throw new HuiceException(message);
	}

	/**
	 * 在程序中捕获到异常后，记录message和异常的堆栈信息到日志。抛出HuiceException，并在报告中输出自定义信息message
	 * 
	 * @param cause  捕获到的原始异常
	 * @param message  要输出的自定义信息
	 * @param isReport  是否将自定义信息输出到测试报告中
	 */
	public static void stopRunning(Throwable cause, String message) {
		Log.error(message, cause);
		throw new HuiceException(message);
	}
}
