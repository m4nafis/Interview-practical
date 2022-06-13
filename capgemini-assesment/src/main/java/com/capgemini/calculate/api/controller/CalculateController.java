package com.capgemini.calculate.api.controller;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;

import com.capgemini.calculate.api.response.ResponseData;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CalculateController {

	
	@GetMapping("/calculate")
	public ResponseData calculate(@RequestParam(value = "data") int[] values) {
		//Validation for no input value
		if (values == null) {
			return new ResponseData("Invalid Request: No request data found.");
		}
		
		//Validation if less than 3 numeric inputs are entered
		if (values.length < 3) {
			return new ResponseData("Invalid Request: Array of numeric inputs is less than 3 integers.");
		}
		
		//Sum calculation using Java Stream
		int sum = Arrays.stream(values).sorted().skip(values.length - 3).map(x -> x * x).sum(); 
		
		//Return result in 2 decimal format
		DecimalFormat formatter = new DecimalFormat();
		formatter.setMaximumFractionDigits(2);
		String result = formatter.format(Math.sqrt(sum));
		
		return new ResponseData(result);
	}
	
	
}
