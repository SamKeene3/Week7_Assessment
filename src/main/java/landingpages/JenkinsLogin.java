package landingpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsLogin {
	
@FindBy(xpath="//*[@id=\"j_username\"]")
private WebElement login;

@FindBy(xpath="/html/body/div/div/form/div[2]/input")
private WebElement pass;

@FindBy(xpath="/html/body/div/div/form/div[3]/input")
private WebElement submit;

public void login(String input) {
	login.sendKeys(input);
	pass.sendKeys(input);
	submit.click();
}


}
