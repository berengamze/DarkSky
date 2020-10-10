package com.qa.darkSky.com_gamze.pages;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.darkSky.com_gamze.base.BasePage;
import com.qa.darkSky.com_gamze.utils.ElementUtil;
import com.qa.darkSky.com_gamze.utils.JavaScriptUtil;

public class HomePage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	
	private By today = By.xpath("//span[contains(text(),'Today')]");
    private By minTemp = By.className("minTemp");
    private By maxTemp = By.className("maxTemp");
    By todayBtn = By.xpath("//span[contains(.,'Today') and @class='name']");
	By temp = By.xpath("//div[2]/div[2]/div/div/div[4]/span");
    //By temp = By.className("temps");
	By minDisplay = By.xpath("//*[@id='week']/a[2]/span[2]/span[1]");
	By maxDisplay = By.xpath("//*[@id='week']/a[2]/span[2]/span[3]");
	By hours=By.xpath("//div//span [contains(@class,'am') or contains(@class,'pm')]");
	By temps=By.cssSelector("span[style^=opacity]");

    
    public HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	
	}
    
    
    public String getDarkSkyPageTitle() throws InterruptedException {
        Thread.sleep(1000);
        return elementUtil.doGetPageTitle();
    }

    public void expandToday() throws InterruptedException {
    	
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		elementUtil.doClick(today);
    }
    public ArrayList<Integer> getTempList() {
		List<WebElement> tempList = driver.findElements(temp);
		ArrayList<Integer> tempListInt = new ArrayList<Integer>();

		for (int i = 0; i < tempList.size(); i++) {
			String TempText = tempList.get(i).getText();
			tempListInt.add(Integer.parseInt(TempText.replaceAll("[^\\d.]", "")));
		}
		return tempListInt;
	}



	public int displayMinTemp() {
		List<WebElement> tempList = driver.findElements(temp);
		ArrayList<Integer> tempInt = new ArrayList<Integer>();

		for (int i = 0; i < tempList.size(); i++) {
			String tempText = tempList.get(i).getText();
			tempInt.add(Integer.parseInt(tempText.replaceAll("[^\\d.]", "")));

		}
		Collections.sort(tempInt);
		return tempInt.get(0);

	}

	public int displayMaxTemp() {
		List<WebElement> tempList = driver.findElements(temp);
		ArrayList<Integer> tempInt = new ArrayList<Integer>();

		for (int i = 0; i < tempList.size(); i++) {
			String TempText = tempList.get(i).getText();
			tempInt.add(Integer.parseInt(TempText.replaceAll("[^\\d.]", "")));

		}
		Collections.sort(tempInt);
		return tempInt.get(tempInt.size() - 1);
	}
	public int getMaxTemp(){
		
	List<WebElement> tempList=driver.findElements(temp);
	ArrayList<Integer> tempInt=new ArrayList<Integer>();
	WebElement maxTempElement = null;
	int maxTemp=-100;
	
	for (int i = 0; i < tempList.size(); i++) {
		String TempText=tempList.get(i).getText();
		tempInt.add(Integer.parseInt(TempText.replaceAll("[^\\d.]", "")));
		
			if (tempInt.get(i)>maxTemp) {
				maxTemp=tempInt.get(i);
				  maxTempElement=tempList.get(i);
		}
	}
	String text=maxTempElement.getText();
	int maxT=(Integer.parseInt(text.replaceAll("[^\\d.]", "")));
	return maxT;
	}

public int getMinTemp(){
	List<WebElement> tempList=driver.findElements(temp);
	ArrayList<Integer> tempInt=new ArrayList<Integer>();
	WebElement minTempElement = null;
	
	int minTemp=200;
	for (int i = 0; i < tempList.size(); i++) {
		String TempText=tempList.get(i).getText();
		tempInt.add(Integer.parseInt(TempText.replaceAll("[^\\d.]", "")));
		
			if (tempInt.get(i)<minTemp) {
				minTemp=tempInt.get(i);
				  minTempElement=tempList.get(i);
		}
	}
	String text=	minTempElement.getText();
	int minT=(Integer.parseInt(text.replaceAll("[^\\d.]", "")));
	return minT;
	}

 
}