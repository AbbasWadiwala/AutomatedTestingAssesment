package com.qa;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ManualTesting {
	
	public static WebDriver driver = null;
	public static int countInt = 1;
	public static int totalTestCountInt = 3;
	public static boolean replaceExistingBoolean = true;
	static ExtentReports extentReportRef;
	static ExtentTest extentTestRef;
	
	@BeforeClass
	public static void beforeClass() {
		// Initialise ExtentReports with a file path 
		extentReportRef = new ExtentReports(Constants.FilePath_TestReport + Constants.FileName_TestReport, replaceExistingBoolean);	
		
		
		for(int i = 1; i < ExcelUtils.getExcelWSheet().getPhysicalNumberOfRows(); i++) {
			 ExcelUtils.setCellData(Constants.Path_TestData+Constants.FileName_TestData, "Test Not Completed", i, 3);
			 ExcelUtils.setCellData(Constants.Path_TestData+Constants.FileName_TestData, "Test Not Completed", i, 4);
		}
		
	}
}
