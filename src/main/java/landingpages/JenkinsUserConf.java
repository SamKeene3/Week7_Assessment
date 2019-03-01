package landingpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsUserConf {
	
	@FindBy(xpath="//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement conf;
	
	public void configure() {
		conf.click();
	}
	

}
