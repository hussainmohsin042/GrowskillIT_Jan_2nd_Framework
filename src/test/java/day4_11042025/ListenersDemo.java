package day4_11042025;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(day4_11042025.ListenersTest.class)
@Test
public class ListenersDemo {
	public static WebDriver driver;

	public static void login() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username123")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	public void testToBeFailed() {
		Assert.assertTrue(false);
	}

	@Test
	public void TestToBeSkipped() throws Exception {
		throw new Exception("Skipping it deliberately!!!");
	}

}
