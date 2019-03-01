package landingpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsNewJob {
	
	@FindBy(xpath="//*[@id=\"name\"]")
	private WebElement jobName;
	
	@FindBy(xpath="//*[@id=\"j-add-item-type-standalone-projects\"]/ul/li[1]")
	private WebElement freestyle;
	
	@FindBy(xpath="//*[@id=\"ok-button\"]")
	private WebElement button;
	
	public void makeJob(String input) {
		jobName.sendKeys(input);
		freestyle.click();
		button.click();
	}

}
