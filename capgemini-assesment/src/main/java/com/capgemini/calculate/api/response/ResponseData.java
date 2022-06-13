package com.capgemini.calculate.api.response;

public class ResponseData {

	private final String output;
	
	public ResponseData(String response) {
		this.output = response;
	}

	public String getOutput() {
		return output;
	}
}
