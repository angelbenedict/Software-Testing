package org.tes;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
		public static WebDriver driver;

		public static void launchBrowser() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		public static void launchFireFoxBrowser() {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		public static void launchInternetExplorerBrowser() {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		public static void windowMaximize() {
			driver.manage().window().maximize();
		}

		public static void launchURL(String url) {
			driver.get(url);
		}

		public static String pageTitle() {
			String title = driver.getTitle();
			return title;
		}

		public static String pageURL() {
			String url = driver.getCurrentUrl();
			return url;
		}

		public static void passText(String txt, WebElement ele) {
			ele.sendKeys(txt);
		}

		public static void closeEntireBrowser() {
			driver.quit();
		}

		public static void clickButton(WebElement ele) {
			ele.click();
		}

		public static void screenShot(String imgName) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File image = ts.getScreenshotAs(OutputType.FILE);
			File f = new File(
					"C:\\\\Users\\\\Marlene\\\\eclipse-workspace\\\\Screenshots\\\\Webscreenshots\\\\imgName.png");
			FileUtils.copyFile(image, f);
		}

		public static Actions a;

		public static void moveCursor(WebElement targetWebElement) {
			a = new Actions(driver);
			a.moveToElement(targetWebElement).perform();
		}

		public static void dragDrop(WebElement drgaElement, WebElement dropElement) {
			a = new Actions(driver);
			a.dragAndDrop(drgaElement, dropElement);
		}

		public static JavascriptExecutor js;

		public static void scrollPage(WebElement targetWebEle) {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", targetWebEle);
		}

		public static void scroll(WebElement element) {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(false)", element);
		}

		public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
			File f = new File("C:\\\\Users\\\\Marlene\\\\eclipse-workspace\\\\MavenFramework\\\\Excel\\\\SampleExcel.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Data");
			Row r = sheet.getRow(rowNum);
			Cell c = r.getCell(cellNum);
			int cellType = c.getCellType();

			String value = " ";
			if (cellType == 1) {
				String value2 = c.getStringCellValue();
			} else if (DateUtil.isCellDateFormatted(c)) {
				Date dateValue = c.getDateCellValue();
				SimpleDateFormat s = new SimpleDateFormat(value);
				String value1 = s.format(dateValue);
			} else {
				double d = c.getNumericCellValue();
				long l = (long) d;
				String valueOf = String.valueOf(l);
			}
		}
		public static void createNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException {
			File f = new File("C:\\Users\\Marlene\\eclipse-workspace\\MavenFramework\\Excel\\newExcelFile.xlsx");
			Workbook w = new XSSFWorkbook();
			Sheet newSheet = w.createSheet("Datas");
			Row newRow = newSheet.createRow(rowNum);
			Cell newCell = newRow.createCell(cellNum);
			newCell.setCellValue(writeData);
			FileOutputStream fos = new FileOutputStream(f);
			w.write(fos);
		}
		public static void createCell(int getRow, int createcell, String newData) throws IOException {
			File f = new File("C:\\Users\\Marlene\\eclipse-workspace\\MavenFramework\\Excel\\newExcelFile.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Datas");
			Row r = sheet.getRow(getRow);
			Cell c = r.createCell(createcell);
			c.setCellValue(newData);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}
		public static void createRow(int creRow, int crecell, String newData) throws IOException {
			File f = new File("C:\\Users\\Marlene\\eclipse-workspace\\MavenFramework\\Excel\\newExcelFile.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Datas");
			Row r = sheet.createRow(creRow);
			Cell c = r.createCell(crecell);
			c.setCellValue(newData);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}
		public static void updateDataParticularCell(int getRow, int getCell, String existingData, String writeNewData) throws IOException {
			File f = new File("C:\\\\Users\\\\Marlene\\\\eclipse-workspace\\\\MavenFramework\\\\Excel\\\\newExcelFile.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Datas");
			Row r = sheet.getRow(getRow);
			Cell c = r.getCell(getCell);
			String str = c.getStringCellValue();
			
			if (str.equals(existingData)) {
				c.setCellValue(writeNewData);
			}
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}
}