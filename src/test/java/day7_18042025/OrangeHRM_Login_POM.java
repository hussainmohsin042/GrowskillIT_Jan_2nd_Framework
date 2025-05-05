package day7_18042025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_Login_POM {
	WebDriver driver;
	
	public OrangeHRM_Login_POM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Repository
	
	By usernm=By.name("username");
	By pass=By.name("password");
	By loginBtn=By.xpath("//button[@type='submit']");
	
	
	public void URL()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	public void enteruserName()
	{
		driver.findElement(usernm).sendKeys("Admin");
	}
	
	public void enterPassword()
	{
		driver.findElement(pass).sendKeys("admin123");
	}
	
	public void clickOnLoginButton()
	{
		driver.findElement(loginBtn).click();
	}

}
