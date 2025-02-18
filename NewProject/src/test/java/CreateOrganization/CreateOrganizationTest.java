package CreateOrganization;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseclassutility.BaseClass;
import com.comcast.crm.objectrepository.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.OrganizationInformation;
import com.comcast.crm.objectrepository.OrganizationsPage;



@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrganizationTest() throws Throwable {

		String expectedOrgName = elib.getReadDataFromExcel("org1", 7, 2) + jlib.getRandomNumber(3000);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(expectedOrgName);

		OrganizationInformation oip = new OrganizationInformation(driver);
		String actOrgName = oip.getHeaderMsg().getText();

		Assert.assertEquals(true, actOrgName.contains(expectedOrgName));
	}

	@Test
	public void createOrganizationWithIndustry() throws Throwable {

		String expectedOrgName = elib.getReadDataFromExcel("org1", 7, 2) + jlib.getRandomNumber(3000);
		String industryName = elib.getReadDataFromExcel("org1", 4, 3);
		String typeName = elib.getReadDataFromExcel("org1", 4, 4);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(expectedOrgName, industryName, typeName);

		OrganizationInformation oip = new OrganizationInformation(driver);
		
		String actIndustry = oip.getIndustry().getText();
		
		String actType = oip.getType().getText();

		Assert.assertEquals(true, actIndustry.contains(industryName));
		Assert.assertEquals(true, actType.contains(typeName));
		
		Thread.sleep(2000);

	}

	@Test
	public void createOrganizationWithContact() throws Throwable {

		String expectedOrgName = elib.getReadDataFromExcel("org1", 7, 2) + jlib.getRandomNumber(3000);
		String expectedPhNo = elib.getReadDataFromExcel("org1", 7, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(expectedOrgName, expectedPhNo);

		OrganizationInformation oip = new OrganizationInformation(driver);
		String actPhno = oip.getPhoneMsg().getText();

		Assert.assertEquals(true, actPhno.contains(expectedPhNo));

	}
	
}
