package steps;

import PageManager.AppLib;
import esignly.factory.DriverFactory;

public class MasterSteps {
	
	 public AppLib appLib;
	
	protected MasterSteps() {
		
		 appLib = new AppLib(DriverFactory.getDriver());
	}
	
	

}
