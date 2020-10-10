package com.qa.darkSky.com_gamze.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;





import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	public static boolean highlightElement;

	public WebDriver init_driver(String browserName) {


	System.out.println("browser name: "+ browserName);
	if (browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}else if(browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	return driver;
	}
	
	public Properties init_properties() {
		prop=new Properties();
		String path="/Users/gamzebuyukeren/eclipse-workspace/darkSky.com_gamze/src/main/java/com/qa/"
				+ "darkSky/com_gamze/config/config.properties";
		
		try {
			FileInputStream ip = new FileInputStream(path);
		    prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("some issue occured with confic properties...");
		}catch(IOException e) {
			e.printStackTrace();
		}
		return prop;
	}


}