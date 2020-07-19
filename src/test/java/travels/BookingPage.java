package travels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage {
	private WebDriver driver;
	private Actions actions;
	
	@FindBy (xpath = "//table/tbody/tr[3]/td[4]")
	WebElement TRAVEL_INSURANCE_CHECKBOX;
	@FindBy (xpath = "//table/tbody/tr[4]/td[4]")
	WebElement AIRPORT_PICKUP_CHECKBOX;
	WebElement GUEST_NAME_TEXTFIELD;
	WebElement PASSPORT_NUMBER_TEXTFIELD;
	WebElement AGE_TEXTFIELD;
	@FindBy (css = "div[class='form-group'")
	WebElement CONFIRM_BTN;
	@FindBy (css = "button[class='btn btn-default arrivalpay'")
	WebElement PAY_ON_ARRIVAL_BTN;
	
	
	BookingPage(WebDriver driver){
		this.driver = driver;
		actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	public BookingPage clickOnTravelInsurance() {
		TRAVEL_INSURANCE_CHECKBOX.click();
		return this;
	}
	public BookingPage clickOnAirpportPickUp() {
		AIRPORT_PICKUP_CHECKBOX.click();
		return this;
	}
	public BookingPage enterGuestName(int number, String name) {
		GUEST_NAME_TEXTFIELD = driver.findElement(By.name("passport[" + number +"][name]"));
		GUEST_NAME_TEXTFIELD.sendKeys(name);
		return this;
	}
	public BookingPage enterGuestPassport(int number, String passportNum) {
		PASSPORT_NUMBER_TEXTFIELD = driver.findElement(By.name("passport[" + number +"][passportnumber]"));
		PASSPORT_NUMBER_TEXTFIELD.sendKeys(passportNum);
		return this;
	}
	public BookingPage enterAge(int number, String age) {
		AGE_TEXTFIELD = driver.findElement(By.name("passport[" + number +"][age]"));
		AGE_TEXTFIELD.sendKeys(age);
		return this;
	}
	public BookingPage clickConfirmButton() {
		CONFIRM_BTN.click();
		return this;
	}
	public void clickPayonArrival() {
		PAY_ON_ARRIVAL_BTN.click();
	}

}
