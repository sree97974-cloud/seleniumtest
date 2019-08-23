package co.sree.seleniumTestNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenshotCapture {
	
	public static String  captureScreenshot (WebDriver driver, String path) throws IOException {
		
		
		File f =	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path+"\\" + currentTimeStamp.gettime()+ "_screenshot.png");
		FileUtils.copyFile(f, dest);
		System.out.println(dest.getAbsolutePath());
		return dest.getAbsolutePath();
		
		
			
		 
		
	}

}
