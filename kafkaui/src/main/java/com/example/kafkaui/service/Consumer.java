package com.example.kafkaui.service;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	@KafkaListener(topics = "test_topic", groupId = "group_id")
	public void ConsumerMessage(String message) {
		System.out.println("Message from UI : " + message);

		HttpClient httpclient = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("http://localhost:9002/sendback");

		String msg = message + " received";
		System.out.println(msg);
//			JSONObject msgJson = new JSONObject(msg);
//			JSONObject candidateJson = new JSONObject(cJson);
//			StringEntity input = new StringEntity(msgJson.toString());
//			input.setContentType("application/json");
//			post.setEntity(input);
//
		try {
			HttpResponse response = httpclient.execute(post);
			System.out.println("Response : " + response);
		} catch (IOException e) {
			e.printStackTrace();
		}
//
//			System.out.println("input : " + input + "json " + msgJson);
//			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//			StringBuilder sb = new StringBuilder();
//			String line = "";
//			while ((line = rd.readLine()) != null) {
//				sb.append(line);
//			}
//			String jsonOutput = sb.toString();
	}

}
