package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelocityHotelInformationPage extends BasePage{

	
	public static String XPATH_TO_HOTEL = "//*[contains(@class,'btn btn-secondary btn-sub-action book-button')]";
	
	@FindBy(id="hotel-name")
	WebElement titleHotel;
	@FindBy(id="availability-header")
	WebElement titleAvailability;
	@FindBy(id="hotel-amenities")
	WebElement titleAmenities;
	
	@FindBy(id="rooms-and-rates")
	WebElement containerRooms;
	
	public TravelocityHotelInformationPage(WebDriver driverT) {
		super(driverT);
		PageFactory.initElements(driverT,this);
		// TODO Auto-generated constructor stub
	}
	
	
	

	public WebElement getTitleHotel() {
		return titleHotel;
	}

	public void setTitleHotel(WebElement titleHotel) {
		this.titleHotel = titleHotel;
	}

	public WebElement getTitleAvailability() {
		return titleAvailability;
	}

	public void setTitleAvailability(WebElement titleAvailability) {
		this.titleAvailability = titleAvailability;
	}

	public WebElement getTitleAmenities() {
		return titleAmenities;
	}

	public void setTitleAmenities(WebElement titleAmenities) {
		this.titleAmenities = titleAmenities;
	}

	public WebElement getContainerRooms() {
		return containerRooms;
	}

	public void setContainerRooms(WebElement containerRooms) {
		this.containerRooms = containerRooms;
	}

	
	
}
