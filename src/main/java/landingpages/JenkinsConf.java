package landingpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsConf {
	
	@FindBy(xpath="//*[@id=\"yui-gen38-button\"]")
	private WebElement save;
	
	public void saveConf() {
		save.click();
	}
	
}
