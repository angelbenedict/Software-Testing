package org.tes;

import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserLaunch extends BaseClass {
	
	@Test (invocationCount = 3)
	private void tc1() {
		System.out.println("Test case 1 : Gmail");
		launchURL("https://mail.google.com/?");
	}
	@Test
	private void tc2() {
		System.out.println("Test case 2 : Inmakes");
		launchURL("https://www.inmakes.com/");
	}
	@Test
	private void tc5() {
		System.out.println("Test case 5 : Redbus");
		launchURL("https://m.redbus.in/");
	}
	@Test (enabled = false)
	private void tc4() {
		System.out.println("Test case 4 : Amazon");
		launchURL("https://www.amazon.in/");
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