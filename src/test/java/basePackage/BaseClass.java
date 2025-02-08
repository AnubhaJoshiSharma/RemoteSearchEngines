package basePackage;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pageFactory.BingHomePage;
import pageFactory.GoogleHomePage;

public class BaseClass {
 private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
 //String baseUrl1 = "https://www.google.com";--->Sending these from Maven 
 //String baseUrl2="https://www.bing.com";---->Sending from Maven
 protected GoogleHomePage google;
 protected BingHomePage bing;
	public static WebDriver getDriver() {
		return driver.get();	
	}
	@Parameters({"browser","appUrl"})
	@BeforeMethod
	public void setUp(String browserName,String appUrl) {
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--headless");
			opt.setExperimentalOption("excludeSwitches",Arrays.asList("enable-automation"));
			opt.addArguments("--disableGpu");
			driver.set(new ChromeDriver(opt));
			System.out.println(Thread.currentThread().getId());
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions opt = new FirefoxOptions();
			opt.addArguments("--headless");
			//opt.setExperimentalOption("excludeSwitches",Arrays.asList("enable-automation"));
			opt.addArguments("--disableGpu");
			driver.set(new FirefoxDriver(opt));
			System.out.println(Thread.currentThread().getId());

		}
		else {
			System.out.println("Invalid Browser type provided. Exiting");
			System.exit(0);
		}
		getDriver().get(appUrl);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		google = new GoogleHomePage(getDriver());		
	}
	
	@AfterMethod
	public void cleanUp() {
		if(getDriver()!=null) {
		getDriver().quit();
		driver.remove();
		}
	}

}
