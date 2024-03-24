package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DataGov extends BasePage {
    private String searchField = "//input[@id='search-big']";

    public DataGov() {
        super(driver);
    }

    public void navigateToDataGov() {
        navigateTo("https://catalog.data.gov/dataset/");
    }
    
    public void enterSearchCriteria() {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search-big']"));
        searchBox.click();
        write(searchField, "electric car");
    }
    
    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.xpath("//button[@value='search']"));
        searchButton.click();
    }

    public void findAndDownload() {
        WebElement ExpectedResult = driver.findElement(By.linkText("Electric Vehicle Population Data"));
        ExpectedResult.click();

        WebElement csvButton = driver.findElement(By.cssSelector(".btn.btn-primary[href='https://data.wa.gov/api/views/f6w7-q2d2/rows.csv?accessType=DOWNLOAD']"));
        
        try {
            csvButton = driver.findElement(By.cssSelector(".btn.btn-primary[href='https://data.wa.gov/api/views/f6w7-q2d2/rows.csv?accessType=DOWNLOAD']"));
            csvButton.click();
            System.out.println("OK");
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("NOK but...");
            String newURL = csvButton.getAttribute("href");
            navigateTo(newURL);
        }
    }
}
