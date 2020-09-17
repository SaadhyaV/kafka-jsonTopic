package com.example.kafkaui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaui.service.Producer;

@RestController
public class KafkaController {

	private final Producer producer;

	@Autowired
	public KafkaController(Producer producer) {
		this.producer = producer;
	}

//	public void messageToTopic(@RequestParam("message") String message) {

//	@CrossOrigin(origins = "http://localhost:8084")
//	@RequestMapping(value = "/sendback", method = RequestMethod.POST )

	@PostMapping(path = "/sendback", produces = "application/json")
	public void messageToTopic() {
		String msg = "Recieved your firstname";
		this.producer.sendMessages(msg);
		System.out.println("line 29 " + msg);
	}

	@RequestMapping("/view")
	public String newMeth() {
		return "Hello view";
	}
}
