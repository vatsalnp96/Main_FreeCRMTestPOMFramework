package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.DealsPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class DealsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	DealsPage dealspage;
	
	String sheetname = "deals";
	
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		dealspage = new DealsPage();
	}
	
	//@Test(priority=1)
	public void varifyDealsLabelTest() {
		homepage.clickOnDealsLink();
		Assert.assertTrue(dealspage.varifyDealsPageLAbel(), "Deals label is not displaying");
		
	}
	
	@DataProvider
	public Object[][] getCRMdealsData() {
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMdealsData")
	public void validateCreateNewDealTest(String title, String amount, String commission) throws InterruptedException {
		Thread.sleep(3000);
		homepage.clickOnNewDealsLink();
		Thread.sleep(3000);
		
		//dealspage.createNewDeal("December deal", "1000", "555");
		dealspage.createNewDeal(title, amount, commission);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
