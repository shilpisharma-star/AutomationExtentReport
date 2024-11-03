package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;


public class AccountPageTest extends BaseTest {

	@BeforeClass
	
	public void AccountPageSetup()
	{
	  accountpage= loginpage.doLogin(prop.getProperty("username"), prop.getProperty("Password"));
	}
	
	
	@Test
	public void accountPageTiltleTest()
	{
		System.out.println("getAccountPageTiltleTest started");
		String acc_title=accountpage.getAccountPageTiltle();
		Assert.assertEquals(acc_title, AppConstants.ACCOUNT_PAGE_TITLE);
		System.out.println("getAccountPageTiltleTest ended");
	}
	@Test
	public void isLogoutLinkExistsTest()
	{
		System.out.println("isLogoutLinkExistsTest started");
		Assert.assertTrue(accountpage.isLogoutLinkExists());
		System.out.println("isLogoutLinkExistsTest ended");
	}
	
    @Test
     public void AccountpagHeaderTest()
     {
    	System.out.println("getAccountpagHeaderTest started");
    	List<String> AccPageHeaderList=accountpage.getAccountpagHeader();
    	Assert.assertEquals(AccPageHeaderList, AppConstants.EXPECTED_ACCOUNT_HEADER_LIST);
    	System.out.println("getAccountpagHeaderTest ended");
     }
    
    @Test
    
    public void accountPageHearderCountTest()
	{
    	System.out.println("accountPageHearderCountTest started");
    	int headercount=accountpage.accountPageHearderCount();
		Assert.assertEquals(headercount, AppConstants.ACCOUNT_PAGE_HEADER_COUNT);
		System.out.println("accountPageHearderCountTest ended");
	}
    
    @DataProvider
    public Object[][]getSearchKey( )
    {
    	return new Object[][]{
    			{"macbook",3},
    			{"samsung",2},
    			{"iMac",1}
    };
    }
    
    @Test(dataProvider ="getSearchKey" )
    public void searchCountTest(String searchkey ,int searchCount)
    {
    	System.out.println("searchCountTest started");
    	resultpage=accountpage.doSearch("macbook");
      Assert.assertEquals(resultpage.getResultsCount(),3);
      System.out.println("searchCountTest ended");
    }
    @DataProvider
    public Object[][]getSearchData()
    		{
    	       return new Object[][] {
    	    	   {"macbook","MacBook" },
    	    	   {"macbook","MacBook Pro"},
    	    	   {"macbook","MacBook Air"},
    	    	   {"samsung","Samsung SyncMaster 941BW"},
    	    	   {"samsung","Samsung Galaxy Tab 10.1"},
    	    	   {"iMac","iMac"},
    	       };
    		}
    
    @Test(dataProvider = "getSearchData")
    public void searchTest(String searchKey, String productName )
    {
    	System.out.println("doSearchTest started");
    	resultpage=accountpage.doSearch(searchKey);
    	productinfopage=resultpage.selectProduct(productName);
    	Assert.assertEquals(productinfopage.getprodHeader(), productName);
    	System.out.println("doSearchTest ended");
    }


}
