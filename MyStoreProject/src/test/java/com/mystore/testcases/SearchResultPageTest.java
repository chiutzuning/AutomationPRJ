package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class SearchResultPageTest extends BaseClass {
	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	
	
	@Test(groups = "Smoke")
	public void productAvailabilityTest() throws Throwable {
		Log.startTestCase("productAvailabilityTest");
		indexpage = new IndexPage();
		searchresultpage = indexpage.searchProduct("T-shirt");
		boolean result = searchresultpage.isProductAvailable();
		AssertJUnit.assertTrue(result);
		Log.endTestCase("productAvailabilityTest");
	}

}
