package testcases;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import pageObjects.PharmeasyPO;
import utility.report.BaseClass;
import utility.report.ReportsGenerator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class POModelPharmeasyTest extends BaseClass {

	@Test(priority = 1)
	public void LabTestsTest() throws InterruptedException {
		PharmeasyPO pharmeasyPO = new PharmeasyPO(driver);

		pharmeasyPO.labTestsClick();
		assertTrue(pharmeasyPO.isSearchBarPlaceHolderDisplayed());

	}

	@Parameters(value = { "pinCode" })
	@Test(priority = 2)
	public void SetLocationTest(String pinCode) throws InterruptedException {
		PharmeasyPO pharmeasyPO = new PharmeasyPO(driver);
		// Thread.sleep(2000);

		pharmeasyPO.delieverToClick();

		// Thread.sleep(2000);

		pharmeasyPO.pinCode(pinCode);
		pharmeasyPO.checkButtonClick();
		assertTrue(pharmeasyPO.isLocationHeaderDisplayed());

	}

	@Parameters(value = { "testName" })
	@Test(priority = 3)
	public void searchTest(String testName) throws InterruptedException {
		PharmeasyPO pharmeasyPO = new PharmeasyPO(driver);

		Thread.sleep(2000);

		pharmeasyPO.searchBar(testName);

		pharmeasyPO.searchButtonClick();

		WebElement element = driver.findElement(By.xpath("//div[@class='_1NZHk']"));
		System.out.println(pharmeasyPO.searchResultText.getText().substring(21, 41));

		String searchResultElementText = pharmeasyPO.searchResultElement.getText().substring(21, 41);
		assertEquals(searchResultElementText, "Cardiac Risk Markers");

	}

	@Test(priority = 4)
	public void SelectTest() throws InterruptedException {

		PharmeasyPO pharmeasyPO = new PharmeasyPO(driver);

		pharmeasyPO.selectButtonClick();
		pharmeasyPO.patientCountClick();

		assertTrue(pharmeasyPO.isPatientCountDisplayed());

	}

	@Test(priority = 5)
	public void ViewCartTest() throws InterruptedException {

		PharmeasyPO pharmeasyPO = new PharmeasyPO(driver);
		pharmeasyPO.viewCartClick();

		Thread.sleep(2000);
		assertTrue(pharmeasyPO.islabTestCartDisplayed());
	}

	@Test(priority = 6)
	public void ProceedTest() throws InterruptedException {

		PharmeasyPO pharmeasyPO = new PharmeasyPO(driver);
		pharmeasyPO.proceedClick();

		assertTrue(pharmeasyPO.isLoginPageDisplayed());

	}

	@Parameters(value = { "Browser" })
	@BeforeClass
	public void beforeClass(String browser) {
		DesiredCapabilities dc;
		if (browser.equals("Chrome")) {
//			ChromeOptions opts = new ChromeOptions();
//			opts.addArguments("--remote-allow-origins=*");
//			opts.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir"));
//
//			opts.setPlatformName("Windows");
//		    dc = new DesiredCapabilities(opts);
//		    driver.navigate().to("https://pharmeasy.in/");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			// options.addArguments("--user-data-dir=" +
			// System.getProperty("java.io.tmpdir"));
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.navigate().to("https://pharmeasy.in/");
		} else if (browser.equals("Edge")) {
//			EdgeOptions opts = new EdgeOptions ();
//		
//			opts.setPlatformName("Windows");
//		    dc = new DesiredCapabilities(opts);
//		    driver.navigate().to("https://pharmeasy.in/");

			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			// options.addArguments("--user-data-dir=" +
			// System.getProperty("java.io.tmpdir"));
			
			options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir"));
			driver = new EdgeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.navigate().to("https://pharmeasy.in/");
		}

//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		//options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir"));
//		driver = new ChromeDriver(options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		driver.navigate().to("https://pharmeasy.in/");

	}

	@BeforeTest
	public void init() {
		ReportsGenerator.createReport();
	}

	@Parameters(value = { "Browser" })
	@AfterMethod
	public void postTest(ITestResult itr, String browser) throws IOException {
		// String str = itr.getMethod().toString();
		String str = itr.getMethod().toString();
		// System.out.println("/n"+" Name:" + str +"/n");
//		System.out.println("/n");
//		System.out.println("Browser :" + browser);
//		System.out.printf("Method Name:" + str.substring(str.indexOf('.') + 1,str.indexOf('(')));
		testName = str.substring(str.indexOf('.') + 1, str.indexOf('('));
		ReportsGenerator.finishReportAfterTest(itr, testName, browser);
	}

	@AfterTest
	public void end() {
		extent.flush();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
