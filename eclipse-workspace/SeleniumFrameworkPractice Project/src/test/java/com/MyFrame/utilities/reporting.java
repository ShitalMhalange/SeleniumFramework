package com.MyFrame.utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class reporting extends TestListenerAdapter
{
	public static ExtentHtmlReporter Extenthtml;
	public static ExtentReports extent; //specify location of report
	public  static ExtentTest logger; //what details should be populated in the report
	
	public  void onTestStart(ITestResult tr)
	{

		File fis_html=new File("C:\\Users\\AVINASH\\eclipse-workspace\\SeleniumFrameworkPractice Project\\ExtentReport.html");
		//extent=new ExtentReports(filePath)*/	
		Extenthtml= new ExtentHtmlReporter(fis_html);
		File fis_xml=new File("C:\\Users\\AVINASH\\eclipse-workspace\\SeleniumFrameworkPractice Project\\extent-config.xml");
		System.out.println("++shital++++");
		extent = new ExtentReports();
		extent.attachReporter(Extenthtml);
		System.out.println("####shital####");
		
	}
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		System.out.println("++shital+pass");
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		System.out.println("++shital+fail");
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
	}
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		System.out.println("++shital+skip");
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.INDIGO));
	}
	
	public void onFinish(ITestContext testContext)
	{
		//extent.endTest(testContext);
		extent.flush();
		System.out.println("####shital+endtest####");
	}
}
	/*public ExtentReports htmlReporter;
	public static ExtentReports report; //specify location of report
	public static ExtentTest test; //what details should be populated in the report
	
	public static void onTestStart()
	{
	report = new ExtentReports("C:\\Users\\AVINASH\\eclipse-workspace\\SeleniumFrameworkPractice Project\\ExtentReport.html");
	//report.loadConfig(null, "C:\\Users\\AVINASH\\eclipse-workspace\\SeleniumFrameworkPractice Project\\extent-config.xml");
	System.out.println("shital+++++++++++++");
	}

	public void onTest(ITestResult tr)
	{
	test = report.startTest("TC_Loginpage_001");
	test.log(LogStatus.PASS, "pass");
	test.log(LogStatus.FAIL, "Fail");
	}
	@AfterTest
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}*/

/*	@BeforeClass
public void startTest()
{
	
	extent=new ExtentReports("C:\\Users\\AVINASH\\eclipse-workspace\\MYFrame_work\\test-output\\myreport.html", true);
	extent.addSystemInfo("Host Name", "LocalHoat");
	extent.addSystemInfo("Environment", "QA");
	extent.addSystemInfo("user Name", ");
	extent.loadConfig(new File("C:\\Users\\AVINASH\\eclipse-workspace\\MYFrame_work\\extent-config.xml"));
	htmlReporter=new ExtentReports();
	test=new
}
	
@Test
public void demoReportPass()
{
	//test=extent.startTest("demoReportPass");
	Assert.assertTrue(true);
	test.log(LogStatus.PASS, "Assert pass as condition is true");
	
}
@Test
public void demoReportFail()
{
//	test=extent.startTest("demoReportFail");
	Assert.assertTrue(false);
	test.log(LogStatus.FAIL, "Assert pass as condition is false");
}
@AfterMethod
public void getResult(ITestResult result)
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		test.log(LogStatus.FAIL, result.getThrowable());
	}
//	extent.endTest(test);
}
@AfterTest
public void endreport()
{
//	extent.flush();
}*/

