package day7_18042025;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_Login_POM_PageFactory {
	WebDriver driver;

	public OrangeHRM_Login_POM_PageFactory(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);
	}

	// Repository

	@FindBy(name = "username")
	WebElement usernm;
	@FindBy(name = "password")
	WebElement pass;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;
	

	// By usernm=By.name("username");
	// By pass=By.name("password");
	// By loginBtn=By.xpath("//button[@type='submit']");

	public void URL() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public void enteruserName(String un) {
		usernm.sendKeys(un);
	}

	public void enterPassword(String pwd) {
		pass.sendKeys(pwd);
	}

	public void clickOnLoginButton() {
		loginBtn.click();
	}

}
