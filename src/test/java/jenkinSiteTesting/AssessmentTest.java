package jenkinSiteTesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import landingpages.JenkinsConf;
import landingpages.JenkinsHome;
import landingpages.JenkinsJobBoard;
import landingpages.JenkinsLogin;
import landingpages.JenkinsNewJob;

public class AssessmentTest {
	
	private String pass = "admin";
	private String jobName = "AutomatedTest";
	
	ChromeDriver driver;
	@Before
	public void setup() {
		System.setProperty(Constants.DriverSetUp1, Constants.DriverSetUp2);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
	}

	@After
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void TaskOne() throws Exception {
		driver.manage().window().maximize();
		driver.get(Constants.Jenkins);
		JenkinsLogin login = PageFactory.initElements(driver, JenkinsLogin.class);
		login.login(pass);
		JenkinsHome home = PageFactory.initElements(driver, JenkinsHome.class);
		home.newItem();
		JenkinsNewJob job = PageFactory.initElements(driver, JenkinsNewJob.class);
		job.makeJob(jobName);
		Thread.sleep(1000);
		JenkinsConf conf = PageFactory.initElements(driver, JenkinsConf.class);
		conf.saveConf();
		JenkinsJobBoard jb = PageFactory.initElements(driver, JenkinsJobBoard.class);
		jb.returnToDashboard();
		assertEquals(jobName,home.checkFirstJob());
		
		
	}
	
}
