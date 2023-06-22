package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WebOrderLoginPage;
import com.test.weborder.pages.WeborderCreatingForGroupPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class GroupWebOrderProcessStepDef {
    WebDriver driver = DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage(driver);
    WeborderCreatingForGroupPage weborderCreatingForGroupePage = new WeborderCreatingForGroupPage(driver);


    @When("User provides username,password and click Login button")
    public void user_provides_username_password_and_click_login_button() throws InterruptedException {
        webOrderLoginPage.login(ConfigReader.readProperty("WebOrderTestUsername"), ConfigReader.readProperty("WebOrderTestPassword"));
    }

    @Then("User select {string} , validate {string} and click group order button")
    public void user_select_validate_and_click_group_order_button(String deliveryMethod, String customerAddress) throws InterruptedException {
        weborderCreatingForGroupePage.deliveryAddressValidation(deliveryMethod, customerAddress);
    }

    @When("User fill up sections {string} , {string}")
    public void user_fill_up_sections_and_choose_delivery(String inviteMessage, String inviteEmails) throws InterruptedException {
        weborderCreatingForGroupePage.fillUpInvitesSections(inviteMessage, inviteEmails);
    }


    @Then("User validate header {string}")
    public void user_validate_header(String expectedHeader) throws InterruptedException {
        weborderCreatingForGroupePage.headerValidation(expectedHeader);

    }

    @Then("User validate if the description contains the {string}")
    public void user_validate_if_the_description_contains_the(String orderDescription) throws InterruptedException {
        weborderCreatingForGroupePage.groupOrderDescriptionValidation(orderDescription);
    }


}
