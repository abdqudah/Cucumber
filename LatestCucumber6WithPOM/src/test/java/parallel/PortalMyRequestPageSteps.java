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
import com.pages.PortalMyRequestPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.DBConTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PortalMyRequestPageSteps  {

	//private PortalLoginPage loginPage = new PortalLoginPage(DriverFactory.getDriver());
	//private PortalDashboardPage  dashboardPage = new PortalDashboardPage(DriverFactory.getDriver());
	private PortalMyRequestPage myRequest= new PortalMyRequestPage(DriverFactory.getDriver());
	public String myRequest_URL;

	private ConfigReader configReader = new ConfigReader();
    Properties prop = configReader.init_prop();
    
   
    
	// = configReader.init_prop();
	
	 
    @And("^user clicks on my request tab$")
    public void user_clicks_on_my_request_tab() throws Throwable {

    	myRequest.getMyRequest().click();
    
    }
    
    
    @Then("^current URL should be \"([^\"]*)\"$")
    public void current_url_should_be_something(String requestURL) throws Throwable {
    	myRequest_URL = DriverFactory.getDriver().getCurrentUrl();
		Assert.assertTrue(myRequest_URL.contains(requestURL));

    }


	 
	 

	

}
