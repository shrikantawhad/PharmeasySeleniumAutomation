package testcases;

import org.testng.annotations.Test;

import pageObjects.PharmeasyPO;
import utility.report.BaseClass;
import utility.report.ReportsGenerator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class PharmeasyTest extends BaseClass {

	@Test(priority = 1)
	public void LabTestsTest() throws InterruptedException {
		WebElement labTestsElement = driver.findElement(By.xpath(
				"//div[@class='c-PJLV c-bXbWpx c-bXbWpx-lfylVv-direction-row c-bXbWpx-fMErMJ-justify-left c-bXbWpx-joJbDg-align-center c-bXbWpx-NQWrI-justify-center c-bXbWpx-ijqTEiu-css']/div[2]/a[2]"));
		labTestsElement.click();

	}

	@Test(priority = 2)
	public void SetLocationTest() throws InterruptedException {
		Thread.sleep(2000);
		WebElement delieverToElement = driver.findElement(By.xpath("//span[@class='_2xei5']"));
		delieverToElement.click();

		Thread.sleep(2000);
		WebElement pinCodeElement = driver.findElement(By.xpath("//input[@class='jss27 _9Rsw_ _34quF']"));
		pinCodeElement.sendKeys("411033");

		WebElement checkButtonElement = driver
				.findElement(By.xpath("//button[@class='_2FE4Z _2Jc-Z _2Jc-Z _10CzH _3LBfS']"));
		checkButtonElement.click();
		// assertTrue(registerHead.isDisplayed());
	}

	@Test(priority = 3)
	public void searchTest() throws InterruptedException {

		// Create Account
		WebElement searchElement = driver.findElement(By.xpath("//input[@class='jss27 _9Rsw_ undefined _2Saml']"));
		searchElement.sendKeys("Cardiac Risk Markers");

		WebElement searchButtonElement = driver
				.findElement(By.xpath("//div[@class='_2tdEn _1pXi6 _1gc6o undefined']//*[name()='svg']"));
		searchButtonElement.click();

	}

	@Test(priority = 4)
	public void SelectTest() throws InterruptedException {

		WebElement selectButtonElement = driver
				.findElement(By.xpath("//button[@class='_2FE4Z _2Jc-Z _1JBjj _5YN3Z _7M65L']"));
		selectButtonElement.click();

		WebElement patientNumberElement = driver.findElement(By.xpath("//p[.='1 patient']"));
		patientNumberElement.click();

	}

	@Test(priority = 5)
	public void ViewCartTest() throws InterruptedException {

		WebElement viewCartElement = driver.findElement(
				By.xpath("//div[@class='showDesktop']//button[@class='_2FE4Z _2Jc-Z _2Jc-Z ZHQJn _3LBfS']"));
		viewCartElement.click();

	}

	@Test(priority = 6)
	public void ProceedTest() throws InterruptedException {

		WebElement proceedElement = driver.findElement(By.id("cart-addPatient-Dweb"));
		proceedElement.click();

	}

	@BeforeClass
	public void beforeClass() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		// options.addArguments("--user-data-dir=" +
		// System.getProperty("java.io.tmpdir"));

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.navigate().to("https://pharmeasy.in/");

	}

	@BeforeTest
	public void init() {
		ReportsGenerator.createReport();
	}

	@AfterMethod
	public void postTest(ITestResult itr) throws IOException {
//		String str = itr.getMethod().toString();
//		System.out.printf(" Name:"+str);
//		System.out.printf("Method Name:"+itr.getMethod().toString().indexOf('.')+1, itr.getMethod().toString().indexOf('('));
		ReportsGenerator.finishReportAfterTest(itr, testName, browser);
	}

	@AfterTest
	public void end() {
		extent.flush();
	}

	@AfterClass
	public void afterClass() {
		// driver.close();
	}

}
