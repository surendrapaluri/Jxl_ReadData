package com.prokarma.tests;

import java.util.Map;
import jxl.Sheet;
import org.junit.Test;
import com.prokarma.testframework.common.ReadExcel;

public class TestDriver2 {

	
	static ReadExcel readData = new ReadExcel();
	String path = "D:\\Workspace1\\webdriverTestFramework\\src\\test\\resources\\data\\TestData.xls";
	Map<String, Object> mp = readData.getInputFile("Sheet1", path);
	Sheet Data = (Sheet) mp.get("sheet");	
	int iRowNumber;
	
	@Test
	public void Driver() throws Exception {
		int iRowCount = Integer.parseInt(mp.get("rowCount").toString());
		iRowNumber = Integer.parseInt(mp.get("rowNum").toString());
		for (int i = iRowNumber; i <= iRowCount; i = iRowNumber + 1) {
			
			System.out.println(iRowNumber +" User Name: "+  readData.fnGetFieldValue(Data, "Username", iRowNumber));
			System.out.println(iRowNumber +" Password: "+  readData.fnGetFieldValue(Data, "Password", iRowNumber));
			System.out.println(iRowNumber+" url: "+  readData.fnGetFieldValue(Data, "URL", iRowNumber));
			System.out.println(iRowNumber+"Browser Name : "+  readData.fnGetFieldValue(Data, "Browser Name", iRowNumber));
			
			
			int sceNum = readData.fnGetScenarioNumberToExecute(Data, iRowNumber + 1);
			if(sceNum == 0 ) { System.exit(0);}
			else {iRowNumber = readData.fnGetRowNumber(Data, Integer.toString(sceNum));}
		}
	}
	
	
}
