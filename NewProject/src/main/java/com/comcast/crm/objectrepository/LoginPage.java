package com.comcast.crm.objectrepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genericutility.fileutility.FileUtility;


public class LoginPage{
	WebDriver driver = null;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	public WebElement username;
	
	@FindBy(name = "user_password")
	public WebElement password;
	
	@FindBy(id = "submitButton")
	public WebElement submitButton;
	
	public void openLoginPage() throws Throwable {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		FileUtility fu = new FileUtility();
		String url = fu.getDataFromProperties("url");
		String un = fu.getDataFromProperties("username");
		String pwd = fu.getDataFromProperties("password");
		driver.get(url);
		username.sendKeys(un);
		password.sendKeys(pwd);
		submitButton.click();
	}
	
	
}
