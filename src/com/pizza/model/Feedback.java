package com.pizza.model;

public class Feedback {

	private String feedbackID;
	
	private String email;
	
	private String feedback;
	
	private String DateTime;

	public Feedback() {
		super();
	}



	public Feedback(String feedbackID, String email, String feedback, String dateTime) {
		super();
		this.feedbackID = feedbackID;
		this.email = email;
		this.feedback = feedback;
		DateTime = dateTime;
	}



	public String getFeedbackID() {
		return feedbackID;
	}



	public void setFeedbackID(String feedbackID) {
		this.feedbackID = feedbackID;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}
	
	
}
