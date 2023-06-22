package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WebOrderLoginPage;
import com.test.weborder.pages.WeborderCreatingForGroupPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class LoginStepDef {
    WebDriver driver = DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage(driver);
    WeborderCreatingForGroupPage weborderCreatingForGroupePage = new WeborderCreatingForGroupPage(driver);
    @When("User provides {string},{string} and click Login button")
    public void user_provides(String username, String password) throws InterruptedException {
     webOrderLoginPage.login(username,password);
    }
    @Then("User validate website {string}")
    public void user_validate_website(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
    }
    @Then("User validate the error message {string}")
    public void user_validate_the_error_message(String expectedMessage) throws InterruptedException {
        Assert.assertEquals(expectedMessage,webOrderLoginPage.errorMessage());
    }
    @Then("User select and start place the order for group")
    public void user_select_start_place_the_order_for_group() throws InterruptedException {

       weborderCreatingForGroupePage.selectGroupOrder(driver);
    }


}
