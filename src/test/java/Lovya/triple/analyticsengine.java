package Lovya.triple;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class analyticsengine {
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
	    	    WebElement analyticsIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/analytics_engine.svg']")));
	    	    analyticsIcon.click();
	    	    System.out.println("Analytics Engine icon clicked successfully.");

	    	    // Call saveSearchHistory API
	    	    System.out.println("Calling saveSearchHistory API...");
	    	    Response saveSearchResponse = RestAssured.given()
	    	        .post("https://apollo2.humanbrain.in/analytics/saveSearchHistory");
	    	    System.out.println("saveSearchHistory API Response: " + saveSearchResponse.getStatusCode() + " - " + saveSearchResponse.getBody().asString());

	    	    // Enter Query
	    	    WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
	    	    searchBox.sendKeys("greater than 10\n");
	    	    Thread.sleep(5000);
	    	    System.out.println("The Query is entered successfully");

	    	    // Call db_query API
	    	    System.out.println("Calling db_query API...");
	    	    Response dbQueryResponse = RestAssured.given()
	    	        .queryParam("query", "greater than 10")
	    	        .get("https://apollo2.humanbrain.in/analyticsengine/db_query");
	    	    System.out.println("db_query API Response: " + dbQueryResponse.getStatusCode() + " - " + dbQueryResponse.getBody().asString());

	    	    // Validate Text 'Fetal brain 34'
	    	    WebElement resultTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[text()='Fetal brain 34'])[1]")));
	    	    String actualText = resultTextElement.getText();
	    	    String expectedText = "Fetal brain 34";

	    	    if (!actualText.equals(expectedText)) {
	    	        throw new AssertionError("Validation failed! Expected text: '" + expectedText + "', but found: '" + actualText + "'");
	    	    }
	    	    System.out.println("Validation passed: 'Fetal brain 34' text is displayed correctly.");

	    	    // Download Button
	    	    WebDriverWait wait3 = new WebDriverWait(driver, 60);
	    	    WebElement download = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@src='/viewer/assets/images/colorsvg/download.svg'])[1]")));
	    	    download.click();
	    	    System.out.println("Download button clicked successfully.");

	    	    // Call getSearchHistory API
	    	    System.out.println("Calling getSearchHistory API...");
	    	    Response searchHistoryResponse = RestAssured.given()
	    	        .queryParam("user_id", "193")
	    	        .get("https://apollo2.humanbrain.in/analytics/getSearchHistory");
	    	    System.out.println("getSearchHistory API Response: " + searchHistoryResponse.getStatusCode() + " - " + searchHistoryResponse.getBody().asString());

	    	} catch (AssertionError e) {
	    	    System.err.println("Test case failed: " + e.getMessage());
	    	    throw e; // Rethrow the assertion error to mark the test as failed
	    	} catch (Exception e) {
	    	    System.err.println("An error occurred in AnalyticsEngine test: " + e.getMessage());
	    	}}
	    @AfterTest
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	            System.out.println("Browser closed successfully");
	        }
	    }
	}
