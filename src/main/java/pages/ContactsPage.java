package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactsLabel;
	
	@FindBy(name="first_name")
	WebElement first_name;
	
	@FindBy(name="last_name")
	WebElement last_name;
	
	@FindBy(xpath="//div[@name='company']/input")
	WebElement company;
	
	@FindBy(name="position")
	WebElement position;
	
	@FindBy(xpath="//div[@class='item']/button[2]")
	WebElement save_button;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public String verifyContactsPageTitle() {
		 return driver.getTitle();
	}
	
	public void createNewContact(String fname, String lname, String cname, String pname) {
		first_name.sendKeys(fname);
		last_name.sendKeys(lname);
		company.sendKeys(cname);
		position.sendKeys(pname);
		save_button.click();
	}
}
