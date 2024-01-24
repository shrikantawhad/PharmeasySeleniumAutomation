package utility.report;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

public class CaptureImage extends BaseClass{
	static int i=1;
	public static String takeScreenshot(WebDriver driver, String testName, String browser) throws IOException {
		i++;
		String filePath = System.getProperty("user.dir") + "/screenshots/" + testName+"_"+browser+".png";

		TakesScreenshot takeScreenshot = ((TakesScreenshot) driver);
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(filePath);
		
		FileUtils.copyFile(sourceFile, destinationFile);
		return filePath;
	}

}
