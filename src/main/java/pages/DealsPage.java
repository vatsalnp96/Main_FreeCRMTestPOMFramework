package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class DealsPage extends TestBase {
	
	//PageFactory / OR
	@FindBy(xpath="//div[contains(@class,'ui header item mb5 light-black')]")
	WebElement dealsLabel;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(name="amount")
	WebElement amount;
	
	@FindBy(name="commission")
	WebElement commission;
	
	@FindBy(xpath="//div[@class=\"item\"]/button[2]")
	WebElement save_Button;
	
	
	//Initializing elements
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public boolean varifyDealsPageLAbel() {
		return dealsLabel.isDisplayed();
	}
	
	public void createNewDeal(String dt, String da, String dc) {
		title.sendKeys(dt);
		amount.sendKeys(da);
		commission.sendKeys(dc);
		save_Button.click();
	}
}
