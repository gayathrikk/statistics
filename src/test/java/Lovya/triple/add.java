package Lovya.triple;
import java.net.MalformedURLException;
import org.testng.annotations.Test;


import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class add {
	 private RemoteWebDriver driver;
		
		@BeforeTest
		
		public void setup() throws MalformedURLException 
		{
			
			  DesiredCapabilities dc = DesiredCapabilities.chrome();
		        URL url = new URL("http://172.20.23.92:4443/wd/hub");
		        driver = new RemoteWebDriver(url, dc);
		
		       
		}
	//	
		//@Parameters("URL")
		@Test(priority=1)
		public void login(@Optional("defaultURL") String URL) throws InterruptedException
		//public void login()throws InterruptedException
		{
			//driver.get(URL);
			driver.get("https://apollo2.humanbrain.in/viewer/annotation/portal");
			driver.manage().window().maximize();
	        String currentURL = driver.getCurrentUrl();
	        System.out.println("Current URL: " + currentURL);
			WebDriverWait wait = new WebDriverWait(driver, 10);
	    	driver.switchTo().defaultContent(); // Switch back to default content
	    	WebElement viewerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='/viewer/assets/images/colorsvg/gallery.svg']")));
	    	if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
	    	    viewerElement.click();
	    	    System.out.println("Viewer icon is clicked");
	    	} else {
	    	    System.out.println("Viewer icon is not clickable");
	    	}
	    	checkConsoleLog();
	
	        String parentWindow = driver.getWindowHandle();
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
	        if (loginButton != null) {
	            loginButton.click();
	            System.out.println("Login button clicked successfully.");
	        } else {
	            System.out.println("Login button is not clicked.");
	        }
	        checkConsoleLog();
		  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		  Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }
	        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
	        if (emailInput != null && emailInput.isDisplayed()) {
	            emailInput.sendKeys("softwaretestingteam9@gmail.com");
	            System.out.println("Email was entered successfully.");
	        } else {
	           System.out.println("Email was not entered.");
	        }
	        checkConsoleLog();
	
	        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	        if (nextButton1 != null) {
	            nextButton1.click();
	            System.out.println("Next button 1 is clicked.");
	        } else {
	            System.out.println("Next button 1 is not clicked.");
	        }
	        checkConsoleLog();
	        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
	        passwordInput.sendKeys("Health#123");
	        if (passwordInput.getAttribute("value").equals("Health#123")) {
	            System.out.println("Password was entered successfully.");
	        } else {
	            System.out.println("Password was not entered.");
	        }
	        checkConsoleLog();
	        
	        WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	        if (nextButton2 != null) {
	            nextButton2.click();
	            System.out.println("Next button 2 is clicked.");
	        } else {
	            System.out.println("Next button 2 is not clicked.");
	        }
	        checkConsoleLog();
	
	        driver.switchTo().window(parentWindow);
	        System.out.println("Login successfully");
	        checkConsoleLog();
	        Loginpage_API();
	        System.out.println("************************Login validation done***********************");
		        
		}
		
		@Test(priority=2)
		public void series_set() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			driver.switchTo().defaultContent();
	
			
	    	 try {
	    		    WebElement Mouse = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@role='grid']//tr[6]")));
	    		    Mouse.click();
	    		    System.out.println("Human Fetus clicked successfully.");
	    		    Thread.sleep(2000);
	    		} catch (Exception e) {
	    		    System.out.println("Human Fetus not clicked: " + e.getMessage());
	    		}
	    	 checkConsoleLog();
	    	 
	    	 try {
	    		    WebElement Brain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@role='grid']//tr[7]//td[2]")));
	    		    Brain.click();
	    		    System.out.println(" Brain clicked successfully.");
	    		    Thread.sleep(2000);
	    		} catch (Exception e) {
	    		    System.out.println("Brain not clicked: " + e.getMessage());
	    		}
	    	 checkConsoleLog();
	    	 
	    	 try {
	 		    WebElement MTB_10 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@role='grid']//tr[25]//td[3]")));
	 		    MTB_10.click();
	 		    System.out.println("FTB-40 clicked successfully.");
	 		    Thread.sleep(2000);
	 		} catch (Exception e) {
	 		    System.out.println(" FTB-40 not clicked: " + e.getMessage());
	 		}
	    	 checkConsoleLog();
	    	 
	    	 String parentWindow = driver.getWindowHandle();
	    	 try {
		 		    WebElement viewericon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-icon[@nbtooltip='Viewer']")));
		 		   viewericon.click();
		 		    System.out.println("viewer icon is clicked successfully.");
		 		    Thread.sleep(2000);
		 		} catch (Exception e) {
		 		    System.out.println(" viewer icon is not clicked: " + e.getMessage());
		 		}
	    	 
	    	 wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			  Set<String> allWindows = driver.getWindowHandles();
		        for (String window : allWindows) {
		            if (!window.equals(parentWindow)) {
		                driver.switchTo().window(window);
		                break;
		            }
		        }
	    	 
	    	 try {
	  		    WebElement section = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='883'])[1]")));
	  		    section.click();
	  		    System.out.println("section clicked successfully.");
	  		    Thread.sleep(2000);
	  		} catch (Exception e) {
	  		    System.out.println("section not clicked: " + e.getMessage());
	  		}
	    	 
	    	 checkConsoleLog();
	    	 seriesset_API();
	    	 System.out.println("************************************Series set validation done********************************");
	
	 	}
		
		@Test(priority=3)
		
		public void atlaseditor() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			driver.switchTo().defaultContent();
			 try {
		  		    WebElement atlaseditor= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Atlas Editor']")));
		  		    atlaseditor.click();
		  		    System.out.println("Atlas Editor open");
		  		    Thread.sleep(2000);
		  		} catch (Exception e) {
		  		    System.out.println("Atlas Editor is not open: " + e.getMessage());
		  		}
			 Thread.sleep(6000);
			 checkConsoleLog();
			 Atlas_API();
			 System.out.println("************************Atlas Editor open sucessfully***********************");
			 Thread.sleep(6000);
			 
		}
		@Test(priority=4)
		public void Editmenu() throws InterruptedException
		{
	
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			driver.switchTo().defaultContent();
			 try {
		  		    WebElement Editmenu= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Edit Menu']")));
		  		    Editmenu.click();
		  		    System.out.println("Edit menu open successfully.");
		  		    Thread.sleep(2000);
		  		} catch (Exception e) {
		  		    System.out.println("Edit menu is not open: " + e.getMessage());
		  		}
			 checkConsoleLog();
		}
		@Test(priority=5)
		public void contributor() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			driver.switchTo().defaultContent();
			 try {
		  		    WebElement contributor= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//nb-icon[@pack='nebular-essentials'])[2]")));
		  		    contributor.click();
		  		    System.out.println("contributor option open successfully.");
		  		    Thread.sleep(2000);
		  		} catch (Exception e) {
		  		    System.out.println("contributor option is not open: " + e.getMessage());
		  		}
			 checkConsoleLog();
			 
			 try {
		  		    WebElement contributor= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='radio'])[2]")));
		  		    contributor.click();
		  		    System.out.println("contributor selected successfully.");
		  		    Thread.sleep(2000);
		  		} catch (Exception e) {
		  		    System.out.println("contributor is not selected : " + e.getMessage());
		  		}
			 checkConsoleLog();
		}
		@Test(priority=6)
		public void draw() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			driver.switchTo().defaultContent();
			try {
	  		    WebElement draw= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Draw']")));
	  		    draw.click();
	  		    System.out.println("Draw option selected successfully.");
	  		    Thread.sleep(2000);
	  		} catch (Exception e) {
	  		    System.out.println("Draw option is not open: " + e.getMessage());
	  		}
		 checkConsoleLog();
		}
		
		@Test(priority=7)
		public void annotation() throws InterruptedException
		{
			
			clickElementByXpath("(//nb-icon[@pack='nebular-essentials'])[2]", "Annotation option");
	    	clickElementByXpath("(//i[@role='presentation'])[1]", "node1");
	    	 clickElementByXpath("(//i[@role='presentation'])[4]", "node2");
	    	 clickElementByXpath("(//i[@role='presentation'])[7]", "node3");
	    	 clickElementByXpath("(//i[@role='presentation'])[11]", "node4");
			
			 WebElement canvas = driver.findElement(By.xpath("//canvas"));
		     Actions actions = new Actions(driver);
		        
		        clickElementByXpath("//a[@title='Add']", "Add");
		        
		        actions.moveToElement(canvas)
	            .click()
	            .moveByOffset(200, 0)
	            .click()
	            .moveByOffset(0, 200)
	            .click()
	            .moveByOffset(-200, 0)
	            .click()
	            .moveByOffset(0, -200)
	            .click()
	            .release()
	            .perform();
		        Thread.sleep(5000);
		        checkConsoleLog();
		        System.out.println("Annotation completed");
		}
		@Test(priority=8)
		public void save() throws InterruptedException
		{
			clickElementByXpath("//a[@title='Save']", "save");
			WebDriverWait deleteWait = new WebDriverWait(driver, 100);
			By toasterLocator = By.xpath("//div[text()='Successfully saved the regions']");
			WebElement toasterElement = deleteWait.until(ExpectedConditions.presenceOfElementLocated(toasterLocator));
			String toasterMessage = toasterElement.getText();
			AssertJUnit.assertEquals("Successfully saved the regions", toasterMessage);
			Thread.sleep(2000);
			checkConsoleLog();
			Save_API();
			System.out.println("*******************Saved the regions successfully************************");
	
		}
		@Test(priority=9)
		public void back() throws InterruptedException
		{
			clickElementByXpath("//a[@title='Close']", "close");
			clickElementByXpath("//a[@title='Back']", "Back ");
			
		}
		@Test(priority=10)
		public void retrive() throws InterruptedException
		{
			clickElementByXpath("(//span[text()='883'])[1]", "section ");
			clickElementByXpath("//a[@title='Atlas Editor']", "Atlas Editor");
			Thread.sleep(3000);
			clickElementByXpath("//img[@src='/viewer/assets/images/colorsvg/oldmenu.svg']", "Edit menu");
			clickElementByXpath("(//nb-icon[@pack='nebular-essentials'])[2]", "Contributor option"); 
			clickElementByXpath("(//input[@type='radio'])[2]", "Contributor"); 
			String nonenode=driver.findElement(By.xpath("(//div[@class='paragraph'])[2]")).getText();
			 System.out.println("None node="+nonenode);
			clickElementByXpath("(//nb-icon[@pack='nebular-essentials'])[3]", "Annotation option");
			clickElementByXpath("(//i[@role='presentation'])[1]", "node1");
	    	 clickElementByXpath("(//i[@role='presentation'])[4]", "node2");
	    	 clickElementByXpath("(//i[@role='presentation'])[7]", "node3");
	    	 clickElementByXpath("(//i[@role='presentation'])[11]", "node4");
			String selectednode=driver.findElement(By.xpath("(//div[@class='paragraph'])[2] ")).getText();
			 System.out.println("Selected node="+selectednode);
			Assert.assertNotEquals(nonenode, selectednode);
			System.out.println("*******************saved node retrived successfully************************");
			Thread.sleep(4000);
			 
		}
		@Test(priority=11)
		public void delete() throws InterruptedException
		{
			clickElementByXpath("//a[@title='Draw']", "Draw");
			WebElement canvas = driver.findElement(By.xpath("//canvas"));
			Actions actions = new Actions(driver);
			int centerX = 0; 
			int centerY = 0; 
	
			
			actions.moveToElement(canvas, centerX, centerY)
			        .click()
			        .perform();
//			Thread.sleep(2000);
//			 clickElementByXpath("(//i[@role='presentation'])[11]", "node4");
	
			Thread.sleep(2000);
			clickElementByXpath("//a[@title='Delete']", "Delete option");
			clickElementByXpath("//button[text()='Delete']", "Delete button");
			clickElementByXpath("//a[@title='Save']", "save");
			clickElementByXpath("//a[@title='Close']", "close");
			clickElementByXpath("//a[@title='Back']", "Back ");
			System.out.println("*******************Annotated data deleted successfully**************************");
		}
		
		private void clickElementByXpath(String xpath, String elementName) {
	        try {
	        	WebDriverWait wait = new WebDriverWait(driver, 30);
	            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	            element.click();
	            System.out.println(elementName + " clicked");
	            Thread.sleep(2000);
	        } catch (Exception e) {
	            System.out.println(elementName + " not clicked: " + e.getMessage());
	        }
		}
		private void Loginpage_API()
	    {	
	    	//getLoginUser API
	    	 String jsonBody = "{\"user_name\":\"software team\",\"user_hash\":\"106900966448254245591\",\"email\":\"teamsoftware457@gmail.com\",\"image\":\"https://lh3.googleusercontent.com/a/ACg8ocJ98wDtdlOS-ADlQ2n_WnL1iY7vWcGr8bWfkxU-9ntv=s96-c\"}";
	    	 Response response = RestAssured
	             .given()
	                 .auth()
	                 .preemptive()
	                 .basic("admin", "admin")
	                 .contentType(ContentType.JSON)
	                 .body(jsonBody)
	             .when()
	                 .post("https://apollo2.humanbrain.in/CC/getLoginUser");
	    	 int statusCode = response.getStatusCode();
	    	 if (statusCode == 200) {
	             System.out.println("API request to getLoginUser passed. Status code: " + statusCode);
	         } else {
	             System.out.println("API request to getLoginUser failed. Status code: " + statusCode);
	         }
	         Assert.assertEquals(statusCode, 200, "API request to getLoginUser failed");
	         
	        //Activity API
	         String jsonBody1 = "{\"user\":\"124\",\"action\":\"Login\",\"info\":\" \"}";
	    	 Response response1 = RestAssured
	             .given()
	                 .auth()
	                 .preemptive()
	                 .basic("admin", "admin")
	                 .contentType(ContentType.JSON)
	                 .body(jsonBody1)
	             .when()
	                 .post("https://apollo2.humanbrain.in/activities/Activity/");
	    	 int statusCode1 = response1.getStatusCode();
	    	 if (statusCode1 == 201) {
	             System.out.println("API request to Activity passed. Status code: " + statusCode1);
	         } else {
	             System.out.println("API request to Activity failed. Status code: " + statusCode1);
	         }
	         Assert.assertEquals(statusCode1, 201, "API request to Activity failed");  
	         
	         
	    }
		
		  private void seriesset_API()
		    {	
		    	//series set
		    	 Response response = RestAssured.get("https://apollo2.humanbrain.in/CC/getDetailsOfSeriesStatsAllRestricted/106900966448254245591");
		         int statusCode = response.getStatusCode();
		         if (statusCode == 200) {
		             System.out.println("API request to the series set page passed. Status code: " + statusCode);
		         } else {
		             System.out.println("API request to the series set failed. Status code: " + statusCode);
		         }
		         Assert.assertEquals(statusCode, 200, "API request to the series set failed");
		         
		         
		         //Brain access activity
		         String jsonBody1 = "{\"user\":124,\"action\":\"Brain Access\",\"info\":\"Brain Id - 16\"}";
		    	 Response response1 = RestAssured
		             .given()
		                 .auth()
		                 .preemptive()
		                 .basic("admin", "admin")
		                 .contentType(ContentType.JSON)
		                 .body(jsonBody1)
		             .when()
		                 .post("https://apollo2.humanbrain.in/activities/Activity/");
		    	 int statusCode1 = response1.getStatusCode();
		    	 if (statusCode1 == 201) {
		             System.out.println("API request to Brainaccess Activity passed. Status code: " + statusCode1);
		         } else {
		             System.out.println("API request to Brainaccess Activity failed. Status code: " + statusCode1);
		         }
		         Assert.assertEquals(statusCode1, 201, "API request to Activity failed");  
		         
		         //Get thumbnails details
		         Response response2 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainThumbNailDetails/IIT/V1/SS-16:-1:-1");
		         int statusCode2 = response2.getStatusCode();
		         if (statusCode2 == 200) {
		             System.out.println("API request to the thumbnails details of series set page passed. Status code: " + statusCode2);
		         } else {
		             System.out.println("API request to the thumbnails details of series set failed. Status code: " + statusCode2);
		         }
		         Assert.assertEquals(statusCode2, 200, "API request to the thumbnails details of series set failed");
		         
		         //Get brain viewer deatils
		         Response response3 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainViewerDetails/IIT/V1/SS-16:-1:-1");
		         int statusCode3 = response3.getStatusCode();
		         if (statusCode3 == 200) {
		             System.out.println("API request to the brain viewer details of series set page passed. Status code: " + statusCode3);
		         } else {
		             System.out.println("API request to the brain viewer details of series set failed. Status code: " + statusCode3);
		         }
		         Assert.assertEquals(statusCode3, 200, "API request to the brain viewer details of series set failed");
		         
		    }
		  private void Atlas_API()
		    {
		    	//app atlas registration
		    	Response response1 = RestAssured
		    		    .given()
		    		    .auth()
		    		    .basic("admin", "admin")
		    		    .when()
		    		    .get("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/7832/");
	
		        int statusCode1 = response1.getStatusCode();
		        if (statusCode1 == 200) {
		            System.out.println("API request to the appatlas registration of Atlas Editor passed. Status code: " + statusCode1);
		        } else {
		            System.out.println("API request to the appatlas registration of Atlas Editor failed. Status code: " + statusCode1);
		        }
		        Assert.assertEquals(statusCode1, 200, "API request to the appatlas registration of Atlas Editor failed");
		        
		        //Atlas brain viewer details
		        Response response2 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainViewerDetails/IIT/V1/SS-15:10:1006");
		        int statusCode2 = response2.getStatusCode();
		        if (statusCode2 == 200) {
		            System.out.println("API request to the brain viewer details of Atlas page passed. Status code: " + statusCode2);
		        } else {
		            System.out.println("API request to the brain viewer details of Atlas page failed. Status code: " + statusCode2);
		        }
		        Assert.assertEquals(statusCode2, 200, "API request to the brain viewer details of Atlas page failed");
		        
		        //Get contributors details
		        Response response3 = RestAssured
		    		    .given()
		    		    .auth()
		    		    .basic("admin", "admin")
		    		    .when()
		    		    .get("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/?externalkey=FlatTree::IIT:V1:SS-15:10:1006:1006&annotationtype=6");
	
		        int statusCode3 = response3.getStatusCode();
		        if (statusCode3 == 200) {
		            System.out.println("API request to get contributors details of Atlas page passed. Status code: " + statusCode3);
		        } else {
		            System.out.println("API request to get contributors details of Atlas page failed. Status code: " + statusCode3);
		        }
		        Assert.assertEquals(statusCode3, 200, "API request to get contributors details of Atlas page failed");
		        
		       //Atlas app annotation type
		        Response response4 = RestAssured
		    		    .given()
		    		    .auth()
		    		    .basic("admin", "admin")
		    		    .when()
		    		    .get("https://apollo2.humanbrain.in/BR/AppAnnotationType/");
		        int statusCode4 = response4.getStatusCode();
		        if (statusCode4 == 200) {
		            System.out.println("API request to get app annotation type details of Atlas page passed. Status code: " + statusCode4);
		        } else {
		            System.out.println("API request to get app annotation type details of Atlas page failed. Status code: " + statusCode4);
		        }
		        Assert.assertEquals(statusCode4, 200, "API request to get app annotation type details of Atlas page failed");
		        
		   }
		  private void Save_API()
		  {
			  String jsonBody1 = "{\"atlasgeojson\":\"{\\\"type\\\":\\\"FeatureCollection\\\",\\\"features\\\":[{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[11279.499999999996,-10917.914976724238],[18923.202828517624,-10917.914976724238],[18923.202828517624,-18561.617805241865],[11279.499999999996,-18561.617805241865],[11279.499999999996,-10917.914976724238]]]},\\\"properties\\\":{\\\"data\\\":{\\\"text\\\":\\\"Cerebellum\\\",\\\"id\\\":\\\"500\\\",\\\"part_ID\\\":\\\"500\\\",\\\"name\\\":\\\"Cerebellum\\\",\\\"acronym\\\":\\\"CB\\\",\\\"type (gray matter/fiber tract/CNS cavity/developmental/other)\\\":\\\"G\\\",\\\"parent_structure_id\\\":\\\"1\\\",\\\"color_hex_triplet\\\":\\\"FFB3B3\\\"}},\\\"id\\\":\\\"298\\\"}],\\\"rotation\\\":0}\",\"accessdetails\":\"[{\\\"order\\\":0,\\\"key\\\":\\\"NISSL\\\",\\\"url\\\":\\\"https://apollo2.humanbrain.in/iipsrv/fcgi-bin/iipsrv.fcgi?FIF=/data/storageIIT/humanbrain/analytics/52/NISL/B_52_MTB10-SL_63-ST_NISL-SE_382_compressed.jp2&WID=1024&RGBGAMA&JTL={z},{tileIndex}\\\",\\\"name\\\":\\\"NISSL\\\",\\\"type\\\":\\\"titleLayer\\\",\\\"height\\\":24664,\\\"width\\\":22559,\\\"red\\\":{\\\"min\\\":0,\\\"max\\\":255},\\\"green\\\":{\\\"min\\\":0,\\\"max\\\":255},\\\"blue\\\":{\\\"min\\\":0,\\\"max\\\":255},\\\"gama\\\":1.4,\\\"opacity\\\":0.9,\\\"rigidrotation\\\":0,\\\"family\\\":\\\"brain\\\",\\\"sublayers\\\":[],\\\"trsdata\\\":null,\\\"export_status\\\":0,\\\"sectionid\\\":\\\"SS-16:12:382\\\"}]\",\"userid\":\"{\\\"id\\\":\\\"UFdBXLmKPTTVYLLxzkwKBm03XhY2\\\",\\\"name\\\":\\\"software team\\\",\\\"photo\\\":\\\"https://lh3.googleusercontent.com/a/AAcHTte--G1vkdrm_ojhRzgIsEpuDHA-4loc7lX1bl-XensG=s96-c\\\"}\",\"id\":21659,\"externalkey\":\"FlatTree::IIT:V1:SS-16:12:382:382\",\"annotationtype\":194,\"annotationtype_id\":194}";
			     Response response1 = RestAssured
		             .given()
		                 .auth()
		                 .preemptive()
		                 .basic("admin", "admin")
		                 .contentType(ContentType.JSON)
		                 .body(jsonBody1)
		             .when()
		                 .patch("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/21659/");
		    	 int statusCode1 = response1.getStatusCode();
		    	 if (statusCode1 == 200) {
		             System.out.println("API request to save annotation passed. Status code: " + statusCode1);
		         } else {
		             System.out.println("API request to save annotation failed. Status code: " + statusCode1);
		         }
		         Assert.assertEquals(statusCode1, 200, "API request to save annotation failed");  
		  }
		  
		private void checkConsoleLog() {
	        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	        List<LogEntry> logs = logEntries.filter(Level.SEVERE);
	
	        int severeLogCount = logs.size();
	        System.out.println("Number of SEVERE-level logs: " + severeLogCount);
	
	        for (LogEntry log : logs) {
	            System.out.println("Level is : \n" + log.getLevel());
	            System.out.println("Message is : \n" + log.getMessage());
	        }
	        }
	
		@AfterTest
		public void close() throws Exception
		{
			
			driver.quit();
	
	}
	
	}