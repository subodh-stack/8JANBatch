package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.ZerodhaLogin;
import Pojo.Browser;
import Utility.Excel;

public class HomePageTest  {
	

	WebDriver driver;
	
	
	@BeforeMethod
	public void launchBrowserAndLogin() throws EncryptedDocumentException, IOException {
		driver =Browser.OpenBrowser("https://kite.zerodha.com/");
		ZerodhaLogin zerodhalogin = new ZerodhaLogin(driver);
		String user =Excel.getTestData(0, 1, "Credentials");
		zerodhalogin.enterUserName(user);
		String pass =Excel.getTestData(1, 1, "Credentials");
		zerodhalogin.enterPassword(pass);
		zerodhalogin.clickOnSubmit();
		String pin = Excel.getTestData(2, 1, "Credentials");
		zerodhalogin.enterPin(pin, driver);
		zerodhalogin.clickOnContinue();
		
	}
	
	@Test()
	public void buyStock(){
		HomePage homepage =new HomePage(driver);
		homepage.selectStockFromList(driver,"ta");
		homepage.clickOnBuy();
		Assert.assertTrue(false);
	}
	
	

}
