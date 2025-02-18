package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	WebDriver driver = null;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	@FindBy(xpath = "//img[contains(@src,'user')]")
	private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	public void logout() {
		adminImg.click();
		signOutLink.click();
	}

}
