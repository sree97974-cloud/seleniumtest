package co.sree.seleniumTestNG;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.TimeZone;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class EMT_Transfer_Test {
	static WebDriver driver;
	static ExtentReports  reporter;
	static ExtentTest test;
	String resultpath;
	
	@BeforeMethod
	  public void beforeMethod() throws InterruptedException, IOException {
		
		resultpath = new File("test-output\\" + this.getClass().getSimpleName() + "_" + "Test Result.." + currentTimeStamp.gettime()).getAbsolutePath();
		System.out.println(resultpath);
		if ( !new File(resultpath).exists())
			
			new File(resultpath).mkdir();
		
		 BrowserInitiation initiation = new BrowserInitiation();
		  driver = initiation.browserInitiation("chrome");
		  
		  reporter = new ExtentReports(resultpath + "\\" +this.getClass().getSimpleName() + currentTimeStamp.gettime()+".html", true);
		  System.out.println(new File (resultpath +"\\" + this.getClass().getSimpleName() + currentTimeStamp.gettime()+".html").getAbsolutePath());
		  test = reporter.startTest(this.getClass().getSimpleName() + "..Test Result _" + java.time.LocalDateTime.now()  );
        Login.Olb_login(driver, "sreenath_n01", "sailu@143", "prod",test, resultpath);
	  }
  @Test
  public void EMTTransfer() throws IOException {
	   if(driver.getTitle().equalsIgnoreCase("Bank of America | Online Banking | Accouts Overview"))
	  
test.log(LogStatus.PASS, "Accounts Overview" , "Test Step Pass");
	   else 
		   
		   test.log(LogStatus.FAIL, "Accounts Overview",driver.getTitle() + "..is not matching with the expected title value ....'Bank of America | Online Banking | Accouts Overview'");
	       
	System.out.println("user.dir");
  }
  

  @AfterMethod
  public void afterMethod() {
	  reporter.endTest(test);
	  reporter.flush();
	  reporter.close();
	  //driver.close();
	 // driver.quit();
  }

}
