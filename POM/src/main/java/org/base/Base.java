package org.base;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base {

	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;

	public static void loadURL(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}

	public static void txtEnter(WebElement element, String text) {
		element.sendKeys(text);
	}

	public static void elementClick(WebElement element) {
		element.click();
	}

	public static void elementClear(WebElement element) {
		element.clear();
	}

	public static String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public static String currentPageUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static void closeCurrentWindow() {
		driver.close();
	}

	public static void closeAllWindow() {
		driver.quit();
	}

	public static String acceptAlert() {
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();
		return alertMessage;
	}

	public static String dismisstAlert() {
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		alert.dismiss();
		return alertMessage;
	}
	
	public static void alertWait() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void report() {
		
		ExtentHtmlReporter html = new ExtentHtmlReporter(System.getProperty("user.dir")+"/src/main/resources/report.html");
		report = new ExtentReports();
		report.attachReporter(html);
	}
}
