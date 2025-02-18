package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "button")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryDD;
	
	@FindBy(name = "accounttype")
	private WebElement typeDD;
	
	@FindBy(id = "phone")
	private WebElement phoneNum;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getphoneNume() {
		return phoneNum;
	}
	
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createOrg(String orgName, String pindustry, String typedd) {
		orgNameEdt.sendKeys(orgName);
		Select sel = new Select(industryDD);
		sel.selectByValue(pindustry);
		
		Select sel1 = new Select(typeDD);
		sel1.selectByValue(typedd);
		saveBtn.click();
	}
	
	public void createOrg(String orgName, String num) {
		orgNameEdt.sendKeys(orgName);
		phoneNum.sendKeys(num);
		saveBtn.click();
	}
}
