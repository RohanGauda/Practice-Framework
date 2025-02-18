package com.comcast.crm.baseclassutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.genericutility.databaseutility.DataBaseUtility;
import com.comcast.crm.genericutility.excelutility.ExcelUtility;
import com.comcast.crm.genericutility.fileutility.FileUtility;
import com.comcast.crm.genericutility.javautility.JavaUtility;
import com.comcast.crm.genericutility.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public DataBaseUtility db = new DataBaseUtility();
	public JavaUtility jlib = new JavaUtility();
	public ExcelUtility elib = new ExcelUtility();
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable {
		System.out.println("===Connect to Db, Report Config===");
		db.getDataBaseConnection();
	}
	
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable{
		System.out.println("==Launch a Browser==");
		FileUtility flib = new FileUtility();
		String BROWSER = flib.getDataFromProperties("browser");
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void  configBM() throws Throwable {
		System.out.println("=LOGIN=");
		
		LoginPage lp = new LoginPage(driver);
		lp.openLoginPage();
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM() throws InterruptedException {
		System.out.println("=LOGOUT=");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC() {
		System.out.println("==Close  the BROWSER==");
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() {
		System.out.println("===Close DB, Report BackUp===");
		db.getCloseConnection();
	}
}
