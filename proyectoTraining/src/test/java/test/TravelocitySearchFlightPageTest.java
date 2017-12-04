package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.TravelocityFlightInformationPage;
import page.TravelocityFlightSearchPage;
import page.TravelocityHomePage;

public class TravelocitySearchFlightPageTest extends BaseTest{


	@Test
	@Parameters({"browser"})
	public void SearchFlight() {
		TravelocityHomePage tvhp = getTravelocityHomePage();
		tvhp.getButtonFlight().click();
		tvhp.getButtonRoundTrip().click();
		tvhp.selectSuggeestion(tvhp.getTextInFrom(),"LAS",tvhp.getDriver()).click();
		tvhp.getSuggestFirst().click();
		tvhp.getTextInTo().click();
		tvhp.selectSuggeestion(tvhp.getTextInTo(),"LAX", tvhp.getDriver()).click();
		tvhp.getSuggestFirst().click();
		tvhp.getInputDateFrom().click();
		tvhp.clickNTimes(tvhp.getInputDateFromButtonNext(),3);
		tvhp.selectDay(tvhp.getColumns(), 7);
		tvhp.getInputDateTo().click();
		tvhp.clickNTimes(tvhp.getInputDateFromButtonNext(),1);
		tvhp.selectDay(tvhp.getColumns(), 14);
		tvhp.getButtonSearch().click();
		
		TravelocityFlightSearchPage tvsp = new TravelocityFlightSearchPage(tvhp.getDriver());
//		tvsp.getSelectorOrder().getFirstSelectedOption().click();
		//Validaciones
		//Punto 2a
		Assert.assertTrue(tvsp.existsInSelector("price:asc", tvsp.getSelectorOrder()));
		Assert.assertTrue(tvsp.existsInSelector("price:desc", tvsp.getSelectorOrder()));
		Assert.assertTrue(tvsp.existsInSelector("departuretime:asc", tvsp.getSelectorOrder()));
		Assert.assertTrue(tvsp.existsInSelector("departuretime:desc", tvsp.getSelectorOrder()));
		Assert.assertTrue(tvsp.existsInSelector("arrivaltime:asc", tvsp.getSelectorOrder()));
		Assert.assertTrue(tvsp.existsInSelector("duration:asc", tvsp.getSelectorOrder()));
		Assert.assertTrue(tvsp.existsInSelector("duration:desc", tvsp.getSelectorOrder()));
		//Punto 2b
		Assert.assertTrue(tvsp.verifyElementInsideContainer(tvsp.getContainerListResultsFlight(),"select"));
		//Punto 2c
		Assert.assertTrue(tvsp.verifyElementInsideContainer(tvsp.getContainerListResultsFlight(),"flightDuration"));
		//Punto 2d
		Assert.assertTrue(tvsp.verifyElementInsideContainer(tvsp.getContainerListResultsFlight(),"baggageFees"));
//		Contraprueba
//		Assert.assertTrue(tvsp.verifyElementInsideContainer(tvsp.getContainerListResultsFlight(),"baggadrfgeFees"));
		//Punto3
		tvsp.getwEselectorOrder().click();
		tvsp.getSelectorOrder().selectByValue("duration:asc");
		
		//
		tvsp.waitOnElement("ButtonSelect");
		TravelocityFlightSearchPage tvfsoFrom = new TravelocityFlightSearchPage(tvsp.getDriver());
		tvfsoFrom.selectOptionFlight(tvfsoFrom.getContainerListResultsFlight(),1,25);
		tvfsoFrom.waitOnElement("ButtonSelect");		
		TravelocityFlightSearchPage tvfsoTo = new TravelocityFlightSearchPage(tvfsoFrom.getDriver());
		tvfsoTo.selectOptionFlight(tvfsoTo.getContainerListResultsFlight(), 3,25);
		tvfsoTo.switchTab();
		TravelocityFlightInformationPage tvfi = new TravelocityFlightInformationPage(tvfsoTo.getDriver());
		tvfi.verifyInformationStrPattern(tvfi.getTotalPriceContainerLabel().getText(), "^\\$\\d*\\.\\d*");
		System.out.println("FuenteDatos from: " + tvfi.getPanelFromInfo().getText());
		System.out.println("FuenteDatos to: " + tvfi.getPanelToInfo().getText());
		System.out.println(tvfi.getLabelGuarantee().isDisplayed());
//		tvfi.verifyInformationStrPattern(tvfi.getPanelFromInfo().getText(), "^\\$\\d*\\.\\d*");
//		tvfi.verifyInformationStrPattern(tvfi.getTotalPriceContainerLabel().getText(), "^\\$\\d*\\.\\d*");
		tvfi.verifyInformationStr(tvfi.getPanelFromInfo().getText(), "FromMcCarran Intl. (LAS)");
		tvfi.verifyInformationStr(tvfi.getPanelFromInfo().getText(), "ToLos Angeles Intl. (LAX)");
		tvfi.verifyInformationStr(tvfi.getPanelToInfo().getText(), "FromMcCarran Intl. (LAS)");
		tvfi.verifyInformationStr(tvfi.getPanelToInfo().getText(), "ToLos Angeles Intl. (LAX)");
		
	}
	
}
