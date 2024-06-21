package test;

import java.lang.reflect.Method;

import org.base.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;

import pom.LoginPage;
import pom.SignUpPage;

public class BaseTest extends Base {
	@BeforeTest
	public void reportInit() {
		report();
	}
	@AfterMethod
	public void closeBrowser() {
		report.flush();
		
		closeAllWindow();
	}

	@BeforeMethod
	public void Openurl(Method m) {
		loadURL("https://www.demoblaze.com/");
		String method= m.getName();
		test=report.createTest(method);
		PageFactory.initElements(driver, SignUpPage.class);
		PageFactory.initElements(driver, LoginPage.class);
		test.log(Status.INFO, "Web page open successfully");
	}
}
