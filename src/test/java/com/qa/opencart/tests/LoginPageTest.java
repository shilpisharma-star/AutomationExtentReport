package com.qa.opencart.tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.LoginPage;

public class LoginPageTest extends BaseTest {

	
	@Test
	public void loginPageTitleTest()
	{
		
		
		String actTitle=loginpage.getLogibPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
		
	}
	@Test
	public void  loginPageUrlTest()
	{
		String actUrl=loginpage.getLoginPageUrl();
		 Assert.assertTrue(actUrl.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
		
	}
	@Test
	public void forgotPwdLinkExistTest()
	{
		 Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}
	@Test
	public void  LogoImageExistTest()
	{
		 Assert.assertTrue(loginpage.isLogoImageExist());
	}
	
	@Test(priority=Integer.MAX_VALUE)
	public void  doLoginTest()
	{
		accountpage=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("Password"));
		Assert.assertEquals(accountpage.getAccountPageTiltle(), AppConstants.ACCOUNT_PAGE_TITLE);
	}
}
