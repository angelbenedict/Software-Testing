package org.tes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public final class SampleTestNG {

	@Test
	private void tc1() {
		System.out.println("Test case 1");
	}
	@Test
	private void tc2() {
		System.out.println("Test case 2");
	}
	@Test
	private void tc5() {
		System.out.println("Test case 5");
	}
	@Test
	private void tc4() {
		System.out.println("Test case 4");
	}
	@Test
	private void tc3() {
		System.out.println("Test case 3");
	}
	@BeforeMethod
	private void startTime() {
		System.out.println("Test case Start time");
	}
	@AfterMethod
	private void endTime() {
		System.out.println("Test case End time");
	}
}