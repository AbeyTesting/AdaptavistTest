package com.adaptavist.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base 
{
	// Global Variables
	public static WebDriver driver;
	public Properties props;
		
	// Method to start the browser
	public WebDriver startBrowser() throws IOException
    {
    	props = new Properties();
    	FileInputStream fis = new FileInputStream("src\\main\\java\\com\\adaptavist\\config\\config.properties");
    	props.load(fis);
    	String browsername = props.getProperty("browser");
    	String url = props.getProperty("url");
        if(browsername.equalsIgnoreCase("chrome")) 
        {
        	System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
        	driver = new ChromeDriver();
        }
        else if(browsername.equalsIgnoreCase("firefox")) 
        {
        	System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM\\geckodriver.exe");
        	driver = new FirefoxDriver();
        }
        
        else if(browsername.equalsIgnoreCase("ie")) 
        {
        	System.setProperty("webdriver.ie.driver", "C:\\SELENIUM\\MicrosoftWebDriver.exe");
        	driver = new InternetExplorerDriver();
        }	
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }
	
    // Method to quit the browser 
    public void tearDown() 
    {
    	driver.close();
    	driver.quit();
    }
    
}

