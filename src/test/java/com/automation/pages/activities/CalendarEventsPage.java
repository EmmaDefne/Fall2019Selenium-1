package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarEventsPage extends AbstractPageBase {
    @FindBy( css = "a[title='Create Calendar event']")
    private WebElement createCalendarEvent;
    @FindBy(className = "select2-chosen")
    private WebElement owner;
    @FindBy(css="[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;
    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;
    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;
    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;
    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    private WebElement descriptionFrame;
    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;
    @FindBy(id = "tinymce")
    private WebElement descriptionTextArea;
    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement saveAndClose;
    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;
    @FindBy(xpath = "//label[text()='Description']/following-sibling::div//div")
    private WebElement generalInfoDescription;
    //With enterCalendarEventDescription method in page class;
    //you do not need to switch frame inside test,
    //everything is covered is covered inside page; all kind of page interactions
    public void enterCalendarEventTitle(String titleValue) {
        BrowserUtils.waitForPageToLoad(30);
        BrowserUtils.wait(2);

        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);
    }
    public void enterCalendarEventDescription(String description) {
        //wait until frame is available and switch to it
        BrowserUtils.waitForPageToLoad(30);
        BrowserUtils.wait(2);

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        descriptionTextArea.sendKeys(description);
        driver.switchTo().defaultContent();//exit from the frame
    }
    public void clickOnSaveAndClose() {
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.wait(2);

        wait.until(ExpectedConditions.elementToBeClickable(saveAndClose)).click();
    }
    public String getGeneralInfoTitleText() {
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.wait(2);

        return generalInfoTitle.getText();
    }
    public String getGeneralInfoDescriptionText() {
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.wait(2);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Description']/following-sibling::div//div")));
        return generalInfoDescription.getText();
    }


    public List<String> getColumnNames(){
        BrowserUtils.waitForPageToLoad(20);
        return BrowserUtils.getTextFromWebElements(columnNames);
    }
    public String getStartTime(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^='time_selector_oro_calendar_event_form_start']")));
        return startTime.getAttribute("value");
    }
    public String getEndTime(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return endTime.getAttribute("value");
    }
    public String getOwnerName(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }
    public void clickToCreateCalendarEvent() {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
    }
    public String getStartDate(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        BrowserUtils.scrollTo(startDate);
        return startDate.getAttribute("value");
    }
}
