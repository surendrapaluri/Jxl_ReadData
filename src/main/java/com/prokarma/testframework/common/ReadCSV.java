package com.prokarma.testframework.common;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadCSV {
 	static BufferedReader br = null;
	static String line = "";
	static String cvsSplitBy = ";";
	//private String inputFile;
	static Map<String, String> readColumns = new HashMap<String, String>();
	static Map<String, String> readRow = new HashMap<String, String>();
	static Map<String, Map<String, String>> readAllRows = new HashMap<String, Map<String, String>>();
	static List<Map<String, String>> allRowDataList = new ArrayList<Map<String, String>>();
	
	
	/*public void setInputFile() {
		this.inputFile = inputFile;
	}*/
  	
  	public Map<String, Map<String, String>> readCSVData(String csvFile) throws Exception {
  		
  		int iColumnCount=0;
  		//br = new BufferedReader(new FileReader(getClass().getClassLoader().getResourceAsStream(csvFile)));
  		FileReader file = new FileReader(csvFile);
		br = new BufferedReader(file);
		String[] header = br.readLine().split(cvsSplitBy);
		for(String i : header){readColumns.put("Column"+iColumnCount, header[iColumnCount]);iColumnCount++;	}
		
	    int rowCount = 0;
	    int columnNumber = 0;
	    while ((line = br.readLine()) != null) {
	    	String[] rowData = line.split(cvsSplitBy);
	    	
	    	columnNumber = 0;
	    	readRow= new HashMap<String, String>();
	    	for (String columnData : rowData) {
	    		readRow.put(readColumns.get("Column"+ columnNumber), columnData);
	    		columnNumber++;
			}
	    	readAllRows.put("Row" + rowCount, readRow);
	    	rowCount++;
	    }
		
		return readAllRows;
  	}

	@SuppressWarnings("unused")
	private static void getValue(String column, int rowNumber) {
		System.out.println(readAllRows.get("Row" + rowNumber).get(column));
	}

	  	  	
 }