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

public class research {
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
	            WebElement analyticsIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/research.svg']")));
	            analyticsIcon.click();
	            System.out.println("Research icon clicked successfully.");

	            // Call saveSearchHistory API
	            System.out.println("Calling saveSearchHistory API...");
	            Response saveSearchResponse = RestAssured.given()
	                .get("https://apollo2.humanbrain.in/analytics/getSearchHistory?user_id=193");
	            System.out.println("saveSearchHistory API Response: " + saveSearchResponse.getStatusCode() + " - " + saveSearchResponse.getBody().asString());

	            // Enter Query
	            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
	            searchBox.sendKeys("where is cerebellum in brain?\n");
	            Thread.sleep(5000);
	            System.out.println("The Query is entered successfully");

	            // Call db_query API
	            System.out.println("Calling db_query API...");
	            Response dbQueryResponse = RestAssured.given()
	                .queryParam("query", "greater than 10")
	                .get("https://apollo2.humanbrain.in/analytics/getSearchHistory?user_id=193");
	            System.out.println("db_query API Response: " + dbQueryResponse.getStatusCode() + " - " + dbQueryResponse.getBody().asString());

	            // Download Button
	            
	            // Call getSearchHistory API
	            System.out.println("Calling getSearchHistory API...");
	            Response searchHistoryResponse = RestAssured.given()
	                .queryParam("user_id", "193")
	                .get("https://apollo2.humanbrain.in/analytics/getSearchHistory?user_id=193");
	            System.out.println("getSearchHistory API Response: " + searchHistoryResponse.getStatusCode() + " - " + searchHistoryResponse.getBody().asString());

	        } catch (Exception e) {
	            System.err.println("An error occurred in AnalyticsEngine test: " + e.getMessage());
	        }  Thread.sleep(3000);
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, 30);
	            WebElement c= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://api.semanticscholar.org/CorpusID:198986633']")));
	            Thread.sleep(3000);
	            c.click();
	            System.out.println("The Link is clicked");
	        } catch (Exception e) {
	            System.err.println("The Link is not clicked: " + e.getMessage());
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
