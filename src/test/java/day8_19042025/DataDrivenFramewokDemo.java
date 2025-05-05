package day8_19042025;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import day7_18042025.OrangeHRM_LogOut_POM;
import day7_18042025.OrangeHRM_Login_POM_PageFactory;

public class DataDrivenFramewokDemo {
	@Test
	public void executionMethod() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// OrangeHRM_Login_POM lgin=new OrangeHRM_Login_POM(driver);
		OrangeHRM_Login_POM_PageFactory lgin = new OrangeHRM_Login_POM_PageFactory(driver);
		OrangeHRM_LogOut_POM lgout = new OrangeHRM_LogOut_POM(driver);
		lgin.URL();
		Thread.sleep(5000);

		// OrangeHRM_LogOut_POM_PageFactory lgout=new
		// OrangeHRM_LogOut_POM_PageFactory(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		String filepath = "C:\\Users\\hussa\\Desktop\\MohsinZ Docs\\GrowSkill_IT_Materials\\ExcelReadAndWrite\\TestingDataKeyword_ORHM.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Data");
		int rows = sheet.getLastRowNum();
		System.out.println("Total No. Of Rows: " + rows);
		for (int i = 1; i <= rows; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell usernm = row.getCell(0);
			XSSFCell pass = row.getCell(1);

			System.out.println("UserNmae ----------->" + usernm + "              Password ------>" + pass);
			try {
				lgin.enteruserName(usernm.toString());
				lgin.enterPassword(pass.toString());
				lgin.clickOnLoginButton();
				lgout.clickOnProfile();
				lgout.clickOnLogOut();
				System.out.println("Valid Data");
			} catch (Exception e) {
				System.out.println("InValid Data");
			}
		}
		workbook.close();
		fis.close();
	}

}
