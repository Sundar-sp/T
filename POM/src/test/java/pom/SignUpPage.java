package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import test.BaseTest;

public class SignUpPage extends BaseTest {

	@FindBy(id = "signin2")
	public static WebElement homeSignUp;

	@FindBy(id = "sign-username")
	public static WebElement userName;

	@FindBy(id = "sign-password")
	public static WebElement password;

	@FindBy(xpath = "//button[text()='Sign up']")
	public static WebElement clickSignUpBtn;

	@FindBy(xpath = "(//button[text()='Close'])[2]")
	public static WebElement clickCloseBtn;

	public void signUp(String userName, String password) {
		elementClick(homeSignUp);
		txtEnter(SignUpPage.userName, userName);
		txtEnter(SignUpPage.password, password);
		elementClick(clickSignUpBtn);
		alertWait();
	}

	public void closeSignUpWithoutCredentials() {
		elementClick(homeSignUp);
		elementClick(clickCloseBtn);
	}

	public void closeSignUpWithCredentials(String userName, String password) {
		elementClick(homeSignUp);
		txtEnter(SignUpPage.userName, userName);
		txtEnter(SignUpPage.password, password);
		elementClick(clickCloseBtn);
	}

}
