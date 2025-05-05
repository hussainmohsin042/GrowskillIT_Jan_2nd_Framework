package day7_18042025;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_LogOut_POM_PageFactory {

	WebDriver driver;

	public OrangeHRM_LogOut_POM_PageFactory(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);
	}
	// Repository

	@FindBy(className = "oxd-userdropdown-tab")
	WebElement profile;
	@FindBy(xpath = "//ul[@role='menu']/child::li[4]/child::a")
	WebElement logOut;

//	By profile = By.className("oxd-userdropdown-tab");
//	By logOut = By.xpath("//ul[@role='menu']/child::li[4]/child::a");

	public void clickOnProfile() {
		profile.click();
	}

	public void clickOnLogOut() {
		logOut.click();
	}

}
