package CreateContactTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseclassutility.BaseClass;
import com.comcast.crm.genericutility.webdriverutility.UtilityClassObject;


@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class CreateContactTest extends BaseClass{
	
	@Test(groups = "smoke")
	public void createContactTest() {
		UtilityClassObject.getTest().log(Status.PASS, "Contact created");
	}
	
	@Test(groups = "regression")
	public void createContactTestWithOrg() {
		UtilityClassObject.getTest().log(Status.PASS, "Contact created");
	}
	
	@Test(groups = "smoke")
	public void createContactTestWithDate() {
		Assert.assertEquals("Home", "Login");
	}
}
