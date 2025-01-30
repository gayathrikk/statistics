package Lovya.triple;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.classic.HttpPost;
import org.apache.hc.client5.http.impl.classic.HttpGet;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.apache.http.impl.client.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
public class LLMAPI {
	 @Test
	    public void testSaveSearchHistoryPost() {
	        String apiUrl = "https://apollo2.humanbrain.in/analytics/saveSearchHistory";
	        
	        HttpPost postRequest = new HttpPost(apiUrl);
	        // Set the entity if needed (for example, add JSON body here)
	        // postRequest.setEntity(new StringEntity("{\"key\":\"value\"}", ContentType.APPLICATION_JSON));
	        
	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            CloseableHttpResponse response = httpClient.execute(postRequest);
	            int statusCode = response.getCode();
	            Assert.assertEquals(statusCode, 200, "Expected HTTP Status Code 200 but got: " + statusCode);
	        } catch (IOException e) {
	            Assert.fail("API request failed with error: " + e.getMessage());
	        }
	    }

	    // POST test case for tagsectionsearch
	    @Test
	    public void testTagSectionSearchPost() {
	        String apiUrl = "https://apollo2.humanbrain.in/analytics/tagsectionsearch";
	        
	        HttpPost postRequest = new HttpPost(apiUrl);
	        
	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            CloseableHttpResponse response = httpClient.execute(postRequest);
	            int statusCode = response.getCode();
	            Assert.assertEquals(statusCode, 200, "Expected HTTP Status Code 200 but got: " + statusCode);
	        } catch (IOException e) {
	            Assert.fail("API request failed with error: " + e.getMessage());
	        }
	    }

	    // POST test case for tagbrainsearch
	    @Test
	    public void testTagBrainSearchPost() {
	        String apiUrl = "https://apollo2.humanbrain.in/analytics/tagbrainsearch";
	        
	        HttpPost postRequest = new HttpPost(apiUrl);
	        
	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            CloseableHttpResponse response = httpClient.execute(postRequest);
	            int statusCode = response.getCode();
	            Assert.assertEquals(statusCode, 200, "Expected HTTP Status Code 200 but got: " + statusCode);
	        } catch (IOException e) {
	            Assert.fail("API request failed with error: " + e.getMessage());
	        }
	    }

	    // POST test case for tagAtlasSearch
	    @Test
	    public void testTagAtlasSearchPost() {
	        String apiUrl = "https://apollo2.humanbrain.in/analytics/tagAtlasSearch";
	        
	        HttpPost postRequest = new HttpPost(apiUrl);
	        
	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            CloseableHttpResponse response = httpClient.execute(postRequest);
	            int statusCode = response.getCode();
	            Assert.assertEquals(statusCode, 200, "Expected HTTP Status Code 200 but got: " + statusCode);
	        } catch (IOException e) {
	            Assert.fail("API request failed with error: " + e.getMessage());
	        }
	    }

	    // POST test case for tagtilesearch
	    @Test
	    public void testTagTileSearchPost() {
	        String apiUrl = "https://apollo2.humanbrain.in/analytics/tagtilesearch";
	        
	        HttpPost postRequest = new HttpPost(apiUrl);
	        
	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            CloseableHttpResponse response = httpClient.execute(postRequest);
	            int statusCode = response.getCode();
	            Assert.assertEquals(statusCode, 200, "Expected HTTP Status Code 200 but got: " + statusCode);
	        } catch (IOException e) {
	            Assert.fail("API request failed with error: " + e.getMessage());
	        }
	    }

	    // POST test case for tagOntologySearch
	    @Test
	    public void testTagOntologySearchPost() {
	        String apiUrl = "https://apollo2.humanbrain.in/analytics/tagOntologySearch";
	        
	        HttpPost postRequest = new HttpPost(apiUrl);
	        
	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            CloseableHttpResponse response = httpClient.execute(postRequest);
	            int statusCode = response.getCode();
	            Assert.assertEquals(statusCode, 200, "Expected HTTP Status Code 200 but got: " + statusCode);
	        } catch (IOException e) {
	            Assert.fail("API request failed with error: " + e.getMessage());
	        }
	    }

	    // POST test case for getSearchHistory with user_id=193
	    @Test
	    public void testGetSearchHistoryPost() {
	        String apiUrl = "https://apollo2.humanbrain.in/analytics/getSearchHistory?user_id=193";
	        
	        HttpPost postRequest = new HttpPost(apiUrl);
	        
	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            CloseableHttpResponse response = httpClient.execute(postRequest);
	            int statusCode = response.getCode();
	            Assert.assertEquals(statusCode, 200, "Expected HTTP Status Code 200 but got: " + statusCode);
	        } catch (IOException e) {
	            Assert.fail("API request failed with error: " + e.getMessage());
	        }
	    }

	    // GET test case for saveSearchHistory
	    @Test
	    public void testSaveSearchHistoryGet() {
	        String apiUrl = "https://apollo2.humanbrain.in/analytics/saveSearchHistory";
	        
	        HttpGet getRequest = new HttpGet(apiUrl);
	        
	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            CloseableHttpResponse response = httpClient.execute(getRequest);
	            int statusCode = response.getCode();
	            Assert.assertEquals(statusCode, 200, "Expected HTTP Status Code 200 but got: " + statusCode);
	        } catch (IOException e) {
	            Assert.fail("API request failed with error: " + e.getMessage());
	        }
	    }

	    // GET test case for getSearchHistory with user_id=193
	    @Test
	    public void testGetSearchHistoryGet() {
	        String apiUrl = "https://apollo2.humanbrain.in/analytics/getSearchHistory?user_id=193";
	        
	        HttpGet getRequest = new HttpGet(apiUrl);
	        
	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            CloseableHttpResponse response = httpClient.execute(getRequest);
	            int statusCode = response.getCode();
	            Assert.assertEquals(statusCode, 200, "Expected HTTP Status Code 200 but got: " + statusCode);
	        } catch (IOException e) {
	            Assert.fail("API request failed with error: " + e.getMessage());
	        }
	    }

	    // GET test case for db_query with a specific query
	    @Test
	    public void testDbQueryGet() {
	        String apiUrl = "https://apollo2.humanbrain.in/analyticsengine/db_query?query=where%20is%20cerebellum%20in%20brain?";
	        
	        HttpGet getRequest = new HttpGet(apiUrl);
	        
	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            CloseableHttpResponse response = httpClient.execute(getRequest);
	            int statusCode = response.getCode();
	            Assert.assertEquals(statusCode, 200, "Expected HTTP Status Code 200 but got: " + statusCode);
	        } catch (IOException e) {
	            Assert.fail("API request failed with error: " + e.getMessage());
	        }
	    }

	    // GET test case for get_stats with hippocampus query
	    @Test
	    public void testGetStatsGet() {
	        String apiUrl = "https://apollo2.humanbrain.in/atlas/get_stats?query=hippocampus";
	        
	        HttpGet getRequest = new HttpGet(apiUrl);
	        
	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            CloseableHttpResponse response = httpClient.execute(getRequest);
	            int statusCode = response.getCode();
	            Assert.assertEquals(statusCode, 200, "Expected HTTP Status Code 200 but got: " + statusCode);
	        } catch (IOException e) {
	            Assert.fail("API request failed with error: " + e.getMessage());
	        }
	    }

	    // POST test case for dbBrainQuery
	    @Test
	    public void testDbBrainQueryPost() {
	        String apiUrl = "https://apollo2.humanbrain.in/analytics/dbBrainQuery";
	        
	        HttpPost postRequest = new HttpPost(apiUrl);
	        
	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            CloseableHttpResponse response = httpClient.execute(postRequest);
	            int statusCode = response.getCode();
	            Assert.assertEquals(statusCode, 200, "Expected HTTP Status Code 200 but got: " + statusCode);
	        } catch (IOException e) {
	            Assert.fail("API request failed with error: " + e.getMessage());
	        }
	    }
	}
