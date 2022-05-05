package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.jq.ResultsByClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Report;

import POM.SignupPage;
import POM.ZerodhaLogin;
import Pojo.Browser;
import Utility.Excel;
import Utility.Reports;

@Listeners(ListenerTest.class)
public class LoginTest extends BaseTest {

	ExtentReports reports;
	ExtentTest test;
	
	@BeforeClass
	public void setReports() {
		reports =Reports.addReport();
	}
	
	
	
	@BeforeMethod
	public void launchBrowser() {
	driver = Browser.OpenBrowser("https://kite.zerodha.com/");
	
	}
	
	@Test
	public void LoginWithValidCredentials() throws EncryptedDocumentException, IOException {
		test = reports.createTest("LoginWithValidCredentials");
		ZerodhaLogin zerodhalogin = new ZerodhaLogin(driver);
		String user =Excel.getTestData(0, 1, "Credentials");
		zerodhalogin.enterUserName(user);
		String pass =Excel.getTestData(1, 1, "Credentials");
		zerodhalogin.enterPassword(pass);
		zerodhalogin.clickOnSubmit();
		String pin = Excel.getTestData(2, 1, "Credentials");
		zerodhalogin.enterPin(pin, driver);
		zerodhalogin.clickOnContinue();
		Assert.assertTrue(false);
	
		
	}
	
	@Test
	public void signUpTest() {
		test = reports.createTest("signUpTest");
		ZerodhaLogin zerodhaLogin = new ZerodhaLogin(driver);
		zerodhaLogin.clickOnSignUp();
		zerodhaLogin.switchToSignUpPage(driver);
		SignupPage signUp =new SignupPage(driver);
		String actualTitle = signUp.getPageTitle(driver);
		String expectedTitle = "Signup and open a Zerodha trading and demat account online and start investing ";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTitle, expectedTitle);//hard assert will stop execution at this point
		softAssert.assertFalse(signUp.logoIsDisplayed());//
		signUp.enterMobileNumber("8770116906");
		//softAssert.assertAll();//shows all the captured failure
		//Assert.assertTrue(false);
	}
	
	@AfterMethod
	public void catureResult(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		} else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		}
		else {
			test.log(Status.SKIP,result.getName());
		}
	}
	
	
	@AfterClass
	public void flushResults() {
		reports.flush();
	}
	
	
	

	
	
}
