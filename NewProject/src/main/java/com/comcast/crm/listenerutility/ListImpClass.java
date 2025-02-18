package com.comcast.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseclassutility.BaseClass;
import com.comcast.crm.genericutility.webdriverutility.UtilityClassObject;

public class ListImpClass implements ITestListener, ISuiteListener{
	
	public ExtentReports reports;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		// Spark report configuration:
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport3/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add Environment information and create test:
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("OS", "Windows-10");
		reports.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		reports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("==="+result.getMethod().getMethodName()+"===");
		test = reports.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"===Started===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("==="+result.getMethod().getMethodName()+" PASSED ===");
		
//		String testName = result.getMethod().getMethodName();
//		TakesScreenshot tks = (TakesScreenshot) (BaseClass.sdriver);
//		String screenshotAs = tks.getScreenshotAs(OutputType.BASE64);
//		String time = new Date().toString().replace(" ", "_").replace(":", "_");
//		
//		test.addScreenCaptureFromBase64String(screenshotAs, testName+"_"+time);
		
		test.log(Status.INFO, result.getMethod().getMethodName()+"===Completed===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot tks = (TakesScreenshot) (BaseClass.sdriver);
		String screenshotAs = tks.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		test.addScreenCaptureFromBase64String(screenshotAs, testName+"_"+time);
		
		test.log(Status.INFO, result.getMethod().getMethodName()+"===Failed===");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("==="+result.getMethod().getMethodName()+" SKIPPED ===");
		test.log(Status.INFO, result.getMethod().getMethodName()+"===Skipped===");
	}
	
	
}
