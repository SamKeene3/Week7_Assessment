package tests;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import landingpages.JenkinsConf;
import landingpages.JenkinsHome;
import landingpages.JenkinsJobBoard;
import landingpages.JenkinsLogin;
import landingpages.JenkinsMakeUser;
import landingpages.JenkinsManage;
import landingpages.JenkinsNewJob;
import landingpages.JenkinsSecurity;

@RunWith(Parameterized.class)
public class TaskTwoTest {

	@Parameters
	public static Collection<Object[]> data() throws Exception {
		FileInputStream file = new FileInputStream(Constants.EXCEL);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		Object[][] ob = new Object[sheet.getPhysicalNumberOfRows() - 1][5];

		for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
			for (int colNum = 0; colNum < 5; colNum++) {

				ob[rowNum - 1][colNum] = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

			}

		}
		return Arrays.asList(ob);

	}

	private String username;
	private String fName;
	private String pass;
	private String passConfirm;
	private String email;

	public TaskTwoTest(String username, String fName, String pass, String passConfirm, String email) {
		this.email = email;
		this.fName = fName;
		this.username = username;
		this.pass = pass;
		this.passConfirm = passConfirm;
	}

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
	public void TaskTwo() throws Exception {
		driver.manage().window().maximize();
		driver.get(Constants.Jenkins);
		JenkinsLogin login = PageFactory.initElements(driver, JenkinsLogin.class);
		login.login(Constants.Username);
		JenkinsHome home = PageFactory.initElements(driver, JenkinsHome.class);
		home.goToManage();
		JenkinsManage manage = PageFactory.initElements(driver, JenkinsManage.class);
		manage.users();
		JenkinsSecurity users = PageFactory.initElements(driver, JenkinsSecurity.class);
		users.click();
		JenkinsMakeUser make = PageFactory.initElements(driver, JenkinsMakeUser.class);
		make.makeUser(username, pass, fName, email);
		Thread.sleep(1000);
		assertEquals(true, users.NoOfUsers() > 4); //can't identify new users by x-path so am using no of table rows instead 

	}

}
