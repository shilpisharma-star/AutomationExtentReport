package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.exceptions.FrameworkException;


public class ElementUtil {
	private WebDriver driver;
	private Actions act;
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
		act=new Actions(driver);
	}
	

	public WebElement getElement(By locator) 
	{
		
		return driver.findElement(locator);

	}
	
	public void doSendkeys(By locator, String value)
	{
		getElement(locator).sendKeys(value);
	}
	public void doSendkeys(WebElement element, String value)
	{
		element.clear();
		element.sendKeys(value);
	}
	
	public void doSendkeys1(By locator, CharSequence... value)
	{
		getElement(locator).sendKeys(value);
	}
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	
	//***********************************************Explicit wait
	
	
	
	public  void doSendKeys(By locator, int timeOut, String value)
	{
		waitForElementVisible(locator,timeOut).sendKeys(value);
	}
	public  void doClick(By locator, int timeOut)
	{
		waitForElementVisible(locator, timeOut).click();
	}
	
	public  WebElement waitForElementVisible(By locator, int timeOut)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		   return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public  WebElement waitForElementVisible(By locator, int timeOut, int interval)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut),Duration.ofSeconds(interval));
		   return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public  WebElement waitForElementPresence(By locator, int timeOut)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		   return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		 
	}
	
	
	public  void waitForElementAndClick(By locator, int timeOut)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	
	
	public  List<WebElement> waitForElementsVisible(By locator, int timeOut)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
	}
	
	
	
	//**********************************************************************************//
	
	
	public  String getPageTitleIs(String expectedTitle, int timeOut)
	{
		if(waitForTitleIs(expectedTitle, timeOut))
		{
			return driver.getTitle();
		}
		else {
			return "-1";
		}
	}
	
	
	
	
	
	public boolean waitForTitleIs(String expectedTitle, int timeOut)
	{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			boolean flag=false;
			try {
				return wait.until(ExpectedConditions.titleIs(expectedTitle));
				//flag=true;
				//return flag;
			}
			catch(TimeoutException e)
			{
				System.out.println("title does not match");
				return flag;
			}
			
	}
	
	
	
	public  String getPageTitleContains(String fractionTitle, int timeOut)
	{
		if(waitForTitleContains(fractionTitle, timeOut))
		{
			return driver.getTitle();
		}
		else {
			return "-1";
		}
	}
	
	
	
	public  boolean waitForTitleContains(String fractionTitle, int timeOut)
	{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			boolean flag=false;
			try {
				return wait.until(ExpectedConditions.titleContains(fractionTitle));
				//flag=true;
				//return flag;
			}
			catch(TimeoutException e)
			{
				System.out.println("title does not match");
				return flag;
			}
			
	}
	
	
	public  String getPageUrlContains(String fractionUrl, int timeOut)
	{
		if(waitForTitleContains(fractionUrl, timeOut))
		{
			return driver.getTitle();
		}
		else {
			return "-1";
		}
	}
	
	
	
	public  boolean waitForUrlContains(String fractionUrl, int timeOut)
	{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			boolean flag=false;
			try {
				return wait.until(ExpectedConditions.titleContains(fractionUrl));
				//flag=true;
				//return flag;
			}
			catch(TimeoutException e)
			{
				System.out.println("title does not match");
				return flag;
			}
			
	}
	
	
	public String waitForTitleContainsAndReturn(String fractionTitle, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.titleContains(fractionTitle));
			return driver.getTitle();
		} catch (TimeoutException e) {
			System.out.println("title is not matched");
			return "-1";
		}
	}
	
	
	public String waitForURLContainsAndReturn(String fractionURL, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.urlContains(fractionURL));// true
			return driver.getCurrentUrl();
		} catch (TimeoutException e) {
			System.out.println("URL is not matched");
			return "-1";
		}

	}
	



	
	//*****************************************************************
	public String dogetElementText(By locator)
	{
		String text=getElement(locator).getText();
		if(text!=null)
		{
			return text;
		}
		else
		{
			return null;
		}
	
	}
	public boolean doIsDisplayed(By locator)
	{
		try {
		return getElement(locator).isDisplayed();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No such element is displayed");
			return false;
		}
	}
//	public boolean IsDisabled(By locator)
//	{
//		try {
//		return getElement(locator).isDisplayed();
//		}
//		catch(NoSuchElementException e)
//		{
//			System.out.println("No such element is disable");
//			return false;
//		}
//	}
	public boolean IsDisabled(By locator)
	{
		return doIsDisplayed(locator);
	}
	public boolean isSelected(By locator)
	{
		doClick(locator);
		return getElement(locator).isSelected();
		//doClick(locator);
		
	
	}
	public  String DoGetAttribute(By locator, String attriValue)
	{
		return getElement(locator).getAttribute(attriValue);
	}
	
	
	
	public void PrintElementTextList(By locator)
	{
		 List<String>textList=getElementsTextList(locator);
		 for(String e: textList)
		 {
			 System.out.println(e);
		 }
		
	}
	
	
	public int getElementCount(By locator)
	{
		return getElements(locator).size();
	}
	
	
	
  
	public  List<WebElement> getElements(By locator)
   {
	   return driver.findElements(locator);
   }
   
  
	public  List<String> getElementsTextList(By locator)
   {
	   List<WebElement>eleTextList=getElements(locator);
	   List<String>TextList=new ArrayList<String>();
	   for(WebElement e: eleTextList)
	   {
		   String text =e.getText();
		   if(text.length()!=0)
		   {
			  TextList.add(text);
		   }
	   }
	   return TextList;
	   
   }
	 public boolean dosearch(By Searchfield, By suggestionlist,String searchkey ,String matchvalue) throws InterruptedException, FrameworkException 
	    {
			boolean flag = false;
			doSendkeys(Searchfield, searchkey);
			Thread.sleep(3000);
			List<WebElement> sugList = getElements(suggestionlist);

			int count = sugList.size();
			System.out.println(count);
			if (count == 0) {
				System.out.println("no suggestionlist found");
				throw new FrameworkException("No SUGGESTIONLIST FOUND");
			}

			for (WebElement e : sugList) {
				String Text = e.getText();
				System.out.println(Text);
				if (Text.contains(matchvalue)) {
					e.click();
					flag = true;
					break;

				}
			}
			if (flag) {
				System.out.println("Match value");
				return true;
			} else {
				System.out.println("not Match value");
				return false;
			}
		}
	 
	 
	 public boolean isElementPresent(By locator)
		{
			if (getElementCount(locator)==1) 
			{
	           return true;
			}
			else
				return false;
		}
		
	 public boolean isElementPresent(By locator, int expectedcount )
		{
			if (getElementCount(locator)==expectedcount) 
			{
	           return true;
			}
			else
				return false;
		}
	 public  boolean IsElementPresentMultipleTimes(By locator)
		{
			if (getElementCount(locator)>=1) 
			{
	           return true;
			}
			else
				return false;
		}
	 
	 public  boolean IsElementNotPresent(By locator)
		{
			if (getElementCount(locator)==0) 
			{
	           return true;
			}
			else
				return false;
		}
	 
	 
	// *********************Dropdown Method**********************************
	 
	 
	 private Select getSelect(By locator)

	 {
		 return new Select(getElement(locator)); 
	 }
	 
	 public  int getDropDownOptioncount(By locator)
		{
			
			return getSelect(locator).getOptions().size();
		}
		
		
		public  void SelectDropDownValueByVissibleText(By locator, String visibleText)
		{
			
			getSelect(locator).selectByVisibleText(visibleText);
		}
		public  void SelectDropDownValueByIndex(By locator, int index)
		{
			
			getSelect(locator).selectByIndex(index);
		}
		
		public  void SelectDropDownValueByValue(By locator, String value)
		{
			
			getSelect(locator).selectByValue(value);
		}
		
		public  List<String> DropDownOptionTextList(By locator)
		{
			
			List<WebElement> option=getSelect(locator).getOptions();
			List<String>arr=new ArrayList<String>();
			System.out.println(option.size());
			for(WebElement e: option)
			{
				String text=e.getText();
	            arr.add(text);
			}
			return arr;
		}
		
		public  void selectDropDownValueUsingSelect(By locator, String value)
		{
			
			List<WebElement> optionList=getSelect(locator).getOptions();
			selectDropDown(optionList, value);
			
			
		}
		
		
		
		
		
		public  void selectDropDownValue(By locator, String value)
		{
			List<WebElement>optionList=getElements(locator);
			selectDropDown(optionList, value);
		}
		
		
		private void selectDropDown(List<WebElement>optionList, String value)
		{
			System.out.println(optionList.size());
			for(WebElement e: optionList)
			{
				String text=e.getText();
				if(text.contains("value"))
				{
					e.click();
					break;
				}
			}
		}
		
		
		//ACTION CLASS#########################################################
		
		public  void parentChildMenu(By parentMenu, By childMenu) throws InterruptedException
		{
			
		    act.moveToElement(getElement(parentMenu)).perform();
		    Thread.sleep(3000);
		    doClick(childMenu);
		    
		}
		public  void parentChildMenu(String parentMenu, String childMenu) throws InterruptedException
		{
			
		    act.moveToElement(getElement(By.xpath("//div[text()='"+parentMenu+"']"))).perform();
		    Thread.sleep(3000);
		    getElement(By.xpath("//div[text()='"+childMenu+"']")).click();
		    
		}
		
		public void parentChildMenu(By level1, By level2, By level3, By level4) throws InterruptedException {
			doClick(level1);
			Thread.sleep(3000);

			act.moveToElement(getElement(level2)).perform();
			Thread.sleep(3000);
			act.moveToElement(getElement(level3)).perform();
			Thread.sleep(3000);
			doClick(level4);
	             
	                
		}
		public  void doActionsSendKeys(By locator, String value)
		{
			Actions act=new Actions(driver);
			act.sendKeys(getElement(locator), value).perform();
		}
		public  void doActionsClick(By locator)
		{
			Actions act=new Actions(driver);
			act.click(getElement(locator)).perform();
			
		}
		public  void doActionSendKeysWithPause(By locator, String value, long pauseTime)
		{
			Actions act=new Actions(driver);
			//String myname="shilpi sharma";
			char ch[]=value.toCharArray();
			for(char e: ch) {
			act.sendKeys(getElement(locator), String.valueOf(e)).pause(pauseTime).perform();
			}
		}
		
		
}
