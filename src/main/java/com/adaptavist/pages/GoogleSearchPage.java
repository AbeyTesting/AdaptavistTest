package com.adaptavist.pages;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.adaptavist.util.Base;

public class GoogleSearchPage extends Base 
{
	// Page Objects
	@FindBy(how=How.NAME, using="q")
	@CacheLookup
	WebElement searchbox;
	
	@FindBy(how=How.XPATH, using="//input[@name='btnK']")
	@CacheLookup
	WebElement submitsearchbutton;
	
	// Constructor
	public GoogleSearchPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	// Methods to perform specific task on the page
	public void enterSearchWordAdaptavist() throws IOException 
	{
		props = new Properties();
    	FileInputStream fis = new FileInputStream("src\\main\\java\\com\\adaptavist\\config\\config.properties");
    	props.load(fis);
		searchbox.sendKeys(props.getProperty("searchword1"));
	}
	
	public void enterSearchWordAtlassian() throws IOException 
	{
		props = new Properties();
    	FileInputStream fis = new FileInputStream("src\\main\\java\\com\\adaptavist\\config\\config.properties");
    	props.load(fis);
		searchbox.sendKeys(props.getProperty("searchword2"));
	}
	
	public void clickOnSearchButton() 
	{
		submitsearchbutton.submit();
	}

}
