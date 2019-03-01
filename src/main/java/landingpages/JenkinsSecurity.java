package landingpages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class JenkinsSecurity {

	@FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement makeUser;

	@FindBys({ 
		@FindBy(tagName = "tbody"), 
		@FindBy(tagName = "tr"), 
		@FindBy(tagName = "td"),
		@FindBy(tagName = "a")})
	private List<WebElement> links;
	
	@FindBys({ 
		@FindBy(tagName = "tbody"), 
		@FindBy(tagName = "tr"), 
		@FindBy(tagName = "td") })
	private List<WebElement> users;

	public void click() {
		makeUser.click();
	}

	public int NoOfUsers() {
		return users.size();
	}
	
	public void checkLinks(String string) {
		for(int i=0;i<links.size();i++) {
			if(links.get(i).getText().equals(string)) {
				links.get(i).click();
				break;
			}
		}
	}

}
