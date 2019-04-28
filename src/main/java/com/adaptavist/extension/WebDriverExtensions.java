package com.adaptavist.extension;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.adaptavist.util.Base;

public class WebDriverExtensions extends Base 
{

	public static void wait(WebElement ele) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	public static void getScreenshots(String screenshotname) throws IOException
    {
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(src, new File("./Screenshots/"+screenshotname+".png"));
    }
	

}
