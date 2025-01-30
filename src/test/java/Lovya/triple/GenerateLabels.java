package Lovya.triple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GenerateLabels {
	private RemoteWebDriver driver;

	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://172.20.23.92:4444/wd/hub");
		driver = new RemoteWebDriver(url, dc);
	}
	  @Test(priority = 1)
	    public void login() throws InterruptedException {
	        driver.get("http://apollo2.humanbrain.in/");
	        driver.manage().window().maximize();
	        System.out.println("The server is opened successfully");

	        WebDriverWait wait = new WebDriverWait(driver, 50);
	        try {
	            WebElement viewerSectionLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/gallery.svg']")));
	            viewerSectionLink.click();
	            System.out.println("The Viewer Icon is clicked");

	            String parentWindow = driver.getWindowHandle();
	            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
	            loginButton.click();
	            System.out.println("The login Button is clicked");

	            Set<String> allWindows = driver.getWindowHandles();
	            for (String window : allWindows) {
	                if (!window.equals(parentWindow)) {
	                    driver.switchTo().window(window);
	                    break;
	                }
	            }

	            WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
	            emailInput.sendKeys("softwaretestingteam9@gmail.com");
	            System.out.println("Mail ID is entered");

	            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	            nextButton.click();
	            System.out.println("The Next Button is clicked");

	            WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
	            passwordInput.sendKeys("Health#123");
	            System.out.println("Password is entered");

	            WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	            nextButton2.click();
	            System.out.println("The Next Button is clicked");

	            driver.switchTo().window(parentWindow);
	            Thread.sleep(5000);

	        } catch (NoSuchElementException e) {
	            System.err.println("Element not found: " + e.getMessage());
	        } catch (Exception e) {
	            System.err.println("An error occurred: " + e.getMessage());
	        }
	    }

	    @Test(priority = 2)
	    public void table() throws InterruptedException {
	        String parentWindow = driver.getWindowHandle();
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, 30);
	            WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search tags']")));
	            searchInput.sendKeys("AC\n");
	            Thread.sleep(3000);
	            System.out.println("The number Entered Successfully");
	        } catch (Exception e) {
	            System.err.println("The number is not Entered successfully: " + e.getMessage());
	        }

	        try {
	            WebDriverWait wait = new WebDriverWait(driver, 30);
	            WebElement atlasEditorButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-icon[@nbtooltip='Atlas Editor']")));
	            atlasEditorButton.click();
	            Thread.sleep(3000);
	            System.out.println("The Atlas Editor is clicked");
	        } catch (Exception e) {
	            System.err.println("The Atlas Editor is not clicked: " + e.getMessage());
	        }

	        Thread.sleep(4000);
	        Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }
	    }

	    @Test(priority = 3)
	    public void directDrawPage() throws InterruptedException {
	        try {
	            Actions actions = new Actions(driver);
	            actions.keyDown(Keys.SHIFT).sendKeys("m").keyUp(Keys.SHIFT).build().perform();
	            System.out.println("Action executed successfully!");
	            Thread.sleep(3000);
	        } catch (Exception e) {
	            System.err.println("Error executing action: " + e.getMessage());
	        }
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, 60);
	            WebElement c= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-accordion-item-header[text()='Contributors']")));
	            c.click();
	            Thread.sleep(3000);
	          
	            System.out.println("The  Contributor is clicked");
	        } catch (Exception e) {
	            System.err.println("The Contributor is not clicked: " + e.getMessage());
	        }
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, 30);
	            WebElement radio2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='radio'])[2]")));
	            radio2.click();
	            Thread.sleep(3000);
	            Thread.sleep(3000);
	            System.out.println("The Label Contributor is clicked");
	        } catch (Exception e) {
	            System.err.println("The Label Contributor is not clicked: " + e.getMessage());
	        }

	        try {
	            Actions actions = new Actions(driver);
	            actions.keyDown(Keys.SHIFT).sendKeys("o").keyUp(Keys.SHIFT).build().perform();
	            System.out.println("Action executed successfully!");
	            Thread.sleep(3000);
	        } catch (Exception e) {
	            System.err.println("Error executing action: " + e.getMessage());
	        }
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, 30);
	            WebElement b = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Unlock']")));
	            b.click();
	            Thread.sleep(3000);
	            System.out.println("The Unlock button is clicked");
	        } catch (Exception e) {
	            System.err.println("The Unlock button is not clicked: " + e.getMessage());
	        }
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, 30);
	            WebElement radio3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/label.svg']")));
	            radio3.click();
	            Thread.sleep(3000);
	            System.out.println("The Label Generator is clicked");
	        } catch (Exception e) {
	            System.err.println("The Label Generator is not clicked: " + e.getMessage());
	        }
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, 30);
	            WebElement proceed = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Proceed']")));
	            proceed.click();
	            Thread.sleep(3000);
	            System.out.println("The Proceed icon is clicked");
	        } catch (Exception e) {
	            System.err.println("The Proceed icon is not clicked: " + e.getMessage());
	        }
	        try {
	            URL url = new URL("https://apollo2.humanbrain.in/atlas/annotationLabel_view");
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("POST");

	            int responseCode = connection.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) {
	                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	                String inputLine;
	                StringBuffer response = new StringBuffer();
	                while ((inputLine = in.readLine()) != null) {
	                    response.append(inputLine);
	                }
	                in.close();
	                System.out.println("API Response: " + response.toString());
	            } else {
	                System.out.println("API Request Failed. HTTP Error Code: " + responseCode);
	                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
	                String inputLine;
	                StringBuffer errorResponse = new StringBuffer();
	                while ((inputLine = in.readLine()) != null) {
	                    errorResponse.append(inputLine);
	                }
	                in.close();
	                System.out.println("API Error Response: " + errorResponse.toString());
	            }

	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    
	        
	    }

	    @AfterTest
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}
