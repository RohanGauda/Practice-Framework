package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	WebDriver driver = null;

	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	@FindBy(name = "search_text")
	private WebElement searchBox;
	
	@FindBy(id = "bas_searchfield")
	private WebElement searchDD;
	
	@FindBy(name = "submit")
	private WebElement searchBtn;

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

}
