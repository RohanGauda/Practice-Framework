package CreateContactTest;

import org.testng.annotations.Test;

import com.comcast.crm.baseclassutility.BaseClass;

public class CreateOrganizationTest extends BaseClass{
	
	@Test(groups = "regression")
	public void createOrg() {
		System.out.println("createOrg");
	}
	
	@Test(groups = "smoke")
	public void createOrgWithIndustry() {
		System.out.println("createOrgWithIndustry");
	}
	
	@Test(groups = "regression")
	public void createOrgWithPhoneNumber() {
		System.out.println("createOrgWithPhoneNumber");
	}

}
