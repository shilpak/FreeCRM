package com.qa.ExtentReportListener;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentRepo implements IReporter{

	 
	 static ExtentReports report;
	 static ExtentTest logger;
	 
	 public void Testreport () {
	 
	   String path="C:\\Users\\Shilpa\\Desktop\\freecrmextentreport\\CRMTest.html";
	  
	  
	  report=new ExtentReports(path);
	  
	  logger =report.startTest("Free CRM test");
	  
	  logger.log(LogStatus.PASS, "Firefox Browser Launched");
	  report.endTest(logger);
	  report.flush();
	 }

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		
	}

	
}