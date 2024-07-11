package com.qa.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.pageObjects.BaseClass;

public class ExtenReportAndListenersImplementations extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		// Excutes before each test case
		test = extentReport.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName() + " is passed");

	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName() + " is failed");
		test.log(Status.FAIL, result.getThrowable());

		try {
			test.log(Status.INFO, "Screenshot for " + result.getMethod().getMethodName() + " Failure");
			test.addScreenCaptureFromPath(Actions.getScreenshot()); // This method will add failure screenshort to
																	// EXTENT REPORT.

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName() + " is skipped");

	}

	public void onStart(ITestContext context) {
		htmlReporter = new ExtentHtmlReporter("./ExtentReports/"+actualDate+"Time.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("Platform", "Windows10");
		extentReport.setSystemInfo("Testet", "RAJKUMAR");
		extentReport.setSystemInfo("browser", "chrome");

	}

	public void onFinish(ITestContext context) {
		extentReport.flush();
	}
}
