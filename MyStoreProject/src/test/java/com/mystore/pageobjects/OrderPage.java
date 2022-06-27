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
 * 1. validate the unit price in the order page 
 * 2. validate the total price in the order page
 * 2. link to the LoginPage 
 * 3. Link to Addresspage
 *
 */
public class OrderPage extends BaseClass {
  
	
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	private WebElement unitPrice;
	
	@FindBy(id="total_price")
	private WebElement totalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitprice() {
		String unitPrice1 = unitPrice.getText();
		//remove all the non-alphanumeric characters from the string and replaces it with an empty string.
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalprice() {
		String totalPrice1 = totalPrice.getText();
		//remove all the non-alphanumeric characters from the string and replaces it with an empty string.
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice = Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut() {
		Action.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
	}
}
