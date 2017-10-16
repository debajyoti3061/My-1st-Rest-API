package com.mathworks.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;


import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class RestClient {

	public HttpClient client = HttpClientBuilder.create().build();

	public void exegetRequest(HttpGet getrequest) throws ClientProtocolException, IOException {
		Common.response = client.execute(getrequest);
		Common.responsecode = Common.getResponse().getStatusLine().getStatusCode();
		Common.responsestring = EntityUtils.toString(Common.response.getEntity());
		//read();
	}

	public void exepostRequest(HttpPost postrequest) throws ClientProtocolException, IOException {
		Common.response = client.execute(postrequest);
		Common.responsecode = Common.getResponse().getStatusLine().getStatusCode();
		Common.responsestring = EntityUtils.toString(Common.response.getEntity());
	}

	public void exeputRequest(HttpPut putrequest) throws ClientProtocolException, IOException {
		Common.response = client.execute(putrequest);
		Common.responsecode = Common.getResponse().getStatusLine().getStatusCode();
		Common.responsestring = EntityUtils.toString(Common.response.getEntity());
	}

	public void exedeleteRequest(HttpDelete deleterequest) throws ClientProtocolException, IOException {
		Common.response = client.execute(deleterequest);
		Common.responsecode = Common.getResponse().getStatusLine().getStatusCode();
		Common.responsestring = EntityUtils.toString(Common.response.getEntity());
	}
	
	public void read() throws IllegalStateException, IOException{
	BufferedReader rd = new BufferedReader(new InputStreamReader(Common.response
			.getEntity().getContent()));
	String line = "";
	while ((line = rd.readLine()) != null) {
		System.out.println(line);
	}

	System.out.println("---------------------");
	
	Header[] headers = Common.response.getAllHeaders();
	for (int i = 0; i < headers.length; i++) {
		System.out.println(headers[i]);

	}
	}
}
