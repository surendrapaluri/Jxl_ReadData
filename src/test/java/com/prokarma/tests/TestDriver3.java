/*package com.prokarma.tests;

import org.testng.annotations.Test;
import java.util.Map;
import jxl.Sheet;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.prokarma.testframework.common.GetWebDriver;
import com.prokarma.testframework.common.ReadExcel;
import com.prokarma.testframework.webapplication.LoginPage;

@Listeners({ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class TestDriver3 {
	
	{System.setProperty("atu.reporter.config", "D:\\Workspace1\\webdriverTestFramework\\src\\main\\resources\\reports\\atu.properties");}
	
	static GetWebDriver driver = new GetWebDriver();
	static ReadExcel readData = new ReadExcel();
	static LoginPage wikiTest = new LoginPage();
	
	
	String path = "D:\\Workspace1\\webdriverTestFramework\\src\\test\\resources\\data\\TestData.xls";
	Map<String, Object> mp = readData.getInputFile("Sheet1", path);
	Sheet Data = (Sheet) mp.get("sheet");	
	
	
	@Test
	public void TestDriver() throws Exception {
		//String scenarioNum = mp.get("scenarioNum").toString();
		int iRowCount = Integer.parseInt(mp.get("rowCount").toString());
		int iRowNumber = Integer.parseInt(mp.get("rowNum").toString());
		//TestSuite suite = new TestSuite();  
		//suite.addTest(TestSuite.createTest(TestDriver.class, "tests"));
		ATUReports.setWebDriver((WebDriver) driver);
		ATUReports.indexPageDescription = "My Project Description";
		ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
		ATUReports.add("INfo Step", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		ATUReports.add("Fail step", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		
		
			test1();
			test2();
			test3();
		
	}
	
	
	 
	
		
	@Test
	public void test(int iRowNumber) 
	{
		wikiTest.openBrowser(Data,iRowNumber);
		wikiTest.openWiki(Data, iRowNumber);
		wikiTest.loginWiki(Data, iRowNumber);
		wikiTest.logoutWiki();
	}
		
	@Test
	public void test1(){test(1);}
	
	@Test
	public void test2(){test(2);}
	
	@Test
	public void test3(){test(3);}
}
*/