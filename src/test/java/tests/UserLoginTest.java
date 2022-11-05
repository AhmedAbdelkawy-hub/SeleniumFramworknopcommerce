package tests;

import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LogoutPage;
import pages.UserLoginpage;
import pages.UserRegistrationPage;

import java.io.IOException;

public class UserLoginTest extends TestPase {
	private HomePage homePageobject;
	private UserLoginpage userLoginobject;
	private LogoutPage logoutobject;
	
	// Tests
	@Test (priority = 0)
	public void OpenLoginPage() {
		homePageobject = new HomePage(driver);
		homePageobject.ClickLoginLink();
		userLoginobject = new UserLoginpage(driver);
		Assert.assertTrue(userLoginobject.IsLoginBtnDisplay());
		
	}
	@Test(priority = 1)
	public void  AssertUserCanLogin() throws IOException, ParseException {
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();
		homePageobject = new HomePage(driver);
		homePageobject.ClickLoginLink();
		userLoginobject = new UserLoginpage(driver);
		logoutobject = new LogoutPage(driver);
		userLoginobject.UserLogin(jsonReader.Email,jsonReader.Password);
		Assert.assertTrue(logoutobject.IslogoutBtnIsDisplay());
		
	}

}
