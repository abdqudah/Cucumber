package parallel;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.testng.annotations.BeforeTest;

import com.pages.AccountsPage;
import com.pages.PortalDashboardPage;
import com.pages.PortalLoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.DBConTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PortalDashboardPageSteps  {

	private PortalLoginPage loginPage = new PortalLoginPage(DriverFactory.getDriver());
	private PortalDashboardPage  dashboardPage = new PortalDashboardPage(DriverFactory.getDriver());
	public String dashboad_URL;

	private ConfigReader configReader = new ConfigReader();
    Properties prop = configReader.init_prop();
    
   
    
	// = configReader.init_prop();
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) throws SQLException, InterruptedException {

		DriverFactory.getDriver()
		.get(prop.getProperty("URL"));
		
		loginPage.getUserName().sendKeys(credTable.cell(0, 0));
		loginPage.getEstablishmentId().sendKeys(credTable.cell(0, 1));
		loginPage.getPassword().sendKeys(credTable.cell(0, 2));
		loginPage.getLoginButton().click();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		loginPage.getOtp().sendKeys("1234");
		loginPage.getSubmitOtpButton().click();
		Thread.sleep(2000);
	
	}
	
	 @Given("^user is on Dashboard page$")
	    public void user_is_on_Dashboard_page() throws Throwable {

			 dashboad_URL = DriverFactory.getDriver().getCurrentUrl();
			System.out.println("Dashboard Page title is: " + dashboad_URL);

	 }
	 
	 @Then("operation number should be equal {int}")
	    public void operation_number_should_be_equal_something(Integer opertaion) throws Throwable {

		int x= dashboardPage.getProcess().size();
		Assert.assertTrue(x == opertaion);
	 }
	 
	 @Then("header rows should be equal {int}")
	    public void header_rows_should_be_equal_something(Integer rows) throws Throwable {
		 int y = dashboardPage.getHeader().size();

		 Assert.assertTrue(y == rows);
	 }
	 
	 @Then("^Dashboard language should be changed$")
	    public void Dashboard_language_should_be_changed() throws Throwable {
		 
		 assertEquals("Dashboard", dashboardPage.getDashboard().getText());

	 }
	 
	
	 
	/* @Then("^current URL should be contain a Dashboard word$")
	    public void current_url_should_be_contain_a_dashboard_word() throws Throwable {
			assertEquals("http://47.254.24.51:81/Mol/#/dashboard",dashboad_URL);

	    }*/
	 
	 

	 
	 

	

}
