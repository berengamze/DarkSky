package com.qa.darkSky.com_gamze.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.darkSky.com_gamze.base.BasePage;
import com.qa.darkSky.com_gamze.pages.HomePage;
import com.qa.darkSky.com_gamze.utils.Constant;




public class TodaysTest {
	
	WebDriver driver;
	BasePage basePage;
	HomePage homePage;
    Properties properties;
	  
	 
    @BeforeTest
	public void setUp() throws InterruptedException {
		
		basePage=new BasePage();
		properties=basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(properties.getProperty("url"));
		homePage= new HomePage(driver);
		
		try {
			homePage.expandToday();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
    @Test
    public void testPageTitle() throws InterruptedException {
    	String title = homePage.getDarkSkyPageTitle();
    	System.out.println(title);
    	Assert.assertEquals(title, "");
    }
	
    @Test(priority=1)
	public void getTodayMaxMinTemp() throws InterruptedException{
		homePage.getMinTemp();
		homePage.getMaxTemp();
	
	}
	@Test(priority=2,description="verify if max temperature is displayed correctly")
	public void verifyMaxTemp(){
		int maxList=homePage.getMaxTemp();
		int maxDisplay=homePage.displayMaxTemp();
		Assert.assertEquals(maxList, maxDisplay);
	}
	@Test(priority=3,description="verify if  min tempretor is displayed correctly")
	public void verifyMinTemp(){
		int minList=homePage.getMinTemp();
		int minDisplay=homePage.displayMinTemp();
		Assert.assertEquals(minList, minDisplay);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
