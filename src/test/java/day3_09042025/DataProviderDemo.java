package day3_09042025;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	@BeforeSuite
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	WebDriver driver;

	@DataProvider(name = "DataSet")
	public Object[][] mobileData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "Oppo";
		data[0][1] = "Reno 13";

		data[1][0] = "OnePlus";
		data[1][1] = "11";

		data[2][0] = "iPhone";
		data[2][1] = "16";

		return data;
	}

	@Test(dataProvider = "DataSet")
	public void srchMobile(String brand, String Model) throws InterruptedException {
		try {
			WebElement popupClose = driver.findElement(By.xpath("//div[@class='JFPqaw']/child::span"));
			popupClose.click();
			if (popupClose.isDisplayed()){
				popupClose.click();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		WebElement srchbox = driver.findElement(By.name("q"));
		srchbox.sendKeys(brand + " " + Model);
		srchbox.sendKeys(Keys.ENTER);
		driver.navigate().back();

	}

}
