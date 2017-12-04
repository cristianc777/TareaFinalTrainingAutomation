package page;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.ExpectedExceptions;

public abstract class BasePage {
	
	private WebDriver driver;
	private WebDriverWait webDriverWait;

	public BasePage(WebDriver driverT) {
		PageFactory.initElements(driverT, this);
		webDriverWait = new WebDriverWait(driverT, 30);
		this.driver = driverT;	
	}
	
	public void switchTab() {

		ArrayList<String> listaHandle = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Valor: " + listaHandle.size());
		for (String valor: listaHandle) {
			System.out.println("Ventana: " + valor);
		}
		driver.switchTo().window(listaHandle.get(1));
	}
	
	public void waitFixed(int valueSeconds) {
		try {
			System.out.println("Esperando...");
			Thread.sleep(valueSeconds*1000);
			System.out.println("Done!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	public boolean verifyInformationStrPattern(String stringToEval, String pattern) {
		return stringToEval.matches(pattern);
	}
	
	public boolean selectOptionInContainer(WebElement element, int option, int expected, String locatorPath) {
		List<WebElement> sub_li_comp = element.findElements(By.xpath(locatorPath));
		option = option-1;
		System.out.println("Size: " + sub_li_comp.size() );
		if(option <= sub_li_comp.size()) {
			sub_li_comp.get(option).click();	
			sub_li_comp = null;
			return true;
		}else {
			return false;
		}
	}
	
	public void waitOnloadMessage(int index, String idElement, String message, WebElement we) {
		System.out.println("Esperando carga...");
		if(index==1)
			getWebDriverWait().until(ExpectedConditions.invisibilityOfElementWithText(By.id(idElement), message));
		if(index==2)
//			getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(idElement)));
			getWebDriverWait().until(ExpectedConditions.invisibilityOfElementWithText(By.id(idElement), message));
		System.out.println("Carga completa...");
		if(index==3)
//			getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(idElement)));
			getWebDriverWait().until(ExpectedConditions.invisibilityOfElementWithText(By.className(idElement), message));
		System.out.println("Carga completa...");
	}
	
	public void waitOnElement(WebElement element) {
		getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
	}
	
	public boolean validationText(WebElement element, String textValue, int compareIndex, String xpath) {
		List<WebElement> sub_li_comp = element.findElements(By.xpath(xpath));
		boolean found = false;
		for (WebElement wElementTemp: sub_li_comp){
			if (wElementTemp.getText().contains(textValue)){
				found = true;
				break;
			}else {
				found = false;			
			}
		}
		return found; 
	}
	
	public String stringToIntList(String regex, String replaceValue, String patternTC,  String text, int subStrStart, int option) {
		String strRegex = regex;
		String replace = replaceValue;
		int indexOf = 0;
		Pattern p = Pattern.compile(strRegex);
		Matcher m = p.matcher(text);
		String tempSt = m.replaceAll(replace);
		Pattern pN = Pattern.compile(patternTC);
		Matcher mN = pN.matcher(tempSt);
		mN.find();
		String value = mN.group(1);
		//Select this option if the search is by lastIndexOf
		if(option==0) {
			indexOf = value.lastIndexOf(" ");
		}
		//select this option if the search is by firstIndex
		if(option==1) {
			indexOf = value.indexOf(" ");
		}
		return value.substring(subStrStart,indexOf);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public String replaceValue(String regex,String newValueReplace, String text) {
		return text.replaceAll(regex, newValueReplace);
	}

	public boolean verifyInformationStr(WebElement webElement, String stringToEval) {
		String temp = webElement.getText();
//		System.out.println("TextoNuevo: " + temp);
		if(temp.matches(".+?"+stringToEval+".+?"))
			return true;
		return false;
	}

	public boolean verifyInformationStr(String sourceTest, String stringToEval) {
		String temp = sourceTest;
//		System.out.println("TextoNuevo: " + temp);
		if(temp.matches(".+?"+stringToEval+".+?"))
			return true;
		return false;
	}
	
	public void clickNTimes(WebElement webElement, int iterations) {
		for (int i=0;i<iterations; i++) {
			webElement.click();
		}
	}
	
	public TravelocityCruisesSearchPage getNewCruisesPage(WebDriver driver) {
		return new TravelocityCruisesSearchPage(driver);
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriverWait getWebDriverWait() {
		return webDriverWait;
	}

	public void setWebDriverWait(WebDriverWait webDriverWait) {
		this.webDriverWait = webDriverWait;
	}
	
}
