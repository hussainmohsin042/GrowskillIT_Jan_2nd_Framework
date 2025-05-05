package day5_14042025;

import org.testng.annotations.Test;

public class GroupsDemo1 {

	@Test(groups={"Smoke"})
	public void Test1()

	{
		System.out.println("Test Case 1: {\"Smoke\"}");
	}

	@Test(groups={"Sanity"})
	public void Test2()

	{
		System.out.println("Test Case 2: {\"Sanity\"}");
	}

	@Test(groups={"Smoke", "Sanity"})
	public void Test3()

	{
		System.out.println("Test Case 3: {\"Smoke\", \"Sanity\"}");
	}

	@Test(groups={"Regression"})
	public void Test4()

	{
		System.out.println("Test Case 4: {\"Regression\"}");
	}

	@Test(groups={"Smoke", "Regression"})
	public void Test5()

	{
		System.out.println("Test Case 5: {\"Smoke\", \"Regression\"}");
	}

	@Test(groups={"Sanity", "Regression"})
	public void Test6()

	{
		System.out.println("Test Case 6: {\"Sanity\", \"Regression\"}");
	}

	@Test(groups={"Smoke","Sanity", "Regression"})
	public void Test7()

	{
		System.out.println("Test Case 7: {\"Smoke\",\"Sanity\", \"Regression\"}");
	}

	@Test(groups={"Integration"})
	public void Test8()

	{
		System.out.println("Test Case 8: {\"Integration\"}");
	}

	@Test(groups={"Integration"})
	public void Test9()

	{
		System.out.println("Test Case 9: {\"Integration\"}");
	}

	@Test(groups={"Smoke","Integration"})
	public void Test10()

	{
		System.out.println("Test Case 10: {\"Smoke\",\"Integration\"}");
	}

	@Test(groups={"Sanity","Integration"})
	public void Test11()

	{
		System.out.println("Test Case 11: {\"Sanity\",\"Integration\"}");
	}

	@Test(groups={"Retest"})
	public void Test12()

	{
		System.out.println("Test Case 12: {\"Retest\"}");
	}

}
