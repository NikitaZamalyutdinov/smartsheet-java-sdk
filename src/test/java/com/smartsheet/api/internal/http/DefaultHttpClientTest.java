package com.smartsheet.api.internal.http;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringBufferInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class DefaultHttpClientTest {
	HttpClient client;
	
	@Before
	public void setUp() throws Exception {
		client = new DefaultHttpClient();
	}

	@Test
	public void testDefaultHttpClient() {}

	@Test
	public void testDefaultHttpClientCloseableHttpClient() { }

	@Test
	public void testRequest() throws HttpClientException, URISyntaxException {
		// Null Argument
		try {
			client.request(null);
			fail("Exception should have been thrown");
		} catch (IllegalArgumentException e) {
			// Expected
		}

		HttpRequest request = new HttpRequest();
		
		// No URL in request
		try {
			client.request(request);
			
			fail("Exception should have been thrown");
		} catch (IllegalArgumentException e) {
			// Expected
		}
		
		// Test each http method
		request.setUri(new URI("http://google.com"));
		request.setMethod(HttpMethod.GET);
		client.request(request);
		
		request.setMethod(HttpMethod.POST);
		client.request(request);

		client.request(request);
		request.setMethod(HttpMethod.PUT);
		client.request(request);
		
		request.setMethod(HttpMethod.DELETE);
		client.request(request);
		
		
		// Test request with set headers and http entity but a null content
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("name","value");
		HttpEntity entity = new HttpEntity();
		entity.setContentType("text/html; charset=ISO-8859-4");
		request.setEntity(entity);
		request.setHeaders(headers);
		request.setMethod(HttpMethod.POST);
		client.request(request);
		
		// Test request with set headers and http entity and some content
		entity.setContent(new StringBufferInputStream("Hello World!"));
		request.setEntity(entity);
		client.request(request);
		
		// Test Client Protocol Exception by passing a second content-length
		try{
			headers.put("Content-Length","10");
			request.setHeaders(headers);
			client.request(request);
			fail("Exception should have been thrown");
		}catch(HttpClientException ex){
			// Expected
		}finally{
			headers.remove("Content-Length");
			request.setHeaders(headers);
		}
		
		// Test IOException
		try{
			request.setUri(new URI("http://bad.domain"));
			client.request(request);
			fail("Exception should have been thrown.");
		}catch(HttpClientException ex){
			// Expected
		}
		
		
	}

}