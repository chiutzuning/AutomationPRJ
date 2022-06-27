package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class AddToCartPageTest extends BaseClass {
	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	
	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = { "Regression", "Sanity"})
	public void addToCartTest() throws Throwable {
		Log.startTestCase("addToCartTest");
		indexpage = new IndexPage();
		searchresultpage = indexpage.searchProduct("T-shirt");
		addtocartpage = searchresultpage.clickOnProduct();
		Thread.sleep(2000);
		addtocartpage.enterQauntity("1");
		addtocartpage.selectSize("S");
		addtocartpage.clickOnAddToCart();
		boolean result = addtocartpage.validateAddtoCart();
		AssertJUnit.assertTrue(result);
		Log.endTestCase("addToCartTest");
	}
	
}
