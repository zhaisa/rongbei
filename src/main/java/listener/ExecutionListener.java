package listener;

import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.CheckPoint;
import base.Log;
import base.TestBase;

/**
 * 本类就是重写的testng监听类，里面的各种方法都可以加上自己想做的操作
 * 本类是执行监听用的，在用例开始跑之前先启动监听，对用例的执行过程进行监听并做相应操作
 * 具体方法的作用在下面每个方法上做出注释
 * 
 * @author Administrator
 *
 */
public class ExecutionListener implements ITestListener {

	protected ExtentReports report;
	protected static ExtentTest test;

	// 1.此方法可以去掉重复的统计（如失败重跑次数），使通过、失败、跳过的用例数统计准确
	@Override
	public void onFinish(ITestContext context) {// onFinish：这个是指在整个test（suite.xml文件中的test）结束时的操作
		// 因为是迭代器，所以使用while循环
		Iterator<ITestResult> listOfFailedTests = context.getFailedTests().getAllResults().iterator();
		while (listOfFailedTests.hasNext()) {
			ITestResult failedTest = listOfFailedTests.next();
			ITestNGMethod method = failedTest.getMethod();
			if (context.getFailedTests().getResults(method).size() > 1) {
				listOfFailedTests.remove();
			}
		}
		System.out.println("成功数：" + context.getPassedTests().size());
		System.out.println("跳过数：" + context.getSkippedTests().size());
		System.out.println("失败数：" + context.getFailedTests().size());
	}

	// 测试开始执行,为所有测试用例添加失败重跑机制
	@Override
	public void onStart(ITestContext context) {
		report = TestBase.getExtent();// 此方法就是得到ExtentReports类型的报告

		System.out.println("测试开始执行,为所有测试用例添加失败重跑机制");
		for (ITestNGMethod method : context.getAllTestMethods()) {
			method.setRetryAnalyzer(new TestRetryAnalyzer());
			System.out.println(method.getMethodName() + " -> set retry");
			Log.info(method.getMethodName() + " -> set retry");
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}

	@Override
	public void onTestFailure(ITestResult result) {// onTestFailure：这个是指在用例（即case）失败时的操作
		String image = test.addScreenCapture("../test-output/snapshot/" + CheckPoint.screenName);
		test.log(LogStatus.FAIL, image);// 失败时截图并将图片嵌到报告页面内
		test.log(LogStatus.FAIL, Reporter.getOutput(result).get(0));// 这个指的是加在extent报告中的日志信息，和输出到Log4j日志文件里的没有关系
		report.endTest(test);
		report.flush();
	}

	// 当用例跳过时的操作
	@Override
	public void onTestSkipped(ITestResult result) {
		report.endTest(test);
		report.flush();
	}

	// 当用例开始时的操作
	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("TestStart!");
		Log.info("TestStart!");
		test = report.startTest(arg0.getName());
	}

	// 当用例成功时的操作
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, Reporter.getOutput(result).get(0));
		report.endTest(test);
		report.flush();
	}

}
