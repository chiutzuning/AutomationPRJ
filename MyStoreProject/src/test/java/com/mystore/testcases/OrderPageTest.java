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
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class OrderPageTest extends BaseClass{
	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser); 
	}
	

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Regression")
	public void verifyTotalPrice() throws Throwable {
		Log.startTestCase("verifyTotalPrice");
		indexpage = new IndexPage();
		searchresultpage = indexpage.searchProduct("T-shirt");
		addtocartpage = searchresultpage.clickOnProduct();
		addtocartpage.enterQauntity("2");
		addtocartpage.selectSize("S");
		addtocartpage.clickOnAddToCart();
		orderpage = addtocartpage.clickOnCheckOut();
		double unit = orderpage.getUnitprice();
		double total = orderpage.getTotalprice();
		int shippingFee = 2;
		double totalExp = (unit*2)+shippingFee;
		AssertJUnit.assertEquals(total, totalExp);
		Log.endTestCase("verifyTotalPrice");
	}
}
