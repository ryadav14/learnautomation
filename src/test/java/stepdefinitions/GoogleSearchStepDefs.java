package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GoogleSearchStepDefs {
    WebDriver driver;
    WebElement searchBox;
    @Given("I navigate to google website")
    public void i_navigate_to_google_website() {
        System.getProperty("webdriver.chrome.driver","Z:\\YouTubeChannelMaterial\\learnautomation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }
    @When("I enter Testing keyword in search box")
    public void i_enter_testing_keyword_in_search_box() {
        searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Testing");
    }
    @When("I press enter")
    public void i_press_enter() {
        searchBox.sendKeys(Keys.ENTER);
    }
    @Then("Results page should show Testing details")
    public void results_page_should_show_testing_details() {
       String expectedResults = "Testing for COVID-19 | CDC" ;
       WebElement results =  driver.findElement(By.xpath("//h3[contains(text(),'"+expectedResults+"')]"));
       Assert.assertEquals(results.getText(),expectedResults);

    }

}
