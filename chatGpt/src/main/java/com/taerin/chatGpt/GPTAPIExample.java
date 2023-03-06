package com.taerin.chatGpt;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GPTAPIExample {

	 private static final String API_KEY = "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";
	    private static final String API_ENDPOINT = "https://api.openai.com/v1/completions";
	    
	    public static void main(String[] args) throws IOException {
	        String prompt = "Summarize this for a second-grade student: Jupiter is the fifth planet from the Sun and the largest in the Solar System. It is a gas giant with a mass one-thousandth that of the Sun, but two-and-a-half times that of all the other planets in the Solar System combined. Jupiter is one of the brightest objects visible to the naked eye in the night sky, and has been known to ancient civilizations since before recorded history. It is named after the Roman god Jupiter.[19] When viewed from Earth, Jupiter can be bright enough for its reflected light to cast visible shadows,[20] and is on average the third-brightest natural object in the night sky after the Moon and Venus.";
	        String model = "text-davinci-003";
	        int maxTokens = 64;
	        String response = getGPTResponse(prompt, model, maxTokens);
	        System.out.println(response);
	    }
	    
	    public static String getGPTResponse(String prompt, String model, int maxTokens) throws IOException {
	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        HttpPost httpPost = new HttpPost(API_ENDPOINT);
	        httpPost.setHeader("Content-type", "application/json");
	        httpPost.setHeader("Authorization", "Bearer " + API_KEY);
	        
	        StringEntity entity = new StringEntity("{\n" +
	                "    \"prompt\": \"" + prompt + "\",\n" +
	                "    \"max_tokens\": " + maxTokens + ",\n" +
	                "    \"model\": \"" + model + "\"\n" +
	                "}", ContentType.APPLICATION_JSON);
	        httpPost.setEntity(entity);
	        
	        CloseableHttpResponse response = httpClient.execute(httpPost);
	        HttpEntity responseEntity = response.getEntity();
	        String result = EntityUtils.toString(responseEntity);
	        response.close();
	        httpClient.close();
	        
	        return result;
	    }
}
