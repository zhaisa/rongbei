package listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import com.rongbei.util.OverrideRetry;

public class RetryListener implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		if (retry == null) {
		annotation.setRetryAnalyzer(OverrideRetry .class);  // 这个类名一定要和上方的对上

		}
		
	}

}
