package tests;

import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;
import pages.LogoutPage;
import pages.ProductEmailToFriendPage;
import pages.SearchResultProductDetailsPage;
import pages.UserLoginpage;
import pages.UserRegistrationPage;

import java.io.IOException;

public class EmailProductToFriendTest extends TestPase{
	private HomePage HomePageobject;
	private ProductEmailToFriendPage ProductEmailToFriendPageobject;
	private SearchResultProductDetailsPage SearchResultProductDetailsPageobject;
	private UserLoginpage UserLoginPageobject;
	// variable
	String ProductName = "Apple MacBook Pro 13-inch"; 
//	private String friendEmail = "elkawy1@gmail.com";
//	private String yourEmail = "ali@gmail.com";
//	private String message = "test";
//	private String SuccessMessag = "Your message has been sent";
//	private String email = "ali@gmail.com";
	
	//Tests
	@Test
	  public void UsercanSendEmailProduct() throws IOException, ParseException {
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();
		UserLoginPageobject = new UserLoginpage(driver);
		HomePageobject = new HomePage(driver);
		SearchResultProductDetailsPageobject = new SearchResultProductDetailsPage(driver); 
	    ProductEmailToFriendPageobject = new ProductEmailToFriendPage(driver);
		HomePageobject.ProductSearchUsingAutomaSuggest(ProductName );
		UserLoginPageobject = new UserLoginpage(driver);
		HomePageobject = new HomePage(driver);
	     HomePageobject.ClickLoginLink();
		 UserLoginPageobject.UserLogin(jsonReader.Email,jsonReader.Password);
		SearchResultProductDetailsPageobject.ClickEmailAFriend();
		ProductEmailToFriendPageobject.SendProductToEmailFriend(jsonReader.FriendEmail,jsonReader.YourEmail, jsonReader.Message);
		Assert.assertTrue(ProductEmailToFriendPageobject.GetSuccessMessage().contains(jsonReader.SuccessMessag));
	}

}
