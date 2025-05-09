package day4_11042025;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTest extends Utility implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("Now Test Execution Started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("On Test Case Passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("On Test Case  Failed: " + result.getName());
	/*	try {
			captureSS(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println("On Test Case  Skipped: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("Very Starting Point of Execution");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Execution Ends");
	}
}
