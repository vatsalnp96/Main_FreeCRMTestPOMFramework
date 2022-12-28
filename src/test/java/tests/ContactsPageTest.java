package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	String sheetname = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.clickOnContactsLink();
	}
	
	//@Test(priority=1)
	public void verifyContactsPageTitleTest() throws InterruptedException {
		Assert.assertEquals(contactspage.verifyContactsPageTitle(), "Cogmento CRM");
		Thread.sleep(3000);
	}
	
	//@Test(priority=2)
	public void verifyContactsLabelTest() throws InterruptedException {
		Assert.assertTrue(contactspage.verifyContactsLabel());
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetname); //create string variable sheetname and provide your sheet name
		return data;
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewCotact(String firstName, String lastName, String company, String position) {
		homepage.clickOnNewContactsLink();
		//contactspage.createNewContact("Bruce", "Banner", "Shield", "Hulk");
		contactspage.createNewContact(firstName, lastName, company, position);
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
