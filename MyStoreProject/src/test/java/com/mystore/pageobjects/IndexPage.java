package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInBtn;
    
    @FindBy(xpath="//img[@class='logo img-responsive']")
    private WebElement myStoreLogo;
    
	@FindBy(id="search_query_top")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	// click sign in button to connect to Login page
	public LoginPage clickOnSignIn() throws Throwable{
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {
		return Action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String myStoreTitle() {
		String myStoreTitle=getDriver().getTitle();
		return myStoreTitle;
	}
	
	public SearchResultPage searchProduct(String productname) {
		Action.type(searchProductBox, productname);
		Action.click(getDriver(), searchButton);
		return new SearchResultPage();
	}
	
} 
