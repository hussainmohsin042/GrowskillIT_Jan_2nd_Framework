package day4_11042025;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class Utility extends ListenersDemo {
		public static void captureSS(String name) throws IOException {
			System.out.println("Value of Driver: "+driver);
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\hussa\\Desktop\\MohsinZ Docs\\GrowSkill_IT_Materials\\Selenium_Screenshots\\"
				+ name + ".jpeg");
		FileHandler.copy(src, dest);
	}

}