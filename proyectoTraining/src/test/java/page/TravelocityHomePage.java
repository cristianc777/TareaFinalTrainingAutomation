package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelocityHomePage extends BasePage{

	@FindBy (id="tab-flight-tab-hp")
	WebElement buttonFlight;
	@FindBy (id = "flight-type-roundtrip-label-hp-flight")
	WebElement buttonRoundTrip;
	@FindBy (id = "flight-origin-hp-flight")
	WebElement textInFrom;
	@FindBy (id="flight-destination-hp-flight")
	WebElement textInTo;
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
	@FindBy (xpath = "//*[@id=\"typeaheadDataPlain\"]")
	WebElement dropDownULFrom;
	@FindBy(xpath ="//*[@id=\"aria-option-0\"]")
	WebElement suggestFirst;
	@FindBy(css="div.cols-nested:nth-child(22) > label:nth-child(1) > button:nth-child(1)")
	WebElement buttonSearch;
	
	List<WebElement> columns=null;
	
		
	public TravelocityHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		driver.get("https://www.travelocity.com/");		
	}
	
	public WebElement selectDay(List<WebElement> listWebElement, int day) {
		columns=tableDates.findElements(By.tagName("td"));	
		WebElement outWElement=null;
		for (WebElement wElementTemp: columns){
			//Select 13th Date 
			System.out.println("Iter");
			System.out.println("texto:" + wElementTemp.getText());
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
	
	public void clickNTimes(WebElement webElement, int iterations) {
		for (int i=0;i<iterations; i++) {
			webElement.click();
		}
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
	
}
