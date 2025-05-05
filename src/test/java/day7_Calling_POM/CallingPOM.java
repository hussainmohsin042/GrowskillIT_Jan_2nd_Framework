package day7_Calling_POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import day7_18042025.OrangeHRM_LogOut_POM_PageFactory;
import day7_18042025.OrangeHRM_Login_POM_PageFactory;

public class CallingPOM {

	@Test
	public void executionMethod() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// OrangeHRM_Login_POM lgin=new OrangeHRM_Login_POM(driver);
		// OrangeHRM_LogOut_POM lgout=new OrangeHRM_LogOut_POM(driver);

		OrangeHRM_Login_POM_PageFactory lgin = new OrangeHRM_Login_POM_PageFactory(driver);
		OrangeHRM_LogOut_POM_PageFactory lgout = new OrangeHRM_LogOut_POM_PageFactory(driver);

		lgin.URL();
		lgin.enteruserName("Admin");
		lgin.enterPassword("admin123");
		lgin.clickOnLoginButton();
		lgout.clickOnProfile();
		lgout.clickOnLogOut();
	}

}
