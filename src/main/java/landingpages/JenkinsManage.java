package landingpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsManage {
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/div[16]/a")
	private WebElement manageUser;
	
	public void users() {
		manageUser.click();
	}
	

}
