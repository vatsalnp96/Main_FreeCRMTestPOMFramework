package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class TasksPage extends TestBase {
	
	//PageFactory / OR
	@FindBy(xpath="//div[contains(@class,'ui header item mb5 light-black')]")
	WebElement tasksLabel;
	
	//Initializing WebElements
	public TasksPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public boolean verifyTasksLabel() {
		return tasksLabel.isDisplayed();
	}
}
