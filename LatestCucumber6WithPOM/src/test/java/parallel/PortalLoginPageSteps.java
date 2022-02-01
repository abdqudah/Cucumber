package parallel;

import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.pages.PortalLoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.RestClient;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PortalLoginPageSteps {

	private static String title;
	private PortalLoginPage loginPage = new PortalLoginPage(DriverFactory.getDriver());
	WebDriver driver;

	RestClient restClient;
	CloseableHttpResponse closeableHttpResponse;
	String serivceUrl;
	String apiUrl;
	String url;

	private ConfigReader configReader = new ConfigReader();
	Properties prop = configReader.init_prop();

	@Given("user is on login page")
	public void user_is_on_login_page() throws ClientProtocolException, IOException {

		DriverFactory.getDriver().get("http://47.254.24.51:81/Mol/#/login\r\n" + "\r\n" + "");

		/*
		 * serivceUrl = prop.getProperty("WebserviceURL"); apiUrl =
		 * prop.getProperty("serviceURL"); url = serivceUrl + apiUrl;
		 * 
		 * restClient = new RestClient(); closeableHttpResponse = restClient.get(url);
		 * 
		 * int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		 * System.out.println(statusCode);
		 */

	}

	@When("^user gets the title of the page$")
	public void user_gets_the_title_of_the_page() throws Throwable {
		title = DriverFactory.getDriver().getTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("^page title should be \"([^\"]*)\"$")
	public void page_title_should_be_something(String Title) throws Throwable {
		Assert.assertTrue(title.contains(Title));

	}

	@Then("^forgot your password link should be displayed$")
	public void forgot_your_password_link_should_be_displayed() throws Throwable {

		Assert.assertTrue(loginPage.getForgotPassword().isDisplayed());

	}

	@When("^user enters username \"([^\"]*)\"$")
	public void user_enters_username_something(String username) throws Throwable {
		loginPage.getUserName().sendKeys(username);
	}

	@And("^user enters estimtated \"([^\"]*)\"$")
	public void user_enters_estimtated_something(String estimtated) throws Throwable {
		
		loginPage.getEstablishmentId().sendKeys(estimtated);
	}

	@And("^user enters password \"([^\"]*)\"$")
	public void user_enters_password_something(String password) throws Throwable {
		loginPage.getPassword().sendKeys(password);
	}

	@And("^user clicks on Login button$")
	public void user_clicks_on_login_button() throws Throwable {
		
		loginPage.getLoginButton().click();
	}
	
	@And("^system should be wait 10 second$")
	    public void system_should_be_wait() throws Throwable {

		 DriverFactory.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	 }
	
	 @And("^user enters a valid otp \"([^\"]*)\" and click on submit$")
	    public void user_enters_a_valid_otp_something_and_click_on_submit(String otp) throws Throwable {

		 loginPage.getOtp().sendKeys(otp);
		 loginPage.getSubmitOtpButton().click();
	 }

	@Then("^account name should be displayed$")
	public void account_name_should_be_displayed() throws Throwable {
		Assert.assertTrue(loginPage.getAccountName().isDisplayed());

	}
	
	@Then("^portal language should be changed$")
    public void portal_language_should_be_changed() throws Throwable {
        Assert.assertEquals("Password", loginPage.getPasswordLabel().getText());
    }

    @And("^user click on English button$")
    public void user_click_on_english_button() throws Throwable {
        loginPage.getEnglishButton().click();
    }
    
    @Then("^error message should be displayed as a toast message$")
    public void error_message_should_be_displayed_as_a_toast_message() throws Throwable {

    	Assert.assertTrue(loginPage.getErrorToastMessage().isDisplayed());
    
    }
    
    @Then("^user should be redircted to main login page$")
    public void user_should_be_redircted_to_main_login_page() throws Throwable {

    	Assert.assertTrue(loginPage.getUserNameLabel().isDisplayed());
    }

    @And("^user clicks on back to login page link$")
    public void user_clicks_on_back_to_login_page_link() throws Throwable {

    	loginPage.getBackToLoginPageLink().click();
    }
    
    @And("^user clicks on the logout button$")
    public void user_clicks_on_the_logout_button() throws Throwable {

    loginPage.getLogout().click();
    }
    
   


}
