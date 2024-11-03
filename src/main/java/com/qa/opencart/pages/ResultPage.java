package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ResultPage {

	private WebDriver driver;
	ElementUtil eutil;
	
	private By searchHearder=By.cssSelector("div#content h1");
	private By result=By.xpath("//div[@class='product-thumb']");
	//private By product=By.linkText("MacBook");
	
	public ResultPage(WebDriver driver)
	{
		this.driver=driver;
		eutil=new ElementUtil(driver);
	}
	public String getSearchHeader()
	{
		String searchHeaderText=eutil.waitForElementVisible(searchHearder, AppConstants.DEFALUT_SHORT_TIME_OUT).getText();
		System.out.println(searchHeaderText);
		return searchHeaderText;
	}
	public int getResultsCount()
	{
		int resultcount=eutil.waitForElementsVisible(result, AppConstants.DEFALUT_MEDIUM_TIME_OUT).size();
		System.out.println(resultcount);
		return resultcount;
	}
	
	public ProductInfoPage selectProduct(String productName)
	{
		eutil.doClick(By.linkText(productName));
		
		return new ProductInfoPage(driver);
	}
	
}
