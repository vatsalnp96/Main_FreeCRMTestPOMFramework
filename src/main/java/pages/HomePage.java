package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase{
	
	//PageFactory / OR
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//div[@id='main-nav']/div[3]/button")
	WebElement newContactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//div[@id='main-nav']/div[5]/button")
	WebElement newDealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initializing Webelements
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions/Methods
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserPresent() {
		return userLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		
		return new DealsPage();
	}
	
	public void clickOnNewContactsLink() {
		Actions builder = new Actions(driver);
		builder.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
	}
	
	public void clickOnNewDealsLink() {
		Actions builder = new Actions(driver);
		builder.moveToElement(dealsLink).build().perform();
		newDealsLink.click();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		
		return new TasksPage();
	}
	
	
}
