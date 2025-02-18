package com.comcast.crm.objectrepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrganizationInformation {
	
	WebDriver driver = null;
	
	public OrganizationInformation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(name = "industry")
	private WebElement industry;
	
	@FindBy(name = "accounttype")
	private WebElement type;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement phone;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homeBtn;

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	public WebElement getIndustry() {
		return industry;
	}
	
	public WebElement getType() {
		return type;
	}
	
	public WebElement getPhoneMsg() {
		return phone;
	}
	
	
}
