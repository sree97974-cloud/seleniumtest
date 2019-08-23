package co.sree.seleniumTestNG;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Login {
	
	public static   void Olb_login(WebDriver driver,  String username, String pwd, String environment, ExtentTest test, String path) throws IOException   {
		if (environment.equalsIgnoreCase("prod")){
			driver.get("https://www.bankofamerica.com/");
		}
		
		try {
		System.out.println(username);
		driver.findElement(By.xpath("//input[@name='onlineId1']")).sendKeys(username);
		System.out.println(pwd);
		
		driver.findElement(By.xpath("//input[@name='passcode1']")).sendKeys(pwd.trim());
		test.log(LogStatus.INFO, "User name and password entered" ,  test.addScreenCapture(ScreenshotCapture.captureScreenshot(driver, path)));
		driver.findElement(By.xpath("//button[@id='signIn']"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@id='signIn']")).click();
		}
		catch(Exception e) {
			
			
		try {
			test.log(LogStatus.FATAL, "Login Failed due to...." + e.getMessage().toString(), test.addScreenCapture(ScreenshotCapture.captureScreenshot(driver, path)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}

      if (driver.getTitle().contains("Accounts Overview")) {
    	 try {
			test.log(LogStatus.PASS, "Login sucessfull with the USERNAME .. " + username + "..PASSWORD ..." + pwd  , test.addScreenCapture(ScreenshotCapture.captureScreenshot(driver, path)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
      }
    	  
      else 
    	  test.log(LogStatus.FAIL,  "Login UnSuccessfull" , test.addScreenCapture(ScreenshotCapture.captureScreenshot(driver, path)));
    
	}

}
