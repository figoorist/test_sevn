package ru.comp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Base class for all the JUnit-based test classes
 */
public class JUnitTestBase {

  protected static String baseUrl;
  protected static String email;
  protected static String surveyUrl;

  protected static WebDriver driver;

  @ClassRule
  public static ExternalResource webDriverProperties = new ExternalResource() {
      @Override
      protected void before() throws Throwable {
          SuiteConfiguration config = new SuiteConfiguration();
          baseUrl = config.getProperty("site.url");
          email = config.getProperty("email");
          surveyUrl = config.getProperty("surveyUrl");
      }
  };

  @BeforeClass
  public static void setUp(){
      driver = new ChromeDriver();
      //set wait timeout
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      //maximize screen
      driver.manage().window().maximize();
      driver.get(baseUrl);
  }

  @AfterClass
  public static void tearDown(){
      driver.quit();
  }

}
