package POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	Actions action;
	
	@FindBy(xpath="//span[text()='TATACOFFEE']")private WebElement tataCoffee;
	@FindBy(xpath = "//button[@class='button-blue buy']") private WebElement buy;
	@FindBy(xpath="//div[@class='vddl-list list-flat']//span//span//span[@class='nice-name']")private List<WebElement> stocks;
	
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void selectTataCoffee(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(tataCoffee));
		action = new Actions(driver);
		action.moveToElement(tataCoffee);
		action.perform();
	}
	
	public void selectStockFromList(WebDriver driver,String stockName) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(tataCoffee));
		for (int a =0;a<stocks.size();a++) {
			System.out.println(stocks.size());
			String text =stocks.get(a).getText();
			if(text.equalsIgnoreCase(stockName)) {
				action = new Actions(driver);
				action.moveToElement(stocks.get(a));
				action.perform();
			}
		}
	}
	
	public void clickOnBuy() {
		buy.click();
	}
}
