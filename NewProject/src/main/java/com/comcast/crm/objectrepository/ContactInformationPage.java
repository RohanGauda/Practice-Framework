package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	WebDriver driver = null;

	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "mouseArea_Last Name")
	private WebElement lastNameField;

	public WebElement getLastNameField() {
		return lastNameField;
	}
	

}
