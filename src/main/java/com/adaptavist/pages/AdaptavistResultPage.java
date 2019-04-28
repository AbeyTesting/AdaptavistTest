package com.adaptavist.pages;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.adaptavist.extension.WebDriverExtensions;
import com.adaptavist.util.Base;

public class AdaptavistResultPage extends Base 
{
	// Global variable
	String clickonnewtab = Keys.chord(Keys.CONTROL,Keys.ENTER);
	
	// Page Objects
	@FindBy(how=How.XPATH, using="//a[contains(@href,'adaptavist')]")
	@CacheLookup
	List<WebElement> links;
	
	@FindBy(how=How.XPATH, using="//span[text()='Next']")
	@CacheLookup
	WebElement next;
	
	// Constructor
	public AdaptavistResultPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	// Method to perform specific task on the page
	public void navigateToEachLink() throws IOException 
	{
		WebDriverExtensions.wait(next); // To wait for the visibility of the element "Next"
		WebDriverExtensions.getScreenshots("Landing Page"); // To capture screenshot of the landing page
		System.out.println("Total no of adaptavist link on landing page is "+links.size());
		for(int i=0; i<links.size(); i++) 
		{
			WebElement ele = links.get(i);
			if(ele.isDisplayed()) 
			{
				ele.sendKeys(clickonnewtab); // Navigate to each link containing "Adaptavist"
			}
		}
	}
	
	public GoogleSearchPage navigateBack() 
	{
		driver.navigate().back();  // Navigate back to Google Search Page to start Scenario 2
		return new GoogleSearchPage();
	}
}
