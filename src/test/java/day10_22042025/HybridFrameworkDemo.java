package day10_22042025;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

public class HybridFrameworkDemo {
	@Test
	public void executionMethod() throws IOException {
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

		String filepath = "C:\\Users\\hussa\\Desktop\\MohsinZ Docs\\GrowSkill_IT_Materials\\ExcelReadAndWrite\\TestingDataKeyword_ORHM.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet dataSheet = workbook.getSheet("Data");
		XSSFSheet keySheet = workbook.getSheet("Keyword");

		int dRows = dataSheet.getLastRowNum();
		System.out.println("Total No. Of Data Rows: " + dRows);

		int kRows = keySheet.getLastRowNum();
		System.out.println("Total No. Of Key Rows: " + kRows);

		for (int dr = 1; dr <= dRows; dr++) {
			XSSFRow dRow = dataSheet.getRow(dr);
			XSSFCell usernm = dRow.getCell(0);
			XSSFCell pass = dRow.getCell(1);
			XSSFCell result = dRow.createCell(2);

			System.out.println("UserName ----------->" + usernm + "              Password ------>" + pass);
			try {
				for (int kr = 1; kr <= kRows; kr++) {
					XSSFRow kRow = keySheet.getRow(kr);
					XSSFCell key = kRow.getCell(1);
					XSSFCell match = kRow.createCell(2);

					System.out.println("Keywords ----->" + key);

					switch (key.toString()) {
					case "url":
						lgin.URL();
						System.out.println("URL Keyword is Matched");
						match.setCellValue("URL Keyword is Matched");
						break;

					case "enterUserName":
						lgin.enteruserName(usernm.toString());
						System.out.println("enteruserName Keyword is Matched");
						match.setCellValue("enteruserName Keyword is Matched");
						break;

					case "enterPassword":
						lgin.enterPassword(pass.toString());
						System.out.println("enterPassword Keyword is Matched");
						match.setCellValue("enterPassword Keyword is Matched");
						break;

					case "ClickOnLoginButton":
						lgin.clickOnLoginButton();
						System.out.println("ClickOnLoginButton Keyword is Matched");
						match.setCellValue("ClickOnLoginButton Keyword is Matched");
						break;

					case "ClickOnProfile":
						lgout.clickOnProfile();
						System.out.println("ClickOnProfile Keyword is Matched");
						match.setCellValue("ClickOnProfile Keyword is Matched");
						break;

					case "ClickOnLogout Link":
						lgout.clickOnLogOut();
						System.out.println("ClickOnLogout Link Keyword is Matched");
						match.setCellValue("ClickOnLogout Link Keyword is Matched");
						break;

					default:
						System.out.println("Invalid Keyword");
					}
				}
				System.out.println("Valid Data");
				result.setCellValue("Valid Data");
			} catch (Exception e) {
				System.out.println("InValid Data");
				result.setCellValue("InValid Data");
			}

		}
		// workbook.close();
		fis.close();
		FileOutputStream fos = new FileOutputStream(filepath);
		workbook.write(fos);

	}
}