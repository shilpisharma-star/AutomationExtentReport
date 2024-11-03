package com.qa.opencart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
 
public class RegisterPage {

   private  WebDriver driver;
     ElementUtil eutil;
	private  By firstname=By.id("input-firstname");
	private  By lastname=By.id("input-lastname");
	private  By email=By.id("input-email");
	private  By telephone=By.id("input-telephone");
	private  By password=By.id("input-password");
	private  By cpassword=By.id("input-confirm");
	private  By subscibeYes=By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private  By subscibeNo=By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");
	private By agreeCheckBox=By.name("agree");
	private By continueButton=By.xpath("//input[@type='submit' and  @value='Continue']");
	private By successText=By.xpath("//div[@id='content']/h1");
	private By logoutLink=By.linkText("Logout");
	private By registerLink=By.linkText("Register");
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		eutil=new ElementUtil(driver);
	}
   public void userRegistration(String firstname,String lastname ,String email ,String telephone, String password, String subscibe )
	{
		eutil.waitForElementVisible(this.firstname, AppConstants.DEFALUT_SHORT_TIME_OUT).sendKeys(firstname);
		eutil.doSendkeys(this.lastname, lastname);
		eutil.doSendkeys(this.lastname, lastname);
		eutil.doSendkeys(this.email, email);
		eutil.doSendkeys(this.telephone, telephone);
		eutil.doSendkeys(this.password, password);
		eutil.doSendkeys(cpassword, password);
	}
	
	
	
	
}


