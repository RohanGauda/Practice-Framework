package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
	WebDriver driver = null;

	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastName;
	
	@FindBy(name = "button")
	private WebElement saveBtn;

	public WebElement getLastName() {
		return lastName;
	}
	
	public void createContact(String lastname) {
		lastName.sendKeys(lastname);
		saveBtn.click();
	}
}
