package com.adaptavist.runner;
import java.io.IOException;
import org.testng.annotations.Test;
import com.adaptavist.pages.GoogleSearchPage;
import com.adaptavist.pages.AdaptavistResultPage;
import com.adaptavist.pages.AtlassianResultPage;
import com.adaptavist.util.Base;

public class TestRunner extends Base 
{
	Base bs = new Base();
	GoogleSearchPage gsp;
	AdaptavistResultPage arp;
	AtlassianResultPage atrp;
	
	@Test
	public void test() throws IOException 
	{
		System.out.println("Scenario 1 begins");
		bs.startBrowser(); // Method to start the browser
		gsp = new GoogleSearchPage();
		gsp.enterSearchWordAdaptavist();// Method to enter search word "Adaptavist"
		gsp.clickOnSearchButton(); // Method click on search submit button
		arp = new AdaptavistResultPage();
		arp.navigateToEachLink(); // Method to navigate to each link and capture capture screenshot
		System.out.println("Scenario 1 completed");
		
		
		// SCENARIO 2 (TWO) LINES OF CODE BELOW
		arp.navigateBack(); // Navigate back to Google Search Page to start Scenario 2
		System.out.println("Scenario 2 begins");
		gsp = new GoogleSearchPage();
		gsp.enterSearchWordAtlassian(); // Method to enter search word "Atlassian"
		gsp.clickOnSearchButton(); // Method click on search submit button
		atrp = new AtlassianResultPage();
		atrp.verifyLinkResultDoNotContainAdaptavist(); // Method verify links result contain no reference to Adaptavist
		System.out.println("Scenario 2 completed");
		bs.tearDown(); // Method to close and quit the browser
	}
}
