package CreateOrg;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class SampleTestForScreenShot {
	
	@Test
	public void amazonTest() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("http://flipkart.com");
		driver.manage().window().maximize();
		
		TakesScreenshot tks = (TakesScreenshot) driver;
		File src = tks.getScreenshotAs(OutputType.FILE);
		File dstfile = new File("./screenshot/test1.png");
		FileHandler.copy(src, dstfile);
		
	}

}
