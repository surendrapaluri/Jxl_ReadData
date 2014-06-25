package com.prokarma.testframework.common;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {
	private String inputFile;
	
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public Map<String,Object> getInputFile(String sheetname, String path) {
		Map<String,Object> mp = new HashMap<String,Object>();

		try {
			ReadExcel test = new ReadExcel();
			test.setInputFile(path);
			mp = test.readData(sheetname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mp;
	}
   
	public Map<String,Object> readData(String sheetname) throws IOException  {
		File inputWorkbook = new File(inputFile);
		Workbook w;
		Map<String,Object> mp = new HashMap<String,Object>();
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet dataSheet = w.getSheet(sheetname);
			ReadExcel fnGetScenarioNumber = new ReadExcel();
			int iScenarioNum = fnGetScenarioNumber.fnGetScenarioNumberToExecute (dataSheet, 1);
			//System.out.println("secnario Number is: " + iScenarioNum);
						
			//playWithExecl GetRowNumber = new playWithExecl();
			int iRowNum = fnGetScenarioNumber.fnGetRowNumber (dataSheet,Integer.toString(iScenarioNum));
			int iRowCount = dataSheet.getRows();
			
			mp.put("sheet", dataSheet);
			mp.put("rowNum", iRowNum);
			mp.put("rowCount", iRowCount);
			mp.put("scenarioNum", Integer.toString(iScenarioNum));

		} catch (BiffException e) {
			e.printStackTrace();
		}
		return mp;
	}
  
   
	public String fnGetFieldValue (Sheet data,String sFieldName,int iRowNumber) {
		//System.out.println(" sFieldName:"+sFieldName +" iRowNumber:"+iRowNumber);
		int iColumnNum = data.findCell(sFieldName).getColumn();
		String sFieldVal = data.getCell(iColumnNum, iRowNumber).getContents();
		return sFieldVal;
	}

	public int fnGetScenarioNumberToExecute(Sheet dataSheet, int iRowFrom){
		int iScenarioNumber = 0;
		int iColumnNum = dataSheet.findLabelCell("Execute?").getColumn();
		for (int i = iRowFrom; i < dataSheet.getRows(); i++) {
			Cell cellData = dataSheet.getCell(iColumnNum, i);
			if (cellData.getContents().equalsIgnoreCase("Yes")) {
				iScenarioNumber = cellData.getRow();
				break;
			}
		}
		return iScenarioNumber;
	}


	public int fnGetRowNumber(Sheet dataSheet, String sScenarioNum){
		int iRowNumber;
		int iColumnNum = dataSheet.findCell("Scenario Number").getColumn();
		Cell rowCell = dataSheet.findCell(sScenarioNum);
		//Cell rowCell1 = dataSheet.findCell(sScenarioNum,iColumnNum,1,iColumnNum,dataSheet.getRows(),true);
		//Cell rowCell = dataSheet.findCell(sScenarioNum,iColumnNum,1,iColumnNum,dataSheet.getRows(),false);
		
		//System.out.println("Row Number: " + rowCell.getRow());
		//System.out.println("I got a label " + rowCell1.getRow());
		iRowNumber = rowCell.getRow();
		return iRowNumber;
	}

	public void readDataInClientDetails(Sheet sheet, int iRowNum){
		String[] fieldsNames = null;
		String[][] fieldsData = null;
		for (int iColumnNum = 0; iColumnNum < sheet.getColumns(); iColumnNum++) {
			Cell headercell = sheet.getCell(iColumnNum, 0);
			String sheaderName = headercell.getContents();
			fieldsNames[iColumnNum] = sheaderName;
			Cell datacell = sheet.getCell(iColumnNum, iRowNum);
			fieldsData[iRowNum][iColumnNum] = datacell.getContents();
		}
	}



	public void readDataInSheet(Sheet sheet){
		for (int i = 0; i < sheet.getRows(); i++) {
		System.out.println("Row count " + (sheet.getRows() - i));
		for (int iHeaderLoop = 0; iHeaderLoop < sheet.getColumns(); iHeaderLoop++) {
			Cell headercell = sheet.getCell(iHeaderLoop, 0);
			String sheaderName = headercell.getContents();
			int iColumnNum = sheet.findCell(sheaderName).getColumn();
			//int iColumnNum = headercell.getColumn();
			Cell datacell = sheet.getCell(iColumnNum, i);
			//CellType type = datacell.getType();
			System.out.println("I got a label " + datacell.getContents());
			}
		}
	}

   
}