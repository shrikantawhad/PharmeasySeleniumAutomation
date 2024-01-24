package utility.report;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	// to create reports
	public static ExtentSparkReporter spark;

	// publish / build the reports
	public static ExtentReports extent;

	// to add logs / messages
	public static ExtentTest extentTest;

	// static WebDriver driver;
	public static WebDriver driver;

	public static String testName;

	public static String browser;
}
