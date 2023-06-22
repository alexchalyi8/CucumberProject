package com.test.weborder.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class WebOrderHook {
    WebDriver driver = DriverHelper.getDriver();
    @Before//import from cucumber.io
    public void setup(){
        driver.get(ConfigReader.readProperty("QA_weborder_url"));
    }
    @After
    public void tearDown(){
        //driver.quit();
    }
}
