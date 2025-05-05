package day9_20042025;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import day7_18042025.OrangeHRM_LogOut_POM;
import day7_18042025.OrangeHRM_Login_POM_PageFactory;

public class KeyWordDrivenFramework {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// OrangeHRM_Login_POM lgin=new OrangeHRM_Login_POM(driver);
		OrangeHRM_Login_POM_PageFactory lgin = new OrangeHRM_Login_POM_PageFactory(driver);
		OrangeHRM_LogOut_POM lgout = new OrangeHRM_LogOut_POM(driver);
		lgin.URL();
		// Thread.sleep(5000);

		// OrangeHRM_LogOut_POM_PageFactory lgout=new
		// OrangeHRM_LogOut_POM_PageFactory(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		String filepath = "C:\\Users\\hussa\\Desktop\\MohsinZ Docs\\GrowSkill_IT_Materials\\ExcelReadAndWrite\\TestingDataKeyword_ORHM.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Keyword");

		int rows = sheet.getLastRowNum();
		System.out.println("Total No. Of Rows: " + rows);
		for (int i = 1; i <= rows; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell key = row.getCell(1);

			System.out.println("Keywords --->" + key);

			switch (key.toString()) {
			case "url":
				lgin.URL();
				System.out.println("URL Keyword is Matched");
				break;

			case "enterUserName":
				lgin.enteruserName("Admin");
				System.out.println("enteruserName Keyword is Matched");
				break;

			case "enterPassword":
				lgin.enterPassword("admin123");
				System.out.println("enterPassword Keyword is Matched");
				break;

			case "ClickOnLoginButton":
				lgin.clickOnLoginButton();
				System.out.println("ClickOnLoginButton Keyword is Matched");
				break;

			case "ClickOnProfile":
				lgout.clickOnProfile();
				System.out.println("ClickOnProfile Keyword is Matched");
				break;

			case "ClickOnLogout Link":
				lgout.clickOnLogOut();
				System.out.println("ClickOnLogout Link Keyword is Matched");
				break;

			default:
				System.out.println("Invalid Keyword");

			}

		}
		workbook.close();
		fis.close();

	}
}
