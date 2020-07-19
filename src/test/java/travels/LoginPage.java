package travels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	@FindBy (name = "username")
	WebElement USERNAME_TEXTFIELD;
	@FindBy (name = "password")
	WebElement PASSWORD_TEXTFIELD;
	@FindBy (xpath = "//button[@class='btn btn-primary btn-lg btn-block loginbtn'][.='Login']")
	WebElement LOGIN_BTN;
	
	LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public LoginPage enterUserName(String userName) {
		USERNAME_TEXTFIELD.clear();
		USERNAME_TEXTFIELD.sendKeys(userName);
		return this;
	}
	public LoginPage enterPassword(String password) {
		PASSWORD_TEXTFIELD.clear();
		PASSWORD_TEXTFIELD.sendKeys(password);
		return this;
	}
	public void clickLoginButton() {
		LOGIN_BTN.click();
	}
	

}
