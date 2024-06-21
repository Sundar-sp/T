package test;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pom.SignUpPage;

public class TestCase_SignUp extends SignUpPage {

	@Test(priority = 0)
	public void testCase001() {
		signUp("hewldujo2w78", "test");
		Assert.assertEquals(acceptAlert(), "Sign up successful.");
		test.log(Status.PASS, "Sign up successfully");
		report.flush();
	}

	@Test(priority = 1)
	public void testCase002() {
		closeSignUpWithCredentials("hello987128", "test");
	}

	@Test(priority = 2)
	public void testCase003() {
		closeSignUpWithoutCredentials();
	}

	@Test(priority = 3)
	public void testCase004() throws InterruptedException {
		signUp("hello987128", "test");
	}

}
