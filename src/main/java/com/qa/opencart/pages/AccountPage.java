package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountPage {

	
	private WebDriver driver;
	private ElementUtil  util;
	private By logOutLink=By.linkText("Logout");
	private By headers=By.xpath("//div[@id='content']/h2");
	private By search=By.xpath("//input[@name='search']");
	private By searchIcon=By.xpath("//span[@class='input-group-btn']//button");
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		util=new ElementUtil(driver);
		
	}
	public String getAccountPageTiltle()
	{
	      String title=util.waitForTitleContainsAndReturn(AppConstants.ACCOUNT_PAGE_TITLE, AppConstants.DEFALUT_SHORT_TIME_OUT);
	      System.out.println(title);
	      return title;
	}
	public boolean isLogoutLinkExists()
	{
		return util.doIsDisplayed(logOutLink);
	}
	public List<String> getAccountpagHeader()
	{
		List<WebElement> headersList=util.waitForElementsVisible(headers, AppConstants.DEFALUT_MEDIUM_TIME_OUT);
		List<String> headersValueList=new ArrayList<String>();
		for(WebElement e:headersList)
		{
		      String text=e.getText();
		      System.out.println(text);
		      headersValueList.add(text);
		}
		return headersValueList;
	}
	
	
	public int accountPageHearderCount()																	
	{
		return util.waitForElementsVisible(headers, AppConstants.DEFALUT_SHORT_TIME_OUT).size();
	}
	
	public ResultPage doSearch(String searchkey)
	{
		WebElement searchele=util.waitForElementVisible(search, AppConstants.DEFALUT_SHORT_TIME_OUT);
		System.out.println(searchele);
		//searchele.clear();
		util.doSendkeys(searchele, searchkey);
		//searchele.sendKeys(searchkey);
		util.doClick(searchIcon);
		return new ResultPage(driver);
   
	}
	
	
}
