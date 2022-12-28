package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ContactsPage;
import pages.DealsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.TasksPage;


public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskspage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = new ContactsPage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void verifyUserLabelTest() {
		boolean flag = homepage.verifyUserPresent();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void clickOnContactsLinkTest() {
		contactspage = homepage.clickOnContactsLink();
	}
	
	@Test(priority=4)
	public void clickOnDealLinkTest() {
		dealspage = homepage.clickOnDealsLink();
	}
	
	@Test(priority=5)
	public void clickOnTasksLinkTest() {
		taskspage = homepage.clickOnTasksLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
