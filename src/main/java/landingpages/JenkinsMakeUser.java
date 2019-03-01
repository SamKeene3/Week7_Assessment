package landingpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsMakeUser {
	
	@FindBy(xpath="//*[@id=\"username\"]")
	private WebElement user;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement pass;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement passConfirm;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement fullName;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	private WebElement email;
	
	@FindBy(xpath="//*[@id=\"yui-gen1-button\"]")
	private WebElement button;
	
	public void makeUser(String username, String password, String fullname, String emailAddress) {
		user.sendKeys(username);
		pass.sendKeys(password);
		passConfirm.sendKeys(password);
		fullName.sendKeys(fullname);
		email.sendKeys(emailAddress);
		button.click();
	}
	

}
