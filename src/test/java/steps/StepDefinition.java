package steps;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.TestBase;

public class StepDefinition extends TestBase {
	LoginPage loginpage;

	@Before
	public void beforeRun() {
		init();
		loginpage = PageFactory.initElements(driver, LoginPage.class);
	}

	@Given("User is on the techfios login page")
	public void user_is_on_the_techfios_login_page() {
		driver.get("https://techfios.com/billing/?ng=admin/");

	}

	@When("User enters the {string} in the {string} field")
	public void user_enters_the_in_the_field(String data, String field) {
		switch (field) {
		case "username":
			loginpage.enterUserneme(data);
			break;
		case "password":
			loginpage.enterPassword(data);

		}

	}

	@Then("User enters {string} in the {string} field in accounts page")
	public void user_enters_in_the_field_in_accounts_page(String data, String field) {
		switch (field) {
		case "accountTitle":
			loginpage.userEnterAccountTitle(data + generateRandomNumber(999));
			break;
		case "description":
			loginpage.userEnterDescription(data);
			break;
		case "initialBalance":
			loginpage.userEnterInitialBalance(data);
			break;
		case "accountNumber":
			loginpage.userEnterAccountNumber(data);
			break;
		case "contactPerson":
			loginpage.userEnterContactPerson(data);
			break;
		case "Phone":
			loginpage.userEnterPhoneNum(data);
			break;
		case "internetBankingURL":
			loginpage.userEnterinternetBankingURL(data);
			break;

		}

	}

	@Then("User should land on Dashboard page")
	public void user_should_land_on_Dashboard_page() {
		loginpage.dashboardHeader();
	}

	@When("User clicks on {string}")
	public void user_clicks_on(String button) {
		switch (button) {
		case "login":
			loginpage.clickOnSignInButton();
			break;
		case "bankCash":
			loginpage.userClickOnBandAndCash();
			break;
		case "newAccount":
			loginpage.userClickOnNewAccount();
			break;
		case "submit":
			loginpage.userClickOnSubmit();
			break;
		}
	}

	@Then("User should be able to validate account created successfully")
	public void user_should_be_able_to_validate_account_created_successfully() {
		takeScreenshot(driver);
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
