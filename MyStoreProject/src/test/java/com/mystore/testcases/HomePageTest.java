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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class HomePageTest extends BaseClass {
    
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	
	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void wishListTest() throws Throwable {
		Log.startTestCase("wishListTest");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateMyWishList();
		AssertJUnit.assertTrue(result);
		Log.endTestCase("wishListTest");
		
	}
	
	@Test(groups = "Smoke")
	public void orderHistoryandDetailsTest() throws Throwable {
		Log.startTestCase("orderHistoryandDetailsTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=homePage.validateOrderHistory();
		AssertJUnit.assertTrue(result);		
		Log.endTestCase("orderHistoryandDetailsTest");
	}
}
