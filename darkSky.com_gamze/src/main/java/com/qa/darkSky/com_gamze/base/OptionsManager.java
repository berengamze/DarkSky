package com.qa.darkSky.com_gamze.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	
	WebDriver driver;
	public ChromeOptions co;
	public FirefoxOptions fo;
	public Properties properties;
	
	
	public OptionsManager(Properties properties) {
		this.properties=properties;
		
	}
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if (properties.getProperty("incognito").equals("yes")) co.addArguments("--incognito"); //not working on firefox
		if(properties.getProperty("--headless").equals("yes")) co.addArguments("--headless");
		return co;	
	}
	
	public FirefoxOptions getFireFoxOptions() {
		fo = new FirefoxOptions();
		if(properties.getProperty("--headless").equals("yes")) co.addArguments("--headless");
		return fo;
	}
	
}
