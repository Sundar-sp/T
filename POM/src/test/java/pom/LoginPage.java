package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(id = "login2")
	public static WebElement login;

	@FindBy(id = "loginusername")
	public static WebElement userName;

	@FindBy(id = "loginpassword")
	public static WebElement password;

	@FindBy(xpath = "//button[text()='Log in']")
	public static WebElement loginBtn;

	@FindBy(xpath = "(//button[text()='Close'])[3]")
	public static WebElement closeBtn;

	public void logIn(String userName, String password) {
		elementClick(login);
		txtEnter(LoginPage.userName, userName);
		txtEnter(LoginPage.password, password);
		elementClick(loginBtn);
	}

	public void loginWithWrongCredentials(String userName, String password) throws InterruptedException {
		elementClick(login);
		txtEnter(LoginPage.userName, userName);
		txtEnter(LoginPage.password, password);
		elementClick(loginBtn);
		Thread.sleep(2000);
		acceptAlert();
	}

	public void closeLoginWithoutCredentials() {
		elementClick(login);
		elementClick(closeBtn);
	}

	public void closeLoginWithCredentials(String userName, String password) {
		elementClick(login);
		txtEnter(LoginPage.userName, userName);
		txtEnter(LoginPage.password, password);
		elementClick(closeBtn);
	}

}
