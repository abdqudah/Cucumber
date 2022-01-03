package parallel;

import java.io.IOException;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.Assert;
import org.junit.Before;
import org.testng.annotations.BeforeTest;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.RestClient;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	
	RestClient restClient;
    CloseableHttpResponse closeableHttpResponse ;
    String serivceUrl;
   	String apiUrl;
    String url;
    
    private ConfigReader configReader = new ConfigReader();
    Properties prop = configReader.init_prop();
    
    

	
	@Given("user is on login page")
	public void user_is_on_login_page() throws ClientProtocolException, IOException  {

		DriverFactory.getDriver()
				.get("http://47.254.24.51:81/Mol/#/login\r\n"
						+ "\r\n"
						+ "");
		
		
		serivceUrl = prop.getProperty("WebserviceURL");
		apiUrl = prop.getProperty("serviceURL");
		url = serivceUrl + apiUrl;
		
		restClient = new RestClient();
		closeableHttpResponse = restClient.get(url);
		
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		
		
		
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}


}
