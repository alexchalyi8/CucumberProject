package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowsersUtils;

public class WebOrderLoginPage {
    public WebOrderLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (css = "#Email")
    WebElement email;
    @FindBy(css = "#Password")
    WebElement passwordBar;
    @FindBy(xpath = "//button[contains(text(),'Sign In')]")
    WebElement signinButton;
    @FindBy(css = ".alert")
    WebElement errorMessage;


    public void login(String username,String password) throws InterruptedException {

        email.clear();
        Thread.sleep(2000);
        email.sendKeys(username);

        passwordBar.clear();
        Thread.sleep(2000);
        passwordBar.sendKeys(password);
        Thread.sleep(2000);
        signinButton.click();
    }
       public String errorMessage( ) throws InterruptedException {
        Thread.sleep(2000);
       return BrowsersUtils.getText(errorMessage);

    }

}
