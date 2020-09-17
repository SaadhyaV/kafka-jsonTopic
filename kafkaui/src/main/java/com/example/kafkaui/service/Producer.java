package com.example.kafkaui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

	private static final String TOPIC = "test_topic2";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessages(String message) {
		this.kafkaTemplate.send(TOPIC, message);
	}
}