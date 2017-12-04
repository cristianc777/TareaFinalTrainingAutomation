package test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.TravelocityHomePage;

public class TravelocityBusquedaPageTest extends BaseTest{


	@Test
	@Parameters({"browser"})
	public void BuscarVuelo() {
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
		Assert.assertNotNull(tvhp.getButtonSearch(), "The Search Button doesn't exists");
		
	
	}
	
}
