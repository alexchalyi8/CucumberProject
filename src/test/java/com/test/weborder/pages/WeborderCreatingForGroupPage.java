package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowsersUtils;

public class WeborderCreatingForGroupPage {
    public WeborderCreatingForGroupPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='GroupOrder']")
    WebElement groupOrderCheckBox;
    @FindBy(xpath = "//button[@id='getAddressNextButton']")
    WebElement nextButton;
    @FindBy(xpath = "//select[@id='ConfirmAddressID']")
    WebElement deliveryOption;
    @FindBy (css = "#InviteNote")
    WebElement inviteNoteBox;
    @FindBy(css = "#InviteList")
    WebElement inviteListBox;
    @FindBy(css = "#createGroupOrder")
    WebElement createGroupOrderBtn;
    @FindBy(css = "div[id='addressPreview']")
    WebElement customerAddress;
    @FindBy(tagName = "h1")
    WebElement groupOrderHeader;
    @FindBy(xpath = "//div[@class='col']//p[contains(text(),'Your group order is now pending')]")
    WebElement orederDescription;
    public void selectGroupOrder(WebDriver driver) throws InterruptedException {
       if(groupOrderCheckBox.isEnabled());
        BrowsersUtils.clickWithJS(driver,groupOrderCheckBox);
        Thread.sleep(2000);
        nextButton.click();
    }
    public void fillUpInvitesSections(String inviteMessage,String inviteEmails) throws InterruptedException {
        inviteNoteBox.sendKeys(inviteMessage);
        inviteListBox.sendKeys(inviteEmails);

        createGroupOrderBtn.click();
        Thread.sleep(2000);


    }
    public void deliveryAddressValidation(String location , String address) throws InterruptedException {
        deliveryOption.click();
        Thread.sleep(2000);
        BrowsersUtils.selectBy(deliveryOption,location,"text");
        Thread.sleep(2000);
        Assert.assertTrue(BrowsersUtils.getText(customerAddress).contains(address));
    }
    public void headerValidation(String expectedHeader) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(expectedHeader,BrowsersUtils.getText(groupOrderHeader));
    }
    public void groupOrderDescriptionValidation(String descriptionText) throws InterruptedException {

        Thread.sleep(2000);
        Assert.assertTrue(BrowsersUtils.getText(orederDescription).contains(descriptionText));
    }
}
