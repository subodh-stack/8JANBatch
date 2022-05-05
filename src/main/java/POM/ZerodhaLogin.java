package POM;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaLogin {
	
		@FindBy(xpath = "//input[@id='userid']")private WebElement userName;
		//driver.findElement
		@FindBy(xpath="//input[@id='password']")private WebElement password;
		
		@FindBy(xpath = "//button[@type='submit']")private WebElement submit;
		
		@FindBy(xpath = "//input[@id='pin']") private WebElement pin;
		
		@FindBy(xpath = "//button[@type='submit']")private WebElement continueButton;
		
		@FindBy(xpath = "//a[text() ='Forgot user ID or password?']") private WebElement forgot;
		
		@FindBy(xpath = "//a[text()=\"Don't have an account? Signup now!\"]") private WebElement signUp;
		
		
		public ZerodhaLogin(WebDriver driver)
		{
			PageFactory.initElements(driver, this);//pagefactory.initelement will find all the elements declared at the start
		}

		public void enterUserName(String user) {
			userName.sendKeys(user);
		}
		
		public void enterPassword(String pass) {
			password.sendKeys(pass);
		}
		
		public void clickOnSubmit() {
			submit.click();
		}
		
		public void enterPin(String value,WebDriver driver ) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(3000));//Explicit wait
			wait.until(ExpectedConditions.visibilityOf(pin));
			pin.sendKeys(value);
		}
		
		public void clickOnContinue() {
			continueButton.click();
		}
		
		public void clickOnForgotButton() {
			forgot.click();
		}
		
		public void clickOnSignUp() {
			signUp.click();
		}
		
		public void switchToSignUpPage(WebDriver driver) {
			ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(list.get(1));
			SignupPage signUp = new SignupPage(driver);
		}
}
