package landingpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsJobBoard {
	
	@FindBy(xpath="//*[@id=\"tasks\"]/div[1]/a[2]")
	private WebElement dashReturn;
	
	public void returnToDashboard() {
		dashReturn.click();
	}
	

}
