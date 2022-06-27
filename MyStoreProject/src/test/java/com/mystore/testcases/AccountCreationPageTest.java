/**
 * 
 */
package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author genie
 *
 */
public class AccountCreationPageTest extends BaseClass {
	
	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountcreationpage;
	HomePage homepage;
	
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser); 
	}
	

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Sanity")
	public void creationAccount() throws Throwable {
		Log.startTestCase("createAccountTest");
		indexpage = new IndexPage();
		loginpage = indexpage.clickOnSignIn();
		accountcreationpage = loginpage.createNewAccount("ge123456@email.com");
		accountcreationpage.creationAccount("mr", 
				"Genie",
				"Chiu", 
				"test1234",
				"12",
				"2", 
				"1994", 
				"NC Company", 
				"Toorospstraat 18", 
				"Einhoven", 
				"Alabama", 
				"35462", 
				"United States", 
				"123456778");
		homepage = accountcreationpage.validateRegistration();
		AssertJUnit.assertEquals("http://automationpractice.com/index.php?controller=my-account", homepage.getCurrentURL());
		Log.endTestCase("createAccountTest");
	}

}
