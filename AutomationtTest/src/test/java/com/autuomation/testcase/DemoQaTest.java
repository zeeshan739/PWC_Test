package com.autuomation.testcase;

import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.base.DemoQaBase;
import com.automation.page.DemoQaAHome;

public class DemoQaTest extends DemoQaBase {
	
	DemoQaAHome homepage;
	
	public DemoQaTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();	
		
	}
	
	@Test
	public void verify() throws InterruptedException {
		Assert.assertEquals("ToolsQA", homepage.verifyPageTitle());
		homepage.provideDetails();
		Assert.assertEquals("Student Registration Form", homepage.provideDetails());
			
	}
	
	@AfterMethod
	public void closingBrowser() {
		driver.quit();
	}
	
	
	
	
	
}
