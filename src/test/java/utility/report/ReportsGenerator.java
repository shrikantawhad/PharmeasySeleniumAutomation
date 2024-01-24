package utility.report;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsGenerator extends BaseClass {

	public static void createReport() {

		// to create reports
		extent = new ExtentReports();

		// publish / build the reports
		spark = new ExtentSparkReporter("Reports/testReports.html");

		// attching reporter
		extent.attachReporter(spark);
	}

	public static void finishReportAfterTest(ITestResult itr, String testName, String browser) throws IOException {
		// Object to add logs/messages
		extentTest = extent.createTest("Test Reports");

		if (itr.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.INFO, ("Test " + itr.getName() + "execution successful."));
			extentTest.assignCategory("Success-Category");
			extentTest.assignAuthor("Shrikant");
			extentTest.addScreenCaptureFromPath(CaptureImage.takeScreenshot(driver, testName, browser));
		} else if (itr.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, ("Test " + itr.getName() + "execution Failed."));
			extentTest.assignCategory("Failed-Category");
			extentTest.assignAuthor("Shrikant");
			// extentTest.addScreenCaptureFromPath(CaptureImage.takeScreenshot(driver));
			extentTest.addScreenCaptureFromPath(CaptureImage.takeScreenshot(driver, testName, browser));
		} else if (itr.getStatus() == ITestResult.SKIP) {

			extentTest.log(Status.SKIP, ("Test " + itr.getName() + "execution skipped."));
			extentTest.assignCategory("Skipped-Category");
		} else {
			Reporter.log("Test Execution skipped.");
		}
	}
}
