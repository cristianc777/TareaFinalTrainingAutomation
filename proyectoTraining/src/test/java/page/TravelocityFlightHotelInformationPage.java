package page;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TravelocityFlightHotelInformationPage extends BasePage {

	@FindBy(id="hotelResultTitle")
	WebElement labelStartChoosingHotel;
	
	@FindBy(className="showing-results")
	WebElement labelShowingResults;
	
	@FindBy(id="legal-disclosure")
	WebElement labelLegalInfo;
	
	@FindBy(id="star")
	WebElement divStarts;
	
	@FindBy(id="resultsContainer")
	WebElement divContainerResults;
	
	@FindBy(xpath="//button[@aria-label='Sort by: Price']")
	WebElement buttonSortByPrice;
	
	@FindBy(id="modalInterstitial")
	WebElement modalWindowUpdating;
	
	@FindBy(id="star3")
	WebElement check3Star;

	
	public static String XPATH_OF_HOTEL_CONTAINER = "//*[contains(@data-automation,'organic')]";
	
	public TravelocityFlightHotelInformationPage(WebDriver driverT) {
		super(driverT);
		PageFactory.initElements(driverT,this);
		// TODO Auto-generated constructor stub
	}
	
	public void waitOnload(WebDriver webDriver) {
		getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("hotelResultTitle")));
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Sort by: Price']")));
	}
	
	public boolean selectOptionFlight(WebElement element, int option, int expected) {
		List<WebElement> sub_li_comp = element.findElements(By.xpath("//*[contains(@data-automation,'organic')]"));
		option = option-1;
		if(option <= sub_li_comp.size()) {
			sub_li_comp.get(option).click();	
			sub_li_comp = null;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isOrderedRight(WebElement container, String valueToLocate) {
		boolean ordered=false;
		List<WebElement> sub_li_comp = container.findElements(By.xpath(valueToLocate));
		ArrayList<Integer> listPrices = new ArrayList<Integer>();
		int i=0;
		for (WebElement element: sub_li_comp) {
			String temp = element.getText().replaceAll("\\r\\n|\\r|\\n", " ");
			listPrices.add(Integer.parseInt(stringToIntList("Price is now: \\$", "Price is now: #","(Price is now: #([0-9]*) per)", temp,15,0)));
			if(i>1 && i<listPrices.size()) {
				if(compareOrderNumbersAsc(listPrices.get(i-1), listPrices.get(i))) {
					ordered = true;
				}else {
					ordered=false; 
					break;
				}
			
			}
			i++;
		}
		return ordered;
	}
	
	public boolean validationStars(WebElement container, float min) {
		List<WebElement> sub_li_comp = container.findElements(By.xpath("//*[contains(@data-automation,'organic')]"));
		boolean startsMoreThan=false;
		for (WebElement element: sub_li_comp) {
			String temp = element.getText().replaceAll("\\r\\n|\\r|\\n", " ");
			float stars = (float) Float.parseFloat((stringToIntList("\\.", "#"," ([0-9]#[0-9] out of 5#0 )", temp,0,1)).replace("#","."));
			if(stars<min) {
				startsMoreThan = false;
				break;
			}else {
				startsMoreThan = true;
			}
		}
		return startsMoreThan; 
	}
	
	public boolean compareOrderNumbersAsc(int first, int second) {
		if(first<=second)
			return true;
		return false; 
	}
	
	public TravelocityFlightHotelInformationPage getNewInstance(WebDriver webDriver) {
		return new TravelocityFlightHotelInformationPage(webDriver);
	}
	
	
	public void waitOnListResults() {
		getWebDriverWait().until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[contains(@data-automation,'organic')]"),20));
	}
	
	public WebElement getLabelStartChoosingHotel() {
		return labelStartChoosingHotel;
	}

	public void setLabelStartChoosingHotel(WebElement labelStartChoosingHotel) {
		this.labelStartChoosingHotel = labelStartChoosingHotel;
	}

	public WebElement getLabelShowingResults() {
		return labelShowingResults;
	}

	public void setLabelShowingResults(WebElement labelShowingResults) {
		this.labelShowingResults = labelShowingResults;
	}

	public WebElement getLabelLegalInfo() {
		return labelLegalInfo;
	}

	public void setLabelLegalInfo(WebElement labelLegalInfo) {
		this.labelLegalInfo = labelLegalInfo;
	}

	public WebElement getDivStarts() {
		return divStarts;
	}

	public void setDivStarts(WebElement divStarts) {
		this.divStarts = divStarts;
	}

	public WebElement getDivContainerResults() {
		return divContainerResults;
	}

	public void setDivContainerResults(WebElement divContainerResults) {
		this.divContainerResults = divContainerResults;
	}

	public WebElement getButtonSortBy() {
		return buttonSortByPrice;
	}

	public void setButtonSortBy(WebElement buttonSortBy) {
		this.buttonSortByPrice = buttonSortBy;
	}

	public WebElement getButtonSortByPrice() {
		return buttonSortByPrice;
	}

	public void setButtonSortByPrice(WebElement buttonSortByPrice) {
		this.buttonSortByPrice = buttonSortByPrice;
	}

	public WebElement getModalWindowUpdating() {
		return modalWindowUpdating;
	}

	public void setModalWindowUpdating(WebElement modalWindowUpdating) {
		this.modalWindowUpdating = modalWindowUpdating;
	}

	public WebElement getCheck3Star() {
		return check3Star;
	}

	public void setCheck3Star(WebElement check3Star) {
		this.check3Star = check3Star;
	}
}
