package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingHomePage {
	WebDriver driver;
	public BingHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="sb_form_q")
	WebElement searchBox;
	
	@FindBy(css="search icon tooltip")
	WebElement searchButton;
	
	public void searchSomething(String searchPattern) {
		searchBox.sendKeys(searchPattern);
		searchButton.click();
	}
	
	
}
	

