package com.qa.opencart.constants;

import java.util.List;

public class AppConstants {

	
	public static final int DEFALUT_SHORT_TIME_OUT = 5;
	public static final int DEFALUT_MEDIUM_TIME_OUT = 10;
	public static final int DEFALUT_LONG_TIME_OUT = 20;
	public static final String LOGIN_PAGE_TITLE = "Account Login1";
	public static final String LOGIN_PAGE_FRACTION_URL = "route=account/login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final List<String> EXPECTED_ACCOUNT_HEADER_LIST=List.of("My Account","My Orders","My Affiliate Account","Newsletter");
	
	public static final int ACCOUNT_PAGE_HEADER_COUNT = 4;
}
