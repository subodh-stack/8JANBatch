package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utility.ScreenShot;

public class ListenerTest extends BaseTest implements ITestListener {
    //public static WebDriver driver;
	public void onTestStart(ITestResult result) {
		System.out.println("Started "+ result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("My Test is successfull "+ result.getName());
	}
	
	
	public void onTestFailure (ITestResult result) {
		try {
			ScreenShot.takeScreenshot(driver, result.getName() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("My test skipped "+result.getName());
	}
	

	
}
