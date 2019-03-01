package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import landingpages.JenkinsLogin;
import landingpages.JenkinsNameChange;
import landingpages.JenkinsSecurity;
import landingpages.JenkinsUserConf;

public class StepDefinition {
	ChromeDriver driver;
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) {
		System.setProperty(Constants.DriverSetUp1, Constants.DriverSetUp2);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get(Constants.Jenkins);
		JenkinsLogin login = PageFactory.initElements(driver, JenkinsLogin.class);
		login.login(Constants.Username);
		driver.get(Constants.JenkinsUsers);
	}

	@Given("^the username is present \"([^\"]*)\"$")
	public void the_username_is_present(String arg1) throws Throwable {
		
	    
	}

	@When("^I click on username \"([^\"]*)\"$")
	public void i_click_on_username(String arg1) throws Throwable {
		driver.get(Constants.JenkinsLink);
		Thread.sleep(1500);
	}

	@When("^I click on configure link$")
	public void i_click_on_configure_link() throws Throwable {
		JenkinsUserConf conf = PageFactory.initElements(driver, JenkinsUserConf.class);
		conf.configure();
	}

	@When("^change the current fullname to new a new fullname \"([^\"]*)\"$")
	public void change_the_current_fullname_to_new_a_new_fullname(String arg1) throws Throwable {
		JenkinsNameChange conf = PageFactory.initElements(driver, JenkinsNameChange.class);
		conf.changeName(arg1);
	}

	@When("^I click save button$")
	public void i_click_save_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I click on People link$")
	public void i_click_on_People_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the new fullname \"([^\"]*)\" should be visible for the username \"([^\"]*)\"$")
	public void the_new_fullname_should_be_visible_for_the_username(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
