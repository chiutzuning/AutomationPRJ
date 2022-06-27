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
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;
import com.mystore.utility.Log;

public class EndtoEndTest extends BaseClass {
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	LoginPage loginpage;
	AddressPage addresspage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderSummary ordersummary;
	OrderConfirmationPage orderconfirmationpage;
	
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
	public void endToEndTest() throws Throwable {
		Log.startTestCase("endToEndTest");
		indexpage = new IndexPage();
		searchresultpage = indexpage.searchProduct("T-shirt");
		addtocartpage = searchresultpage.clickOnProduct();
		Thread.sleep(2000);
		addtocartpage.enterQauntity("1");
		addtocartpage.selectSize("S");
		addtocartpage.clickOnAddToCart();
		orderpage = addtocartpage.clickOnCheckOut();
		loginpage = orderpage.clickOnCheckOut();
		addresspage = loginpage.login("genie@gmail.com", "test1234");
		shippingpage = addresspage.clickOnCheckOut();
		shippingpage.checkTheTerms();
		paymentpage = shippingpage.clickOnProceedToCheckOut();
		ordersummary = paymentpage.clickOnPaymentMethod();
		orderconfirmationpage = ordersummary.clickOnconfirmOrderBtn();
		String message = orderconfirmationpage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		AssertJUnit.assertEquals(message, expectedMsg);
		Log.endTestCase("endToEndTest");
		
	}
	
}
