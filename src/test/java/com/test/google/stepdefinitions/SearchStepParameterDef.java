package com.test.google.stepdefinitions;

import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchStepParameterDef {

    WebDriver driver = DriverHelper.getDriver();
    GoogleMainPage googleMainPage = new GoogleMainPage(driver);


    @Given("User navigates to the {string}")
    public void user_navigates_to_the(String website) {
        driver.get(website);

    }

    @When("User searches for {string}")
    public void user_searches_for(String item) {
        googleMainPage.searchItem(item);
    }

    @When("User search for {string}")
    public void user_search_for(String product) {
        googleMainPage.searchItem(product);
    }

    @Then("User validates first page returns more {int} links")
    public void user_validates_first_page_returns_more_links(Integer expectedLink) throws InterruptedException {
        Assert.assertTrue(googleMainPage.linkCount(expectedLink));
    }

    @Then("User validates the result is less than {int}")
    public void user_validates_the_result_is_less_than(Integer expectedResult) throws InterruptedException {
        Assert.assertTrue(googleMainPage.resultsFromSearch(expectedResult));
    }

    @Then("User validates page loads less than {double} second")
    public void user_validates_page_loads_less_than_second(Double searchTime) {
        Assert.assertTrue(googleMainPage.baklavaSearch(searchTime));
    }

}

