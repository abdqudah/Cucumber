package com.qa.util;

import java.io.IOException;


import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;



public class RestClient {
	
	
	//GetMethod
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient= HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); //HTTP get request
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget); // hit the get URL
		
		return closeableHttpResponse;
		
		/*int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		
		JSONObject resposeJson = new JSONObject(responseString);
		System.out.println(resposeJson);
		
		
		//org.apache.http.Header[] headerArray=closeableHttpResponse.getAllHeaders();*/
		
		
	
	}

}
