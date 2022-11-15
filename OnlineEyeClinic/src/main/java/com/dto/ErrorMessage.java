package com.dto;

import java.time.LocalDateTime;

public class ErrorMessage {
	private LocalDateTime date;
	private String errorMsg;
	private String validationMsg;
	public LocalDateTime getDate() {
		return date;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public String getValidationMsg() {
		return validationMsg;
	}
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(LocalDateTime date, String errorMsg, String validationMsg) {
		super();
		this.date = date;
		this.errorMsg = errorMsg;
		this.validationMsg = validationMsg;
	}
	public ErrorMessage(LocalDateTime date, String errorMsg) {
		super();
		this.date = date;
		this.errorMsg = errorMsg;
	}

}
