package Pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
	public static WebDriver OpenBrowser(String url) {//this method returns WebDriver which is driver.
	ChromeOptions options = new ChromeOptions();//class of selenium
	options.addArguments("--disable-notifications");//To disable notification
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\91877\\OneDrive\\Documents\\Automation\\Zerodha8Jan\\src\\main\\resources\\chromedriver.exe");
	WebDriver driver = new ChromeDriver(options);//pass the ChromOptions reference here
	driver.get(url);
	driver.manage().window().maximize();
	return driver;
}
	
	public void opeFirefox() {
		
	}
}
