package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
    WebDriver driver;
@BeforeTest
    public void setUp() {
        // Set the path to the ChromeDriver executable (make sure to download ChromeDriver and set the correct path)
	System.setProperty("webdriver.http.factory", "jdk-http-client");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Projects\\my-application\\src\\test\\resources\\drivers\\chromedriver.exe");
// Initialize the ChromeDriver instance
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        // Set a fixed port for remote debugging
        options.addArguments("--remote-debugging-port=9222");
//        String browser = System.getProperty("browser", "chrome"); // Can be passed as a system property
    }
@Test
    public void testGoogleTitle() {
        // Navigate to Google
        driver.get("https://www.google.com");
// Get the title of the page and verify it
        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");
    }

// Clean up after tests
    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

