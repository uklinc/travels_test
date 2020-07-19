package travels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelsMainPage {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy (css = "div[class='dropdown dropdown-login dropdown-tab'")
	WebElement MYACCOUNT_MENU;
	@FindBy (css = "a[class='dropdown-item tr'")
	WebElement SIGN_UP_SUBMENU;
	@FindBy (css = "div[class='dropdown dropdown-login dropdown-tab'")
	WebElement MY_MENU;
	@FindBy (css = "a[class='dropdown-item tr'")
	WebElement LOGOUT_SUBMENU;
	@FindBy (css = "a[class='dropdown-item active tr']")
	WebElement LOGIN_SUBMENU;
	@FindBy (css = "button[class='cc-btn cc-dismiss']")
	WebElement COOKIE_BTN;
	
	TravelsMainPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public TravelsMainPage clickSignUpMenu() {
		MYACCOUNT_MENU.click();
		SIGN_UP_SUBMENU.click();
		return this;
	}
	public void clickLogOutMenu() {
		MY_MENU.click();
		LOGOUT_SUBMENU.click();
		//return this;
	}
	public void clickLogInMenu() {
		MYACCOUNT_MENU.click();
		LOGIN_SUBMENU.click();
		//return this;
	}
	public void closeCookie() {
		try {
			wait = new WebDriverWait(driver,2);
			wait.until(ExpectedConditions.visibilityOf(COOKIE_BTN));
			COOKIE_BTN.click();
		}
		catch(Exception e) {
			
		}
	}


}
