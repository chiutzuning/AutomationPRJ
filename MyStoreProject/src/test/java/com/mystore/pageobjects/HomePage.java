/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author genie
 * 1. validate my wish list should be displayed
 * 2. validate order history should be displayed
 *
 */
public class HomePage extends BaseClass {
	
	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateMyWishList() throws Throwable {
		return Action.isDisplayed(getDriver(), myWishList);
	}
	
	public boolean validateOrderHistory() throws Throwable {
		return Action.isDisplayed(getDriver(), orderHistory);
	}
	
	public String getCurrentURL() {
		String  homepageURL = getDriver().getCurrentUrl();
		return homepageURL;
	}
	
}
