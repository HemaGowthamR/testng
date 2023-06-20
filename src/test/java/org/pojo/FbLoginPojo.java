package org.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class FbLoginPojo extends BaseClass{
	public FbLoginPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	
	private WebElement emailbox;

	@FindAll({
		@FindBy(xpath="//input[@type='password']"),
		@FindBy(xpath="//input[@aria-label='Password']")
	})
	private WebElement passwordbox;

	@FindAll({
		@FindBy(xpath="//button[contains(text(),'in')]"),
		@FindBy(xpath="//button[text()='Log in']"),
	})
	private WebElement loginbutton;

	public WebElement getEmailbox() {
		return emailbox;
	}

	public WebElement getPasswordbox() {
		return passwordbox;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	
}
