package Lovya.triple;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class statistics {
	private RemoteWebDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        URL url = new URL("http://172.20.23.92:4444/wd/hub");
        driver = new RemoteWebDriver(url, options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {
        driver.get("http://apollo2.humanbrain.in/");
        driver.manage().window().maximize();
        System.out.println("The server is opened successfully");

        WebDriverWait wait = new WebDriverWait(driver, 50);
        try {
            // Viewer Section
            WebElement viewerSectionLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/gallery.svg']")));
            viewerSectionLink.click();
            System.out.println("The Viewer Icon is clicked");

            // Login
            String parentWindow = driver.getWindowHandle();
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
            loginButton.click();

            Set<String> allWindows = driver.getWindowHandles();
            for (String window : allWindows) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }

            // Enter Credentials
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
            emailInput.sendKeys("softwaretestingteam9@gmail.com");

            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
            nextButton.click();

            WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
            passwordInput.sendKeys("Health#123");

            WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
            nextButton2.click();

            driver.switchTo().window(parentWindow);
            Thread.sleep(5000);
        } catch (Exception e) {
            System.err.println("An error occurred during login: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void analyticsEngine() throws InterruptedException {
    	 try {
             WebDriverWait wait = new WebDriverWait(driver, 30);

             // Click Analytics Engine
             WebElement stats = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/statistics.svg']")));
             stats.click();
             System.out.println("Statistics icon clicked successfully.");

             // Enter Query: "greater than 10"
             WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
             searchBox.sendKeys("Hippocampus region\n");
             Thread.sleep(5000);
             System.out.println("The Query 'Hippocampus region is entered successfully");

             // Call dbBrainQuery API (POST request)
             System.out.println("Calling statistic query...");
             Response dbQueryResponse = RestAssured.given()
                 .contentType(ContentType.JSON)
                 .body("{\"query\": \"Hippocampus region\"}") // Ensure proper payload
                 .get("https://apollo2.humanbrain.in/atlas/get_stats?query=hippocampus%20region");

             String apiResponse = dbQueryResponse.getBody().asString();
             int apiStatus = dbQueryResponse.getStatusCode();
             System.out.println("statistics API Response: " + apiStatus + " - " + apiResponse);

             // Validate API response
             Assert.assertEquals(apiStatus, 200, "API response status is incorrect!");

             // Only validate expected data if API response contains it
             if (apiResponse.contains("expected_data_here")) {
                 System.out.println("API response contains expected data.");
             } else {
                 System.out.println("Warning: Expected data not found in API response.");
             }

             Thread.sleep(3000);

             // Validate and Click 'Age greater than' text
             try {
                 WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Definition:']")));
                 String actualText = textElement.getText();
                 Assert.assertEquals(actualText, "Definition:", "Text does not match!");

                 Thread.sleep(3000);
                 textElement.click();
                 System.out.println("Text matches and was clicked successfully: " + actualText);
             } catch (Exception e) {
                 System.err.println("Failed to click the text: " + e.getMessage());
             }
         } catch (Exception e) {
             System.err.println("An error occurred: " + e.getMessage());
         } 
//    	 try {
//             WebDriverWait wait = new WebDriverWait(driver, 60);
//             Actions actions = new Actions(driver);
//
//             // Locate the last element (Copy button)
//             WebElement copy = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='/viewer/assets/images/colorsvg/copynote.svg']")));
//
//             // Scroll to the element
//             actions.moveToElement(copy).perform();
//             System.out.println("Scrolled to the copy button.");
//             Thread.sleep(3000);
//
//             // Wait and Click the Copy button
//             wait.until(ExpectedConditions.elementToBeClickable(copy)).click();
//             System.out.println("The copy button clicked");
//         } catch (Exception e) {
//             System.err.println("The copy button is not clicked: " + e.getMessage());
//         } 
    	 try {
	            WebDriverWait wait = new WebDriverWait(driver, 30);
	            WebElement refresh= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/refresh.svg']")));
	            Thread.sleep(3000);
	            refresh.click();
	            System.out.println("The refresh button clicked");
	        } catch (Exception e) {
	            System.err.println("The refresh button is not clicked: " + e.getMessage());
	        }
    
    
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully");
        }
    }
}
