package org.tes;

import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PriorityTestNG extends BaseClass {
	
	@Test (priority = 10)
	private void tc1() {
		System.out.println("Test case 1 : Gmail");
		launchURL("https://mail.google.com/?");
	}
	@Test (priority = -5)
	private void tc5() {
		System.out.println("Test case 5 : Inmakes");
		launchURL("https://www.inmakes.com/");
	}
	@Test (priority = -25)
	private void tc4() {
		System.out.println("Test case 4 : Redbus");
		launchURL("https://m.redbus.in/");
	}
	@Test (priority = 13)
	private void tc7() {
		System.out.println("Test case 7 : Flipkart");
		launchURL("https://www.flipkart.com/");
	}
	@Test
	private void tc3() {
		System.out.println("Test case 3 : Amazon");
		launchURL("https://www.amazon.in/");
	}
	@Test (priority = -5)
	private void tc2() {
		System.out.println("Test case 2 : Facebook");
		launchURL("https://www.facebook.com/");
	}
	@Test (priority = 25)
	private void tc6() {
		System.out.println("Test case 6 : Youtube");
		launchURL("https://www.youtube.com/");
	}
	@BeforeMethod
	private void startTime() {
		Date d = new Date();
		System.out.println("Test case Start time : " + d);
	}
	@AfterMethod
	private void endTime() {
		Date d = new Date();
		System.out.println("Test case End time : " + d);
	}
	@BeforeClass
	private void launchTheBrowser() {
		launchBrowser();
		windowMaximize();
	}
	@AfterClass
	private void closeTheBrowser() {
		closeEntireBrowser();
	}
}