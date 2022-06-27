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
 * 1. validate the "agree term" is clickable
 * 2. link to the paymentPage
 *
 */
public class ShippingPage extends BaseClass {
	@FindBy(id="cgv")
	private WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void checkTheTerms() throws Throwable {
		Action.click(getDriver(), terms);
	}
	
	public PaymentPage clickOnProceedToCheckOut() throws Throwable {
		Action.click(getDriver(), proceedToCheckOutBtn);
		return new PaymentPage();
	}
}