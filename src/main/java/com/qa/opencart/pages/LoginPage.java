package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;


public class LoginPage {
	
	private WebDriver driver;

    private ElementUtil eleUtil;
	private By firstname=By.id("input-email");
	private By password=By.id("input-password");
	private By loginBtn=By.xpath("//input[@class='btn btn-primary']");
	private By forgotpwdLink=By.linkText("Forgotten Password");
	private By logoImage=By.cssSelector("img.img-responsive");
	private By registerLink=By.linkText("Register");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	     eleUtil=new ElementUtil(driver);
	}
	
	
	public String getLogibPageTitle()
	{
		String title=eleUtil.waitForTitleContainsAndReturn(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFALUT_SHORT_TIME_OUT);
		
		
		System.out.println("Login page title is "+title);
		return title;
	}
	
	public String getLoginPageUrl()
	{
		String url= eleUtil.waitForURLContainsAndReturn(AppConstants.LOGIN_PAGE_FRACTION_URL, AppConstants.DEFALUT_SHORT_TIME_OUT);
		
	
	     System.out.println("Login page url is :" + url);
	     return url;
	}
	public boolean isForgotPwdLinkExist()
	{
		return eleUtil.doIsDisplayed(forgotpwdLink);
		
	}
	
	public boolean isLogoImageExist()
	{
		return eleUtil.doIsDisplayed(logoImage);
	}
	
	public AccountPage doLogin(String userName, String pwd)
	{
		eleUtil.waitForElementVisible(firstname, AppConstants.DEFALUT_MEDIUM_TIME_OUT).sendKeys(userName);
		
		eleUtil.doSendkeys(password, pwd);
		eleUtil.doClick(loginBtn);
		
		//String title=eleUtil.waitForTitleContainsAndReturn(AppConstants.ACCOUNT_PAGE_TITLE, AppConstants.DEFALUT_SHORT_TIME_OUT);
		//System.out.println(title);
		//return title;
		return new AccountPage(driver);
		
	}
	public RegisterPage navigateToRegisterPage()
	{
		eleUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}
	
	
	
}
