package travels;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPanel {
	private WebDriver driver;
	@FindBy (css = "a[data-name='tours']")
	WebElement TOURS_TAB;
	@FindBy (id = "s2id_autogen15")
	WebElement DESTINATION_FIELD;
	@FindBy (css = "div[class='select2-result-label']")
	List<WebElement> DESTINATION_CITIES;
	@FindBy (id = "tourtype_chosen")
	WebElement TOUR_TYPE_FIELD;
	@FindBy (css = "li[class='active-result']")
	List<WebElement> TYPE_LIST;
	@FindBy (id = "DateTours")
	WebElement DATE_TOUR_FIELD;
	@FindBy (name = "adults")
	WebElement ADULTS_FIELD;
	@FindBy (xpath = "//*[@id=\"tours\"]/div/div/form/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div[2]/div/span/button[1]")
	WebElement PLUS_GUEST_BTN;
	@FindBy (xpath = "//*[@id=\"tours\"]/div/div/form/div/div/div[4]/button")
	WebElement SEARCH_BTN;
	
	SearchPanel(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public SearchPanel clickToursTab() {
		TOURS_TAB.click();
		return this;
	}
	public SearchPanel selectDestination(String destination) {
		DESTINATION_FIELD.click();
		for(WebElement el:DESTINATION_CITIES) {
			if(el.getText().equals(destination))
				el.click();
		}
		return this;
	}
	public SearchPanel selectTourType(String type) {
		TOUR_TYPE_FIELD.click();
		for(WebElement el:TYPE_LIST) {
			if(el.getText().equals(type))
				el.click();
		}
		return this;
	}
	public SearchPanel selectDate(String date) {
		DATE_TOUR_FIELD.clear();
		DATE_TOUR_FIELD.sendKeys(date);
		return this;
	}
	public SearchPanel changeAdults(String adultsNumber) {
		for(int i=0; i<Integer.parseInt(adultsNumber)-1;i++)
			PLUS_GUEST_BTN.click();
		return this;
	}
	public ToursPage clickSearchButton() {
		SEARCH_BTN.click();
		return new ToursPage(driver);
	}

}
