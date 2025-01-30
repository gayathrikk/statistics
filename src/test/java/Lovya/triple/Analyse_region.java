package Lovya.triple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Analyse_region {
    private RemoteWebDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        URL url = new URL("http://172.20.23.92:4444/wd/hub");
        driver = new RemoteWebDriver(url, dc);
    }

    @Test(priority = 1)
    public void Login() throws InterruptedException {
        driver.get("http://apollo2.humanbrain.in");
        driver.manage().window().maximize();
        System.out.println("The server is Opened successfully");
        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement viewerSectionLink = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/gallery.svg']")));
        viewerSectionLink.click();
        System.out.println("The Viewer Icon is clicked");
        String parentWindow = driver.getWindowHandle();
        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        WebElement login = wait1
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
        login.click();
        System.out.println("The login Button is clicked");
        Thread.sleep(4000);
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        Thread.sleep(4000);
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        WebElement emailInput = wait2
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
        emailInput.sendKeys("softwaretestingteam9@gmail.com");
        System.out.println("Mail ID is entered");
        WebDriverWait wait3 = new WebDriverWait(driver, 20);
        WebElement Next = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        Next.click();
        System.out.println("The Next Button is clicked");
        WebDriverWait wait4 = new WebDriverWait(driver, 20);
        WebElement PasswordInput = wait4
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        PasswordInput.sendKeys("Health#123");
        System.out.println("Password is entered");
        WebDriverWait wait5 = new WebDriverWait(driver, 20);
        WebElement Next2 = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        Next2.click();
        System.out.println("The Next Button is clicked");
        Thread.sleep(5000);
        driver.switchTo().window(parentWindow);
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void table() throws InterruptedException {
        String parentWindow = driver.getWindowHandle();
        try {
            WebDriverWait wait6 = new WebDriverWait(driver, 30);
            WebElement Atlas = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/cellreports.svg']")));
            Atlas.click();
            Thread.sleep(3000);
            System.out.println("--------------------------*****************-----------------------");
            System.out.println("The Dashboard Click Successfully");
        } catch (Exception e) {
            System.out.println("--------------------------*****************-----------------------");
            System.out.println("The Dashboard is not Clicked");
        }
        try {
            WebDriverWait wait7 = new WebDriverWait(driver, 30);
            WebElement AtlasDashboard = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Atlas Dashboard']")));
            AtlasDashboard.click();
            Thread.sleep(3000);
            System.out.println("--------------------------*****************-----------------------");
            System.out.println("The Atlas Dashboard Clicked Successfully");
        } catch (Exception e) {
            System.out.println("--------------------------*****************-----------------------");
            System.out.println("The Atlas Dashboard is not Clicked");
        }
        try {
            WebDriverWait wait8 = new WebDriverWait(driver, 30);
            WebElement Bio = wait8.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[6]")));
            Bio.sendKeys("{\"brain_ids\":{\"142\":[751],\"213\":[1204,2095]},\"ontology_id\":189}");
            System.out.println("--------------------------*****************-----------------------");
            System.out.println("The Reference Entered Successfully");
        } catch (Exception e) {
            System.out.println("--------------------------*****************-----------------------");
            System.out.println("The Reference is not Entered Successfully");
        }
        try {
            WebDriverWait wait9 = new WebDriverWait(driver, 30);
            WebElement ref = wait9.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[7]")));
            ref.sendKeys("{\"brain_ids\": { \"222\": [1000], \"201\": [1648, 1651] }, \"ontology_id\": 189}");
            System.out.println("--------------------------*****************-----------------------");
            System.out.println("The Ref SecNO Entered Successfully");
        } catch (Exception e) {
            System.out.println("--------------------------*****************-----------------------");
            System.out.println("The Ref SecNO is not Entered Successfully");
        }

        try {
            WebDriverWait wait12 = new WebDriverWait(driver, 30);
            WebElement search = wait12.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@size='small'])[3]")));
            search.click();
            Thread.sleep(5000);
            System.out.println("------------------------*****************-----------------------");
            System.out.println("The Search Button Clicked Successfully");
        } catch (Exception e) {
            System.out.println("--------------------------*****************-----------------------");
            System.out.println("The Search Button is not Clicked");
        }

////        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
////        for (int i = 0; i < iframes.size(); i++) {
////            try {
////                // Switch to the iframe using its index
////                driver.switchTo().frame(i);
////
////                // Try finding the element inside the iframe
////                WebElement element = driver.findElement(By.xpath("//td[text()='Superior olive']"));
////
////                if (element.isDisplayed()) {
////                    // If the element is found and displayed, proceed with assertions
////                    String actualText = element.getText();
////                    Assert.assertEquals("Test case failed: The text does not match.", "Superior olive", actualText);
////                    System.out.println("Test passed: The text matches 'Superior olive'.");
////                    break; // Exit loop if element is found
////                }
////            } catch (NoSuchElementException e) {
////                // If element not found in this iframe, continue to the next iframe
////                System.out.println("Element not found in iframe index " + i);
////            }
//        }
        // Make API request to growthShrinkage endpoint
        try {
            URL url = new URL("https://apollo2.humanbrain.in/atlas/compareAtlasRegion");
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
