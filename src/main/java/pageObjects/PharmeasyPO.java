package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class PharmeasyPO {
	WebDriver driver;

	// Lab Tests Homecard
	@FindBy(xpath = "//div[@class='c-PJLV c-bXbWpx c-bXbWpx-lfylVv-direction-row c-bXbWpx-fMErMJ-justify-left c-bXbWpx-joJbDg-align-center c-bXbWpx-NQWrI-justify-center c-bXbWpx-ijqTEiu-css']/div[2]/a[2]")
	WebElement labTestsElement; // = driver.findElement(By.xpath("//div[@class='c-PJLV c-bXbWpx
								// c-bXbWpx-lfylVv-direction-row c-bXbWpx-fMErMJ-justify-left
								// c-bXbWpx-joJbDg-align-center c-bXbWpx-NQWrI-justify-center
								// c-bXbWpx-ijqTEiu-css']/div[2]/a[2]"));

	// Deliever to Element
	@FindBy(xpath = "//span[@class='_2xei5']")
	WebElement delieverToElement; // = driver.findElement(By.xpath("//span[@class='_2xei5']"));

	// PIN Code
	@FindBy(xpath = "//input[@class='jss27 _9Rsw_ _34quF']")
	WebElement pinCodeElement; // = driver.findElement(By.xpath("//input[@class='jss27 _9Rsw_ _34quF']"));

	// Check Button
	@FindBy(xpath = "//button[@class='_2FE4Z _2Jc-Z _2Jc-Z _10CzH _3LBfS']")
	WebElement checkButtonElement; // = driver.findElement(By.xpath("//button[@class='_2FE4Z _2Jc-Z _2Jc-Z _10CzH
									// _3LBfS']"));

	// Search Bar
	@FindBy(xpath = "//input[@class='jss27 _9Rsw_ undefined _2Saml']")
	WebElement searchBarElement; // = driver.findElement(By.xpath("//input[@class='jss27 _9Rsw_ undefined
									// _2Saml']"));

	// Search Button
	@FindBy(xpath = "//div[@class='_2tdEn _1pXi6 _1gc6o undefined']//*[name()='svg']")
	WebElement searchButtonElement; // = driver.findElement(By.xpath("//div[@class='_2tdEn _1pXi6 _1gc6o
									// undefined']//*[name()='svg']"));

	// Select Button
	@FindBy(xpath = "//button[@class='_2FE4Z _2Jc-Z _1JBjj _5YN3Z _7M65L']")
	WebElement selectButtonElement;// = driver.findElement(By.xpath("//button[@class='_2FE4Z _2Jc-Z _1JBjj _5YN3Z
									// _7M65L']"));

	// Patient Count
	@FindBy(xpath = "//p[.='1 patient']")
	WebElement patientCountElement; // = driver.findElement(By.xpath("//p[.='1 patient']"));

	// View Cart
	@FindBy(xpath = "//div[@class='showDesktop']//button[@class='_2FE4Z _2Jc-Z _2Jc-Z ZHQJn _3LBfS']")
	WebElement viewCartElement; // =
								// driver.findElement(By.xpath("//div[@class='showDesktop']//button[@class='_2FE4Z
								// _2Jc-Z _2Jc-Z ZHQJn _3LBfS']"));

	// Proceed Button
	@FindBy(id = "cart-addPatient-Dweb")
	WebElement proceedElement; // = driver.findElement(By.id("cart-addPatient-Dweb"));

	// Assertions

	// Search Bar Place Holder
	@FindBy(xpath = "//input[@placeholder='Search for Tests/Packages/Labs']")
	WebElement searchBarPlaceHolderElement;

	// Deliver to Location
	@FindBy(xpath = "//div[@class='_2lVBb']")
	WebElement locationHeaderElement;

	// Lab Tests Cart
	@FindBy(xpath = "//div[@class='sc-fcab2434-0 lnGkEC sc-e7824e39-0 jjYcPO']/div[1]/h3")
	WebElement labTestCartElement;

	// Login Page
	@FindBy(xpath = "//div[@class='sc-5d829af0-1 cAcyZn']")
	WebElement loginPageElement;

	// SearchResult
	@FindBy(xpath = "//div[@class='_1NZHk']")
	public WebElement searchResultElement;

	// public String searchResultElementText =
	// searchResultElement.getText().substring(21,41);

	@FindBy(xpath = "//div[@class='_6e3Pw']")
	WebElement patientNumberElement;

	@FindBy(xpath = "//div[@class='_1NZHk']")
	public WebElement searchResultText;

	public PharmeasyPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void labTestsClick() {
		labTestsElement.click();
	}

	public void delieverToClick() {
		delieverToElement.click();
	}

	public void pinCode(String pin) {
		pinCodeElement.sendKeys(pin);
	}

	public void checkButtonClick() {
		checkButtonElement.click();
		;
	}

	public void searchBar(String testName) {
		searchBarElement.sendKeys(testName);
	}

	public void searchButtonClick() {
		searchButtonElement.click();
	}

	public void selectButtonClick() {
		selectButtonElement.click();
	}

	public void patientCountClick() {
		patientCountElement.click();
	}

	public void viewCartClick() {
		viewCartElement.click();
	}

	public void proceedClick() {
		proceedElement.click();
	}

	public boolean isSearchBarPlaceHolderDisplayed() {
		return searchBarPlaceHolderElement.isDisplayed();
	}

	public boolean isLocationHeaderDisplayed() {
		return locationHeaderElement.isDisplayed();
	}

	public boolean isPatientCountDisplayed() {
		return patientNumberElement.isDisplayed();
	}

	public boolean islabTestCartDisplayed() {
		return labTestCartElement.isDisplayed();
	}

	public boolean isLoginPageDisplayed() {
		return loginPageElement.isDisplayed();
	}

}
