package com.example.week02_work6;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpClientApplication {

	public static void main(String[] args) throws Exception{
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		String url = "http://localhost:8801";

		CloseableHttpClient httpClient = httpClientBuilder.build();

		HttpGet httpGet = new HttpGet(url);

		CloseableHttpResponse response = httpClient.execute(httpGet);

		if (response.getStatusLine().getStatusCode() == 200) {
			System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
		}
	}

}
