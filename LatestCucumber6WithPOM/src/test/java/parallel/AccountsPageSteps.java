package parallel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.testng.annotations.BeforeTest;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.DBConTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps  {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage = new AccountsPage(DriverFactory.getDriver());

	private ConfigReader configReader = new ConfigReader();
    Properties prop = configReader.init_prop();
    
   
    
	// = configReader.init_prop();
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) throws SQLException {

		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver()
				.get(prop.getProperty("URL"));
		//accountsPage = loginPage.doLogin(userName, password);
		loginPage.doLogin(userName, password);
		
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() throws SQLException {
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Accounts Page title is: " + title);
		
		DBConTest re = new DBConTest();
		Connection con = re.DBConnect();
		
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT * from utl_general_lookups where LK_ID='3'");

			while (rs.next()) {
				System.out.println(rs.getString("LK_ID"));
				// System.out.println(rs.getString("NAME_AR"));

			}		
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {

		List<String> expAccountSectionsList = sectionsTable.asList();
		
		System.out.println("Expected accounts section list: " + expAccountSectionsList);

		List<String> actualAccountSectionsList = accountsPage.getAccountsSectionsList();
		System.out.println("Actual accounts section list: " + actualAccountSectionsList);

		Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));
		

	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
	}

}
