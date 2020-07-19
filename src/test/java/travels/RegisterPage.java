package travels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	private WebDriver driver;
	@FindBy (name = "firstname")
	WebElement FIRSTNAME_TEXTFIELD;
	@FindBy (name = "lastname")
	WebElement LASTNAME_TEXTFIELD;
	@FindBy (name = "phone")
	WebElement PHONE_TEXTFIELD;
	@FindBy (name = "email")
	WebElement EMAIL_TEXTFIELD;
	@FindBy (name = "password")
	WebElement PASSWORD_TEXTFIELD;
	@FindBy (name = "confirmpassword")
	WebElement CONFIRMPASSWORD_TEXTFIELD;
	@FindBy (css = "button[class='signupbtn btn_full btn btn-success btn-block btn-lg']")
	WebElement SIGN_UP_BTN;
	
	RegisterPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public RegisterPage enterFirstName(String firstName) {
		FIRSTNAME_TEXTFIELD.clear();
		FIRSTNAME_TEXTFIELD.sendKeys(firstName);
		return this;
	}
	public RegisterPage enterLastName(String lastName) {
		LASTNAME_TEXTFIELD.clear();
		LASTNAME_TEXTFIELD.sendKeys(lastName);
		return this;
	}
	public RegisterPage enterPhone(String phone) {
		PHONE_TEXTFIELD.clear();
		PHONE_TEXTFIELD.sendKeys(phone);
		return this;
	}
	public RegisterPage enterEmail(String email) {
		EMAIL_TEXTFIELD.clear();
		EMAIL_TEXTFIELD.sendKeys(email);
		return this;
	}
	public RegisterPage enterPassword(String password) {
		PASSWORD_TEXTFIELD.clear();
		PASSWORD_TEXTFIELD.sendKeys(password);
		return this;
	}
	public RegisterPage enterConfirmedPassword(String confirmPassword) {
		CONFIRMPASSWORD_TEXTFIELD.clear();
		CONFIRMPASSWORD_TEXTFIELD.sendKeys(confirmPassword);
		return this;
	}
	public void clickSignUpButton() {
		SIGN_UP_BTN.click();
	}
	

}
