package test;

import org.testng.annotations.Test;

import pom.LoginPage;

public class TestCase_Login extends LoginPage {

	@Test(priority = 0)
	public void testCase001() {
		logIn("hello987128", "test");
	}

	@Test(priority = 1)
	public void testCase002() {
		closeLoginWithCredentials("hello987128", "test");
	}

	@Test(priority = 2)
	public void testCase003() {
		closeLoginWithoutCredentials();
	}

	@Test(priority = 3)
	public void testCase004() throws InterruptedException {
		loginWithWrongCredentials("yglt", "75suh");
	}

}
