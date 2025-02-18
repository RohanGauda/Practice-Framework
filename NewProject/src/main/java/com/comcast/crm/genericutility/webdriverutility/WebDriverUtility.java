package com.comcast.crm.genericutility.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void getMaxScreen(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	
	public void waitForElementToLoad(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}
	
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		for (String windowHandle : set) {
			driver.switchTo().window(windowHandle);
			String actURL = driver.getCurrentUrl();
			if(actURL.equals(partialURL)) {
				break;
			}
		}
	}
	
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		for (String windowHandle : set) {
			driver.switchTo().window(windowHandle);
			String actTitle = driver.getTitle();
			if(actTitle.equals(partialTitle)) {
				break;
			}
		}
	}	
	
	public void getSelectOptionFromDropDown(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void getSelectOptionFromDropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void getSelectOptionFromDropDown(String value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public void moveToAnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

}
