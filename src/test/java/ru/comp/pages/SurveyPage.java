package ru.comp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Page with Q&A section
 */
public class SurveyPage extends Page {
    /**
     * Constructor
     * @param webDriver
     */
    public SurveyPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Get survey form
     * @return
     */
    public WebElement getSurveyForm(){
        return driver.findElement(By.className("survey"));
    }

    /**
     * Get Q&A questions
     * @return
     */
    public List<WebElement> getQuestionElements(){
        return getSurveyForm().findElements(By.className("radio"));
    }

    /**
     * Get survey submit button
     * @return
     */
    public WebElement getSubmitSurveyButton(){
        return getSurveyForm().findElement(By.cssSelector("button[type='submit']"));
    }
}
