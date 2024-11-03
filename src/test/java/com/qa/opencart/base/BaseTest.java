package com.qa.opencart.base;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;

import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.ResultPage;


public class BaseTest {

	WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected LoginPage loginpage;
	protected AccountPage accountpage;
	protected ResultPage resultpage;
	protected ProductInfoPage  productinfopage;
	protected RegisterPage registerlinkpage;
	@BeforeTest
	public void setup()
	{
		df= new DriverFactory();
		prop=df.initProp();
		driver=df.initDriver(prop);
		
		
		loginpage=new LoginPage(driver);
		//accountpage=new AccountPage(driver);
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
}
