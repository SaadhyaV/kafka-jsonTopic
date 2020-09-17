package com.example.kafkaui.model;

public class User {

//	private String topic;
	private String firstname;
	private String lastname;


	// standard getters and setters

//	public String getTopic() {
//		return topic;
//	}
//
//	public String setTopic(String topic) {
//		this.topic = topic;
//		return topic;
//	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + "]";
	}


}
