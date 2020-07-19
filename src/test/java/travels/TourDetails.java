package travels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TourDetails {
	private WebDriver driver;
	private Actions actions;
	@FindBy (name = "date")
	WebElement DATE_TEXTFIELD;
	@FindBy (id = "selectedAdults")
	WebElement ADULTS_DROPDOWN;
	@FindBy (id = "selectedChild")
	WebElement CHILDREN_DROPDOWN;
	@FindBy (css = "button[class='btn btn-secondary btn-block mt-20 btn-action btn-lg loader']")
	//@FindBy (xpath = "/html/body/div[1]/div/div/div[1]/div[4]/div/div[1]/aside/div/form/div/form/button")
	WebElement BOOK_BTN;
	
	TourDetails(WebDriver driver){
		this.driver = driver;
		actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	public TourDetails changeDate(String date) {
		DATE_TEXTFIELD.clear();
		DATE_TEXTFIELD.sendKeys(date);
		return this;
	}
	public TourDetails selectAdults(String number) {
		new Select(ADULTS_DROPDOWN).selectByValue(number);
		return this;
	}
	public TourDetails selectChildren(String number) {
		new Select(CHILDREN_DROPDOWN).selectByValue(number);
		return this;
	}
	public BookingPage clickBookButton() {
		actions.moveToElement(BOOK_BTN);
		actions.perform();
		BOOK_BTN.click();
		return new BookingPage(driver);
	}


}
