package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelocityHomePage extends BasePage{

	@FindBy (id="tab-flight-tab-hp")
	WebElement buttonFlight;
	@FindBy (id = "flight-type-roundtrip-label-hp-flight")
	WebElement buttonRoundTrip;
	@FindBy(id="fhc-fhc-hp-package")
	WebElement buttonflHoCa;
	@FindBy(id="tab-hotel-tab-hp")
	WebElement buttonHotel;
	@FindBy(id="tab-cruise-tab-hp")
	WebElement buttonCruise;
	@FindBy (id = "flight-origin-hp-flight")
	WebElement textInFrom;
	@FindBy (id="flight-destination-hp-flight")
	WebElement textInTo;
	@FindBy(id="package-origin-hp-package")
	WebElement textInFromFlHotel;
	@FindBy(id="package-destination-hp-package")
	WebElement textInToFlHotel;
	@FindBy(id="hotel-destination-hp-hotel")
	WebElement textInGoingTo;

	
	@FindBy(id = "package-departing-hp-package")
	WebElement inputDateFromFlHo;
	@FindBy(id= "package-returning-hp-package")
	WebElement inputDateToFlHo;
	@FindBy (id = "flight-departing-hp-flight")
	WebElement inputDateFrom;
	@FindBy(className="datepicker-cal-weeks")
	WebElement tableWeeks;
	@FindBy(className="datepicker-cal-dates")
	WebElement tableDates;
	@FindBy (xpath = "datepicker-paging datepicker-prev btn-paging btn-secondary prev")
	WebElement inputDateFromButtonPrev;
	@FindBy (xpath = "//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")
	WebElement inputDateFromButtonNext;
	@FindBy (id = "flight-returning-hp-flight")
	WebElement inputDateTo;
	@FindBy(id="package-checkin-hp-package")
	WebElement inputDateCheckIn;
	@FindBy(id="package-checkout-hp-package")
	WebElement inputDateCheckOut;
	
	@FindBy (xpath = "//*[@id=\"typeaheadDataPlain\"]")
	WebElement dropDownULFrom;
	@FindBy(xpath ="//*[@id=\"aria-option-0\"]")
	WebElement suggestFirst;
	@FindBy(id="search-button-hp-package")
	WebElement buttonSearch;	
	@FindBy(id="tab-package-tab-hp")
	WebElement buttonFlightHotel;
	@FindBy(css="div.cols-nested:nth-child(11) > label:nth-child(1) > button:nth-child(1)")
	WebElement buttonSearchHotel;
	
	@FindBy(id="partialHotelBooking-hp-package")
	WebElement checkPartialHotel;
	
	@FindBy(partialLinkText="Your partial check-in and check-out dates must fall within your arrival")
	WebElement containerErrorMessage;
	
	private List<WebElement> columns=null;

		
	public TravelocityHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		driver.get("https://www.travelocity.com/");		
	}
	
	public WebElement selectDay(List<WebElement> listWebElement, int day) {
		columns=tableDates.findElements(By.tagName("td"));	
		WebElement outWElement=null;
		for (WebElement wElementTemp: columns){
			if (wElementTemp.getText().equals(""+day)){
				wElementTemp.click();
				outWElement = wElementTemp;
				break;
			}
		}
		columns = null;
		return outWElement;
	}
	
	public WebElement selectSuggeestion(WebElement webElement,String suggestion, WebDriver driver) {		
		webElement.sendKeys(suggestion);	
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("typeaheadDataPlain")));
		return suggestFirst;
	}
	
	public WebElement getSuggestFrom() {
		return suggestFirst;
	}

	public void setSuggestFrom(WebElement suggestFrom) {
		this.suggestFirst = suggestFrom;
	}

	public WebElement getButtonFlight() {
		return buttonFlight;
	}

	public void setButtonFlight(WebElement buttonFlight) {
		this.buttonFlight = buttonFlight;
	}

	public WebElement getButtonRoundTrip() {
		return buttonRoundTrip;
	}

	public void setButtonRoundTrip(WebElement buttonRoundTrip) {
		this.buttonRoundTrip = buttonRoundTrip;
	}

	public WebElement getTextInFrom() {
		return textInFrom;
	}

	public void setTextInFrom(WebElement textInFrom) {
		this.textInFrom = textInFrom;
	}

	public WebElement getTextInTo() {
		return textInTo;
	}

	public void setTextInTo(WebElement textInTo) {
		this.textInTo = textInTo;
	}

	public WebElement getInputDateFrom() {
		return inputDateFrom;
	}

	public void setInputDateFrom(WebElement inputDateFrom) {
		this.inputDateFrom = inputDateFrom;
	}

	public WebElement getInputDateFromButtonPrev() {
		return inputDateFromButtonPrev;
	}

	public void setInputDateFromButtonPrev(WebElement inputDateFromButtonPrev) {
		this.inputDateFromButtonPrev = inputDateFromButtonPrev;
	}

	public WebElement getInputDateFromButtonNext() {
		return inputDateFromButtonNext;
	}

	public void setInputDateFromButtonNext(WebElement inputDateFromButtonNext) {
		this.inputDateFromButtonNext = inputDateFromButtonNext;
	}

	public WebElement getInputDateTo() {
		return inputDateTo;
	}

	public void setInputDateTo(WebElement inputDateTo) {
		this.inputDateTo = inputDateTo;
	}

	public WebElement getDropDownULFrom() {
		return dropDownULFrom;
	}

	public void setDropDownULFrom(WebElement dropDownULFrom) {
		this.dropDownULFrom = dropDownULFrom;
	}

	public WebElement getSuggestFirst() {
		return suggestFirst;
	}

	public void setSuggestFirst(WebElement suggestLAS) {
		this.suggestFirst = suggestLAS;
	}

	public List<WebElement> getColumns() {
		return columns;
	}

	public void setColumns(List<WebElement> columns) {
		this.columns = columns;
	}

	public WebElement getTableWeeks() {
		return tableWeeks;
	}

	public void setTableWeeks(WebElement tableWeeks) {
		this.tableWeeks = tableWeeks;
	}

	public WebElement getTableDates() {
		return tableDates;
	}

	public void setTableDates(WebElement tableDates) {
		this.tableDates = tableDates;
	}

	public WebElement getButtonSearch() {
		return buttonSearch;
	}

	public void setButtonSearch(WebElement buttonSearch) {
		this.buttonSearch = buttonSearch;
	}

	public WebElement getButtonFlightHotel() {
		return buttonFlightHotel;
	}

	public void setButtonFlightHotel(WebElement buttonFlightHotel) {
		this.buttonFlightHotel = buttonFlightHotel;
	}

	public WebElement getTextInFromFlHotel() {
		return textInFromFlHotel;
	}

	public void setTextInFromFlHotel(WebElement textInFromFlHotel) {
		this.textInFromFlHotel = textInFromFlHotel;
	}

	public WebElement getTextInToFlHotel() {
		return textInToFlHotel;
	}

	public void setTextInToFlHotel(WebElement textInToFlHotel) {
		this.textInToFlHotel = textInToFlHotel;
	}

	public WebElement getInputDateFromFlHo() {
		return inputDateFromFlHo;
	}

	public void setInputDateFromFlHo(WebElement inputDateFromFlHo) {
		this.inputDateFromFlHo = inputDateFromFlHo;
	}

	public WebElement getInputDateToFlHo() {
		return inputDateToFlHo;
	}

	public void setInputDateToFlHo(WebElement inputDateToFlHo) {
		this.inputDateToFlHo = inputDateToFlHo;
	}

	public WebElement getButtonflHoCa() {
		return buttonflHoCa;
	}

	public void setButtonflHoCa(WebElement buttonflHoCa) {
		this.buttonflHoCa = buttonflHoCa;
	}

	public WebElement getButtonHotel() {
		return buttonHotel;
	}

	public void setButtonHotel(WebElement buttonHotel) {
		this.buttonHotel = buttonHotel;
	}

	public WebElement getTextInGoingTo() {
		return textInGoingTo;
	}

	public void setTextInGoingTo(WebElement textInGoingTo) {
		this.textInGoingTo = textInGoingTo;
	}

	public WebElement getButtonSearchHotel() {
		return buttonSearchHotel;
	}

	public void setButtonSearchHotel(WebElement buttonSearchHotel) {
		this.buttonSearchHotel = buttonSearchHotel;
	}
	
	public TravelocityHotelSearchPage getTravelocityHotelSearchPage(WebDriver driver) {
		return new TravelocityHotelSearchPage(driver);
	}

	public WebElement getCheckPartialHotel() {
		return checkPartialHotel;
	}

	public void setCheckPartialHotel(WebElement checkPartialHotel) {
		this.checkPartialHotel = checkPartialHotel;
	}

	public WebElement getInputDateCheckIn() {
		return inputDateCheckIn;
	}

	public void setInputDateCheckIn(WebElement inputDateCheckIn) {
		this.inputDateCheckIn = inputDateCheckIn;
	}

	public WebElement getInputDateCheckOut() {
		return inputDateCheckOut;
	}

	public void setInputDateCheckOut(WebElement inputDateCheckOut) {
		this.inputDateCheckOut = inputDateCheckOut;
	}

	public WebElement getContainerErrorMessage() {
		return containerErrorMessage;
	}

	public void setContainerErrorMessage(WebElement containerErrorMessage) {
		this.containerErrorMessage = containerErrorMessage;
	}

	public WebElement getButtonCruise() {
		return buttonCruise;
	}

	public void setButtonCruise(WebElement buttonCruise) {
		this.buttonCruise = buttonCruise;
	}
}
