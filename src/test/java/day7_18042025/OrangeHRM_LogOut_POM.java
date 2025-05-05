package day7_18042025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_LogOut_POM {

	WebDriver driver;

	public OrangeHRM_LogOut_POM(WebDriver driver) {
		this.driver = driver;
	}
	// Repository

	By profile = By.className("oxd-userdropdown-tab");
	By logOut = By.xpath("//ul[@role='menu']/child::li[4]/child::a");

	public void clickOnProfile() {
		driver.findElement(profile).click();
	}

	public void clickOnLogOut() {
		driver.findElement(logOut).click();
	}

}
