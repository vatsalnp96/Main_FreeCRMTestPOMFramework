package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.TasksPage;

public class TasksPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TasksPage taskspage;
	
	public TasksPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		taskspage = new TasksPage();
	}
	
	@Test
	public void verifyTasksLabelTest() {
		homepage.clickOnTasksLink();
		
		Assert.assertTrue(taskspage.verifyTasksLabel(), "Tasks label is not displayed");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
