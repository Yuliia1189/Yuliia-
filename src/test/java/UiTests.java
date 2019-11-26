import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * TASK 4
 */
public class UiTests {
    private static WebDriver driver;
    private static final String URL = "http://127.0.0.1:3000";


    @BeforeEach
    public void driverSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    public void driverTeardown() {
        driver.quit();
    }

    @Test
    public void welcomePage() {
        driver.get(URL);
        // page doesn't contain a single locator!
        // taking to consideration tight deadline
        // page source will be checked directly

        String[] content = new String[] {
                "Please provide your name:",
                "Users first name and last name", // issue here, text is not present on the page
                "Submit"
        };

        for (String e: content) {
            assertTrue(driver.getPageSource().contains(e));
        }

        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        assertTrue(driver.switchTo().alert().getText().contains("Please provide your name"));
    }

    @Test
    public void customerList() {
        //TODO implement
    }

    @Test
    public void contactDetails() {
        //TODO implement
    }
}
