package com.adaptavist.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.adaptavist.util.Base;

public class AtlassianResultPage extends Base 
{
	//Global variable
	String linktext;
	
	//Page Objects
	@FindBy(how=How.XPATH, using="//a[contains(@href,'atlassian')]")
	@CacheLookup
	List<WebElement> links;
	
	@FindBy(how=How.XPATH, using="//span[text()='Next']")
	@CacheLookup
	WebElement next;
	
	// Constructor
	public AtlassianResultPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	// Method to perform specific task
	public void verifyLinkResultDoNotContainAdaptavist() 
	{
		System.out.println("Total no of atlassian link on landing page is "+links.size());
		for(int i=0; i<links.size(); i++) 
		{
			WebElement ele = links.get(i);
			linktext = ele.getText();
			Assert.assertTrue(!linktext.contains("Adaptavist"));
		}
		System.out.println("Links result DO NOT contain reference to Adaptavist");
	}
	
}
