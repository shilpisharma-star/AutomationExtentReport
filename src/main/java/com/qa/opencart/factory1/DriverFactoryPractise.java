package com.qa.opencart.factory1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.errors.AppError;
import com.qa.opencart.exceptions.BrowserException;


public class DriverFactoryPractise {

	WebDriver driver;
	Properties prop;
	/**
	 * This method is used to initilize the driver on the basis of given browsername
	 * @param browserName
	 * @return driver
	 */
	
	public WebDriver initDriver(Properties prop)
	{
		String browserName=prop.getProperty("browser");
		
		System.out.println("browser name is "+ browserName);
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		default:
			System.out.println(AppError.BROWSER_ERROR+browserName);
		    throw new BrowserException("INVALID BROWSER"+browserName);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
		
	}
	public Properties initProp()
	{
		
		//prop=new Properties();
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;

	}
	

		
	}
	
	

