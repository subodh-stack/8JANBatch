package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
public static ExtentReports addReport() {
	ExtentSparkReporter htmlReport = new ExtentSparkReporter("extentReporter.html");
	ExtentReports reports = new ExtentReports();
	reports.attachReporter(htmlReport);
	reports.setSystemInfo("Env", "UAT");
	reports.setSystemInfo("TestingType", "Regression");
	return reports;
}
}
