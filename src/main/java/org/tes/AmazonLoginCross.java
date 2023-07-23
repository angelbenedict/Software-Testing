package org.tes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonLoginCross extends BaseClass {

	@Test
	private void launchbrowser0() {
		System.out.println("TC 1 : " + Thread.currentThread().getId());
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//span[@class='nav-icon nav-arrow'])[2]")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("angel123@gmail.com");
	}
	@Test
	private void launchbrowser1() {
		System.out.println("TC 2 : " + Thread.currentThread().getId());
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//span[@class='nav-icon nav-arrow'])[2]")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("angel123@gmail.com");
	}
	@Test
	private void launchbrowser2() {
		System.out.println("TC 3 : " + Thread.currentThread().getId());
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//span[@class='nav-icon nav-arrow'])[2]")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("angel123@gmail.com");
	}
}
