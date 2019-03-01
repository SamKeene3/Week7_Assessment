package landingpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//http://35.242.186.40:8080/

public class JenkinsHome {
	
	@FindBy(xpath="//*[@id=\"tasks\"]/div[1]/a[2]")
	private WebElement newItem;
	
	@FindBy(xpath="//*[@id=\"job_AutomatedTest\"]/td[3]/a")
	private WebElement firstJob;
	
	@FindBy(xpath="//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement manage;
	
	
	
	public void newItem() {
		newItem.click();
	}
	
	public String checkFirstJob() {
		return firstJob.getText();
	}
	
	public void goToManage() {
		manage.click();
	}
	

}
