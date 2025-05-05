package day6_15042025;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTestingDemo {
	WebDriver driver;
	@Parameters("Browser")
	@Test(priority=0)
	public void LaunchBrowser(String browser) {
		driver = null;
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}

		else if (browser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}

	}

	@Test(priority=1)
	public void AppLaunch() {
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login");
	}
}
