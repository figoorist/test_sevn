package ru.comp.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.comp.pages.HomePage;
import java.util.Random;
import java.util.stream.Collectors;

public class HomePageSteps {
    /**
     * HomePage object
     */
    private HomePage homepage;
    /**
     * WebDriver
     */
    private WebDriver wd;

    /**
     * Constructor
     * @param driver
     */
    public HomePageSteps(WebDriver driver){
        homepage = PageFactory.initElements(driver, HomePage.class);
        wd = driver;
    }

    private String randomString(int length){
        String chars = "abcdefghijklmnopqrstuvwxyz";

        return new Random().ints(length, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .collect(Collectors.joining());
    }

    /**
     * Open Q&A section
     * @param emailPart
     */
    public void goToQAndASectionStep(String emailPart) {
        // 2. Click "Get started for free" button near "Login" button;
        homepage.getGetStartedForFreeButton().click();
        // 3. Fill in the email field with random generated value of email
        // with mask “<random_text>+wpt@wriketask.qaa” (e.g. “abcdef+wpt@wriketask.qaa”);
        homepage.getStartFreeTrialEmailField().sendKeys(randomString(6) + "+" + emailPart);
        // 4. Click on "Create my Wrike account" button
        homepage.getStartFreeTrialSubmit().click();
        wd.switchTo().defaultContent();
        wd.switchTo().frame(wd.findElement(By.tagName("iframe")));
    }
}

//html/body/c-wiz/div/div/div[2]/div[4]/span[1]/div