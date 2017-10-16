package com.mathworks.util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

public class Common {

	public static HttpPost postrequest;
	public static HttpPut putrequest;
	public static HttpGet getrequest;
	public static HttpDelete deleterequest;
	public static HttpResponse response;
	public static int responsecode;

	public static HttpResponse getResponse() {
		return response;
	}

	public static void setResponse(HttpResponse response) {
		Common.response = response;
	}

	public static StringEntity params;
	public static Object responsestring;
	
	public String json_xmlTostring(String path) {
		String jsonData = "";
		BufferedReader br = null;
		try {
			String line;
			// "D:\\New folder\\RetailRest\\src\\test\\resource\\addProduct.json"
			br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
				jsonData += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return jsonData;
	}
}
