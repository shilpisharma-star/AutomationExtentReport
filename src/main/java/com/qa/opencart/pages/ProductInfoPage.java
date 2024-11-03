package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	ElementUtil eutil;
	
    private By productHeader=By.tagName("h1");
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver=driver;
		eutil=new ElementUtil(driver);
	}
	public String getprodHeader()
	{
		String productheaderValue=eutil.waitForElementVisible(productHeader, AppConstants.DEFALUT_SHORT_TIME_OUT).getText();
		System.out.println(productheaderValue);
		
		//eutil.getElement(productHeader);
		return productheaderValue;
	}
}
