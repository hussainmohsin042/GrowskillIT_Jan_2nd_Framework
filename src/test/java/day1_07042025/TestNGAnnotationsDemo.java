package day1_07042025;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo {

	@BeforeSuite

	public void BeforeSuiteMethod() {
		System.out.println("Before Suite Method");
	}

	@BeforeTest
	public void BeforeTestMethod() {
		System.out.println("Before Test Method");
	}

	@BeforeClass
	public void BeforeClassMethod() {
		System.out.println("Before Class Method");
	}

	@BeforeMethod
	public void BeforeMethodMethod() {
		System.out.println("Before Method");
	}

	@Test
	public void test1() {
		System.out.println("Test1");
	}

	@Test
	public void test2() {
		System.out.println("Test2");
	}

	@AfterMethod
	public void AfterMethodMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void AfterClassMethod() {
		System.out.println("After Class");
	}

	@AfterTest
	public void AfterTestMethod() {
		System.out.println("After Test");
	}

	@AfterSuite
	public void AfterSuiteMethod() {
		System.out.println("After Suite");
	}

}
