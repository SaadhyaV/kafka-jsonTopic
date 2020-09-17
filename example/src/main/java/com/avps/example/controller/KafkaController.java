package com.avps.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avps.example.model.User;
import com.avps.example.service.Producer;

@RestController
public class KafkaController {

	private final Producer producer;

	@Autowired
	public KafkaController(Producer producer) {
		this.producer = producer;
	}

//	@RequestMapping(value = "/publish", method = RequestMethod.POST)
//	public void messageToTopic(@RequestParam("message") String message) {
//		this.producer.sendMessages(message);
//	}

//	private static User u = new User();
//	@CrossOrigin(origins = "http://localhost:8085")

	@CrossOrigin(origins = "*")
	@PostMapping(path = "/publish", produces = "application/json")
	public String messageToTopic(@RequestBody User user) {
		System.out.println(user + " /  " + user.getFirstname());
		this.producer.sendMessages(user);
		return "Received User data";
	}


//	new User(user.getFirstname(), user.getLastname())
//	headers = "Accept=application/json", 
	@RequestMapping("/view")
	public String newMeth() {
		return "Hello view";
	}
}

