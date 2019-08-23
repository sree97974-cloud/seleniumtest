package co.sree.seleniumTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserInitiation {
	
	public WebDriver browserInitiation(String browser ) {
	WebDriver driver = null;
		
		if (browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sreenath\\Desktop\\chromedriver.exe\\");
				driver = new ChromeDriver();
					}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sreenath\\Desktop\\chromedriver.exe\\");
			driver = new ChromeDriver();
		}
		return driver;
		
	}

}
