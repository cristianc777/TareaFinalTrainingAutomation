package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelocityCruisesResultsPage extends BasePage{

	@FindBy(id="destination-select")
	WebElement labelDestination;
	@FindBy(id="departure-month-select")
	WebElement labelWhere;
	@FindBy(id="length-10-14")
	WebElement lengthCruise;
	@FindBy(id="showDatesButton-1-21")
	WebElement firstCruise;
	@FindBy(id="main-results")
	WebElement divCointainerCruises;
	
	public TravelocityCruisesResultsPage(WebDriver driverT) {
		super(driverT);
		PageFactory.initElements(driverT,this);
		// TODO Auto-generated constructor stub
	}

	public void selectCruiseMoreDiscount(WebElement element) {
		List<WebElement> sub_li_comp = element.findElements(By.xpath("//*[contains(@class,'message-flag flex-flag')]"));
		boolean found = false;
		ArrayList<Integer> listDiscounts = new ArrayList<Integer>();
		String current;
		String fullText;
		for (WebElement wElementTemp: sub_li_comp){
			fullText = wElementTemp.getText().replaceAll("\\r\\n|\\r|\\n", " ");
			System.out.println("Fultext: " + fullText);
			System.out.println("------------------------");
//			listDiscounts.add(Integer.parseInt(stringToIntList("Price is now: \\$", "Price is now: #","(Price is now: #([0-9]*) per)", temp,15,0)));
		}
	}

	
	
	public WebElement getLabelDestination() {
		return labelDestination;
	}

	public void setLabelDestination(WebElement labelDestination) {
		this.labelDestination = labelDestination;
	}

	public WebElement getLabelWhere() {
		return labelWhere;
	}

	public void setLabelWhere(WebElement labelWhere) {
		this.labelWhere = labelWhere;
	}

	public WebElement getLengthCruise() {
		return lengthCruise;
	}

	public void setLengthCruise(WebElement lengthCruise) {
		this.lengthCruise = lengthCruise;
	}

	public WebElement getFirstCruise() {
		return firstCruise;
	}

	public void setFirstCruise(WebElement firstCruise) {
		this.firstCruise = firstCruise;
	}

	public WebElement getDivCointainerCruises() {
		return divCointainerCruises;
	}

	public void setDivCointainerCruises(WebElement divCointainerCruises) {
		this.divCointainerCruises = divCointainerCruises;
	}
	
}
