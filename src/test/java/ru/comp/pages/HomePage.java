package ru.comp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.pagefactory.ByChained;

/**
 * Home page Wrike
 */
public class HomePage extends Page {

    /**
     * Get h1 element
     */
    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    public WebElement header;

    /**
     * Constructor
     * @param webDriver
     */
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Get Get started button
     * @return
     */
    public WebElement getGetStartedForFreeButton(){
        return driver.findElement(By.xpath("//form[contains(text(), 'Get started ')]")).findElement(By.tagName("button"));
    }

    /**
     * Get Start Free Trial form
     * @return
     */
    public WebElement getStartFreeTrialForm(){
        return driver.findElement(By.xpath("//form[contains(text(), 'Start Free trial')]"));
    }

    /**
     * Get Start Free Trial form email field
     * @return
     */
    public WebElement getStartFreeTrialEmailField(){
        return getStartFreeTrialForm().findElement(By.name("email"));
    }

    /**
     * Get Start Free Trial form submit
     * @return
     */
    public WebElement getStartFreeTrialSubmit(){
        return getStartFreeTrialForm().findElement(By.cssSelector("button[type='submit']"));
    }
}
