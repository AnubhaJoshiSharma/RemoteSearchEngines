package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
	WebDriver driver;
	public GoogleHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="APjFqb")
	WebElement searchBox;
	
//	@FindBy(xpath="//input[@id='gbqfbb']//preceding-sibling::input")
//	WebElement searchButton;
	
	public void searchSomething(String searchPattern) {
		searchBox.sendKeys(searchPattern);
	//	searchButton.click();
	}
	
	
}
	

