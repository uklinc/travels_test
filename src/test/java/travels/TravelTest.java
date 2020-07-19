package travels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TravelTest {
	private WebDriver driver;	
	private Properties prop;
	
	@BeforeMethod
	  public void prepareChromeTest() throws FileNotFoundException, IOException {
		//System.setProperty("webdriver.chrome.driver","C:/test/chromedriver.exe");
		prop = new Properties();
		prop.load(getClass().getClassLoader().getResourceAsStream("data.properties"));
		driver = new ChromeDriver();
		driver.get(prop.getProperty("baseUrl"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	  }
	@AfterMethod
	public void closeTest() {
		driver.quit();
	}
	@Test(enabled = true, priority = 1)
	public void createAccount() {
		new TravelsMainPage(driver)
			.clickSignUpMenu();
		new TravelsMainPage(driver)
			.closeCookie();
		new RegisterPage(driver)
			.enterFirstName(prop.getProperty("firstName"))
			.enterLastName(prop.getProperty("lastName"))
			.enterPhone(prop.getProperty("phone"))
			.enterEmail(prop.getProperty("email"))
			.enterPassword(prop.getProperty("password"))
			.enterConfirmedPassword(prop.getProperty("password"))
			.clickSignUpButton();
		new TravelsMainPage(driver)
			.clickSignUpMenu();
	}
	@Test(enabled = true, priority = 2)
	public void fillMyProfilTest() {
		this.login();
		this.closeCookieMessage();
		new AccountPage(driver)
			.clickMyProfile()
			.enterAddress1(prop.getProperty("address1"))
			.enterAddress2(prop.getProperty("address2"))
			.enterCity(prop.getProperty("city"))
			.enterState(prop.getProperty("state"))
			.selectCountry(prop.getProperty("country"))
			.enterZip(prop.getProperty("zip"))
			.clickSubmitButton();
		
	}
	@Test(enabled = true, priority = 3)
	public void buyTripTest() {
		this.login();
		new AccountPage(driver)
			.clickHomeButton();
		new SearchPanel(driver)
			.clickToursTab()
			.selectDestination(prop.getProperty("destination"))
			.selectTourType(prop.getProperty("tourType"))
			.selectDate(prop.getProperty("date"))
			.changeAdults(prop.getProperty("adultsNumber"))
			.clickSearchButton()
			
			.clickDetailsButton();
		this.closeCookieMessage();
		new TourDetails(driver)	
			.changeDate(prop.getProperty("date"))
			.selectAdults(prop.getProperty("adultsNumber"))
			.selectChildren(prop.getProperty("childrenNumber"))
			.clickBookButton();
			
		this.closeCookieMessage();
		new BookingPage(driver)
			.clickOnTravelInsurance()
			.clickOnAirpportPickUp()
			.enterGuestName(1, prop.getProperty("guestName1"))
			.enterGuestPassport(1,prop.getProperty("passportNumber1"))
			.enterAge(1, prop.getProperty("age1"))
			.enterGuestName(2, prop.getProperty("guestName2"))
			.enterGuestPassport(2, prop.getProperty("passportNumber2"))
			.enterAge(2, prop.getProperty("age2"))
			.enterGuestName(3, prop.getProperty("guestName3"))
			.enterGuestPassport(3, prop.getProperty("passportNumber3"))
			.enterAge(3, prop.getProperty("age3"))
			
			.clickConfirmButton()
			.clickPayonArrival();
		
		driver.switchTo().alert().accept();
		
	}
	
	
	private void login() {
		new TravelsMainPage(driver)
			.clickLogInMenu();
		new LoginPage(driver)
			.enterUserName(prop.getProperty("email"))
			.enterPassword(prop.getProperty("password"))
			.clickLoginButton();
		new TravelsMainPage(driver)
			.closeCookie();
	}
	private void closeCookieMessage() {
		new TravelsMainPage(driver)
			.closeCookie();
	}

}
