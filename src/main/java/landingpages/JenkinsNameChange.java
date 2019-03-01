package landingpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsNameChange {
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/table/tbody/tr[1]/td[3]/input")
	private WebElement conf;
	
	public void changeName(String string) {
		conf.clear();
		conf.sendKeys(string);
	}
	

	

}
