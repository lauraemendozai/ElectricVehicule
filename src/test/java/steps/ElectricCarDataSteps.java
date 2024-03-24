package steps;

import io.cucumber.java.en.*;
import pages.DataGov;

public class ElectricCarDataSteps {
    DataGov Test = new DataGov();
    
    @Given("I navigate to Dataset page of Catalog data gov")
    public void iNavigateTo(){
        Test.navigateToDataGov();
    }

    @When("I search electric car on the website")
    public void searchData(){
        Test.enterSearchCriteria();
        Test.clickSearchButton();
    }

    @Then("I can download the data of Electric Vehicle Population Data")
    public void SearchAndDownloadCSV(){
        Test.findAndDownload();
    }
}
