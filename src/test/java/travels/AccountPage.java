package travels;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {
	private WebDriver driver;
	private Actions action;
	@FindBy (css = "a[href='#profile'")
	WebElement PROFILE_LINK;
	@FindBy (name = "address1")
	WebElement ADDRESS1_TEXTFIELD;
	@FindBy (name = "address2")
	WebElement ADDRESS2_TEXTFIELD;
	@FindBy (name = "city")
	WebElement CITY_TEXTFIELD;
	@FindBy (name = "state")
	WebElement STATE_TEXTFIELD;
	@FindBy (name = "zip")
	WebElement ZIP_TEXTFIELD;
	@FindBy (css = "a[class='chosen-single']")
	WebElement DROPDOWN;
	@FindBy (css = "ul[class='chosen-results']")
	WebElement COUNTRY_DROPDOWN;
	@FindBy (css = "li[class='active-result']")
	List<WebElement> COUNTRY_SELECTED;
	@FindBy (xpath = "//button[@type='submit']")
	WebElement SUBMIT_BTN;
	@FindBy (css = "a[title='home']")
	WebElement HOME_BTN;
	
	AccountPage(WebDriver driver){
		this.driver = driver;
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	public AccountPage clickMyProfile() {
		PROFILE_LINK.click();
		return this;
	}
	public AccountPage enterAddress1(String address) {
		ADDRESS1_TEXTFIELD.sendKeys(address);
		return this;
	}
	public AccountPage enterAddress2(String address) {
		ADDRESS2_TEXTFIELD.sendKeys(address);
		return this;
	}
	public AccountPage enterCity(String city) {
		CITY_TEXTFIELD.sendKeys(city);
		return this;
	}
	public AccountPage enterState(String state) {
		STATE_TEXTFIELD.sendKeys(state);
		return this;
	}
	public AccountPage enterZip(String zip) {
		ZIP_TEXTFIELD.sendKeys(zip);
		return this;
	}
	public AccountPage selectCountry(String country) {
		DROPDOWN.click();
		for(WebElement el:COUNTRY_SELECTED) {
			if(el.getText().equals(country))
					el.click();
		}
		return this;
	}
	public void clickSubmitButton() {
		action.moveToElement(SUBMIT_BTN);
		action.perform();
		SUBMIT_BTN.click();
	}
	public void clickHomeButton() {
		HOME_BTN.click();
	}






}
