package page;

import java.util.List;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TravelocityFlightSearchPage extends BasePage {

//	@FindBy(xpath="//*[@id=\"sortBar\"]/div/fieldset/label/select")
	@FindBy(name = "sort")
	private WebElement wEselectorOrder;

	@FindBy(id="flightModuleList")
	private WebElement containerListResultsFlight;
	
	private Select selectorOrder = new Select(wEselectorOrder);
	private WebElement wEAux;
		
	public TravelocityFlightSearchPage(WebDriver driverT) {
		super(driverT);
		PageFactory.initElements(driverT,this);
//		getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(listResultsFlight));
		// TODO Auto-generated constructor stub
	}
	
	public boolean existsInSelector(String value, Select selector) {
		boolean exists = false;
		List<WebElement> listTemp = selector.getOptions();
		for (WebElement wEleTemp: listTemp) {
			if(wEleTemp.getAttribute("value").equals(value))
				exists = true;
		}
		return exists;
	}
	
	public boolean verifyElementInsideContainer(WebElement containerElements, String elementToVerify) {
		getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id*=flight-module-]")));
		List<WebElement> li_All = containerElements.findElements(By.cssSelector("[id*=flight-module-]"));
		boolean equalButtonNumber = false;
		int i=0;
		if(elementToVerify.equals("select")) {
			for(WebElement element : li_All){
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@data-test-id,'select-button')]")));
				wEAux = element.findElement(By.xpath("//*[contains(@data-test-id,'select-button')]"));
				if(wEAux!=null)
				i++;
			}
			if(i==li_All.size())
				equalButtonNumber = true;
		}
		if(elementToVerify.equals("flightDuration")) {
			for(WebElement element : li_All){
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@data-test-id,'duration')]")));
				wEAux = element.findElement(By.xpath("//*[contains(@data-test-id,'duration')]"));
				if(wEAux!=null)
				i++;
			}
			if(i==li_All.size())
				equalButtonNumber = true;
		}
		if(elementToVerify.equals("baggageFees")) {
			for(WebElement element : li_All){
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@data-test-id,'flight-details-link')]")));
				wEAux = element.findElement(By.xpath("//*[contains(@data-test-id,'flight-details-link')]"));
				if(wEAux!=null)
				i++;
			}
			if(i==li_All.size())
				equalButtonNumber = true;
		}
		return equalButtonNumber;
	}
	

	public boolean selectOptionFlight(WebElement element, int option, int expected) {
		getWebDriverWait().until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[contains(@data-test-id,'select-button')]"),expected));
		List<WebElement> sub_li_comp = element.findElements(By.xpath("//*[contains(@data-test-id,'select-button')]"));
		option = option-1;
		System.out.println("Ejecuteichon" + sub_li_comp.size());
		System.out.println("option: "+ option + "   ");
		if(option <= sub_li_comp.size()) {
			System.out.println("Hizo click");
			sub_li_comp.get(option).click();	
			sub_li_comp = null;
			return true;
		}else {
			return false;
		}
	}
	
	public void waitOnElement(String key) {
		if(key.equals("ButtonSelect")) {			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@data-test-id,'select-button')]")));
		}
	}
	
	public boolean existsValue(List<WebElement> listEval, String valEval) {
		return false;
	}

	public Select getSelectorOrder() {
		return selectorOrder;
	}

	public void setSelectorOrder(Select selectorOrder) {
		this.selectorOrder = selectorOrder;
	}

	public WebElement getListResultsFlight() {
		return containerListResultsFlight;
	}

	public void setListResultsFlight(WebElement listResultsFlight) {
		this.containerListResultsFlight = listResultsFlight;
	}

	public WebElement getwEselectorOrder() {
		return wEselectorOrder;
	}

	public void setwEselectorOrder(WebElement wEselectorOrder) {
		this.wEselectorOrder = wEselectorOrder;
	}

	public WebElement getContainerListResultsFlight() {
		return containerListResultsFlight;
	}

	public WebElement getwEAux() {
		return wEAux;
	}

	public void setwEAux(WebElement wEAux) {
		this.wEAux = wEAux;
	}

	public void setContainerListResultsFlight(WebElement containerListResultsFlight) {
		this.containerListResultsFlight = containerListResultsFlight;
	}
	
		
}
