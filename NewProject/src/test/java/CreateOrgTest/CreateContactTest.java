package CreateOrgTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseclassutility.BaseClass;
import com.comcast.crm.objectrepository.ContactInformationPage;
import com.comcast.crm.objectrepository.ContactPage;
import com.comcast.crm.objectrepository.CreateNewContactPage;
import com.comcast.crm.objectrepository.HomePage;

public class CreateContactTest extends BaseClass{
	
	@Test
	public void createContactTest() throws Throwable {
		
		String expectedLastName = elib.getReadDataFromExcel("org", 1, 2) + jlib.getRandomNumber(3000);
		
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContact().click();
		
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(expectedLastName);
		
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actLastname = cip.getLastNameField().getText();
		
		Assert.assertEquals(true, actLastname.contains(expectedLastName));
		
	}
	
	@Test
	public  void createContactTestWithOrganization() {
		
		
	}

}
