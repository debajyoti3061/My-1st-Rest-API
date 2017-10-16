package com.mathworks.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.mathworks.util.Common;
import com.mathworks.util.RestClient;

public class ServiceIntegrationTest{
	Common common = new Common();
	RestClient restClient = new RestClient();
	public StringEntity params;
	
	@Test
	public void gettest() throws ClientProtocolException, IOException{
		Common.getrequest = new HttpGet("http://localhost:8082/JaxRsApp/webapi/messages");
		restClient.exegetRequest(Common.getrequest);
		System.out.println(Common.responsecode);
	    System.out.println(Common.responsestring);
		Assert.assertEquals(200, Common.responsecode);
	}
	@Test
	public void getbyId() throws ClientProtocolException, IOException{
		Common.getrequest = new HttpGet("http://localhost:8082/JaxRsApp/webapi/messages/1");
		restClient.exegetRequest(Common.getrequest);
		System.out.println(Common.responsecode);
		System.out.println(Common.responsestring);
		Assert.assertEquals(200, Common.responsecode);
	}
	@Test
	public void posttest() throws ClientProtocolException, IOException{
		Common.postrequest = new HttpPost("http://localhost:8082/JaxRsApp/webapi/messages");
		Common.postrequest.addHeader("content-type", "application/json");
		String inputJson = common
				.json_xmlTostring("C:\\dmahapat_JaxRsApp\\test-integration\\src\\test\\java\\com\\mathworks\\util\\post1.json");
		params = new StringEntity(inputJson);
		Common.postrequest.setEntity(params);
		restClient.exepostRequest(Common.postrequest);
		System.out.println(Common.responsecode);
		System.out.println(Common.responsestring);
		Assert.assertEquals(200, Common.responsecode);
	}
	
	@Test
	public void puttest() throws ClientProtocolException, IOException{
		Common.putrequest = new HttpPut("http://localhost:8082/JaxRsApp/webapi/messages/3");
		Common.putrequest.addHeader("content-type", "application/json");
		String inputJson = common
				.json_xmlTostring("C:\\dmahapat_JaxRsApp\\test-integration\\src\\test\\java\\com\\mathworks\\util\\put1.json");
		params = new StringEntity(inputJson);
		Common.putrequest.setEntity(params);
		restClient.exeputRequest(Common.putrequest);
		System.out.println(Common.responsecode);
		System.out.println(Common.responsestring);
		Assert.assertEquals(200, Common.responsecode);
	}
	
/*	@Test
	public void deletetest() throws ClientProtocolException, IOException{
		Common.deleterequest = new HttpDelete(
				"http://localhost:8082/JaxRsApp/webapi/messages/1");
		restClient.exedeleteRequest(Common.deleterequest);
		System.out.println(Common.responsecode);
		System.out.println(Common.responsestring);
		Assert.assertEquals(200, Common.responsecode);
	}*/
}
