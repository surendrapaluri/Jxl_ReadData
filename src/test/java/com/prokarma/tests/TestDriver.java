package com.prokarma.tests;

import java.io.IOException;
import java.util.Map;

import jxl.Sheet;

import org.junit.Test;

import com.prokarma.testframework.common.ReadExcel;
import com.prokarma.testframework.common.WebDriverFactory;
import com.prokarma.testframework.webapplication.LoginPage;

public class TestDriver {

	static WebDriverFactory driverFactory = new WebDriverFactory();
	static ReadExcel readData = new ReadExcel();
	static LoginPage wikiTest = new LoginPage();
	String path = "D:\\Workspace1\\webdriverTestFramework\\src\\test\\resources\\data\\TestData.xls";
	Map<String, Object> mp = readData.getInputFile("Sheet1", path);
	Sheet Data = (Sheet) mp.get("sheet");	
	int iRowNumber;
	
	@Test
	public void Driver() throws Exception {
		//String scenarioNum = mp.get("scenarioNum").toString();
		int iRowCount = Integer.parseInt(mp.get("rowCount").toString());
		iRowNumber = Integer.parseInt(mp.get("rowNum").toString());
		//TestSuite suite = new TestSuite();  
		//suite.addTest(TestSuite.createTest(TestDriver.class, "tests"));
		for (int i = iRowNumber; i <= iRowCount; i = iRowNumber + 1) {
			wikiTest.openBrowser(Data,iRowNumber);
			wikiTest.openWiki(Data, iRowNumber);
			wikiTest.loginWiki(Data, iRowNumber);
			wikiTest.logoutWiki();
			
			int sceNum = readData.fnGetScenarioNumberToExecute(Data, iRowNumber + 1);
			if(sceNum == 0 ) { 
				System.exit(0);}
			else {
				iRowNumber = readData.fnGetRowNumber(Data, Integer.toString(sceNum));
			}
		}
	}
	
	
}
