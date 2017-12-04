package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import page.TravelocityCruisesResultsPage;
import page.TravelocityCruisesSearchPage;
import page.TravelocityHomePage;

public class TravelocityCruisesTest extends BaseTest{
	
	@Test
	@Parameters({"browser"})
	public void searchCruise() {
		TravelocityHomePage tvhp = getTravelocityHomePage();
		tvhp.getButtonCruise().click();
		TravelocityCruisesSearchPage tvcsp = tvhp.getNewCruisesPage(tvhp.getDriver());
		tvcsp.waitOnSelectors();
		tvcsp.getSelectorCruisesFrom().click();
		tvcsp.getSelectorFrom().selectByVisibleText("Europe");
		tvcsp.waitOnSelectors();
		tvcsp.getSelectorCruisesWhen().click();
		tvcsp.getSelectWhen().selectByVisibleText("Feb 2018");
		tvcsp.getButtonSearchCruise().click();
		tvcsp.waitOnloadMessage(0, "cruiseLoadingView", "Finding available cruises for your trip", null);
		TravelocityCruisesResultsPage tvcrp = new TravelocityCruisesResultsPage(tvcsp.getDriver());
		//Validations
		Assert.assertTrue(tvcrp.getLabelDestination().getText().contains("Europe"));
		Assert.assertTrue(tvcrp.getLabelWhere().getText().contains("Feb 2018"));
		//Select filter
		tvcrp.getLengthCruise().click();
		//All cruises are showed with discounts, the validation was skkiped
//		tvcrp.selectCruiseMoreDiscount(tvcrp.get);
		
		
	
	}

}
