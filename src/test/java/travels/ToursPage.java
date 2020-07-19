package travels;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToursPage {
	private WebDriver driver;
	//@FindBy (xpath = "a[contains(text(), 'Details')]")
	@FindBy (css = "a[class='btn btn-primary btn-sm btn-wide']")
	List<WebElement> DETAIL_BTN;
	
	ToursPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public TourDetails clickDetailsButton() {
		DETAIL_BTN.get(0).click();
		return new TourDetails(driver);
	}
	

}
