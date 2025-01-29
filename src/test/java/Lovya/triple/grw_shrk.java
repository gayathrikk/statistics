package Lovya.triple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

public class grw_shrk {
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
		System.out.println("The server is Opened sucessfully");
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
		System.out.println("Mail I'd is entered");
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
			System.out.println("The Dashboard is not Click");
		}
		try {
			WebDriverWait wait7 = new WebDriverWait(driver, 30);
			WebElement AtlasDashboard = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Atlas Dashboard']")));
			AtlasDashboard.click();			
			Thread.sleep(3000);
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Atlas Dashboard Click Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Atlas Dashboard is not Click");
		}
		try {
			WebDriverWait wait8 = new WebDriverWait(driver, 30);
			WebElement Bio = wait8.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[3]")));
			Bio.sendKeys("222");				
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Bio Sample Entered Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Bio Sample is not Entered Successfully");
		}
		try {
			WebDriverWait wait9 = new WebDriverWait(driver, 30);
			WebElement ref = wait9.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[4]")));
			ref.sendKeys("1000");				
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Ref SecNO Entered Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Ref SecNO is not Entered Successfully");
		}
		try {
			WebDriverWait wait11 = new WebDriverWait(driver, 30);
			WebElement Current = wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[5]")));
			Current.sendKeys("1003");		
			Thread.sleep(5000);
			System.out.println("------------------------*****************-----------------------");
			System.out.println("The Current Section Number clicked Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Current Section Number not clicked");
		}
		try {
			WebDriverWait wait12 = new WebDriverWait(driver, 30);
			WebElement search = wait12.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@size='small'])[2]")));
			search.click();		
			Thread.sleep(5000);
			System.out.println("------------------------*****************-----------------------");
			System.out.println("The Search Button clicked Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The search Button not clicked");
		}
		try {
		    // Make API request to growthShrinkage endpoint
		    URL url = new URL("https://apollo2.humanbrain.in/atlas/growthShrinkage");
		    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		    connection.setRequestMethod("POST");
		    
		    // Check if the response code is 200 (OK)
		    int responseCode = connection.getResponseCode();
		    if (responseCode == HttpURLConnection.HTTP_OK) {
		        // Success: Read the response
		        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		        String inputLine;
		        StringBuffer response = new StringBuffer();
		        while ((inputLine = in.readLine()) != null) {
		            response.append(inputLine);
		        }
		        in.close();
		        // Print the API response
		        System.out.println("API Response: " + response.toString());
		    } else {
		        // Error: Log the error code and message
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

		 Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }}
	       
	    			 
	
		@AfterTest
		public void tearDown() {
			if (driver != null) {
				driver.quit();
			}
		}}
