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
 * 1. quantity can be enter
 * 2. size can be selected
 * 3. click the "Add to cart" 
 * 4. validate the message of "add to cart" when click the button
 * 5. link to Orderpage
 */
public class AddToCartPage extends BaseClass{
    
	@FindBy(xpath="//*[@id=\"quantity_wanted\"]")
	private WebElement quantity;
	
	@FindBy(xpath="//*[@id=\"group_1\"]")
	private WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	private WebElement addToCartMessag;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQauntity(String qauntity1) {
		Action.fluentWait(getDriver(), quantity, 20);
		Action.type(quantity, qauntity1);
	}
	
	public void selectSize(String size1) {
		Action.fluentWait(getDriver(), size, 20);
		Action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() {
		Action.click(getDriver(), addToCartBtn);
	}
	
	public boolean validateAddtoCart() throws Throwable {
		Action.fluentWait(getDriver(), addToCartMessag, 20);
		return Action.isDisplayed(getDriver(), addToCartMessag);
	}
	
	public OrderPage clickOnCheckOut() throws Throwable {
		Action.fluentWait(getDriver(), proceedToCheckOutBtn, 20);
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}
	
	
}
