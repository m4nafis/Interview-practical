package com.capgemini.calculate.api.controller;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.capgemini.calculate.api.controller.CalculateController;
import com.capgemini.calculate.api.response.ResponseData;

class CalculateControllerTest {

	@Test
	//Unit test for correct output
	void testCalculate() {
		int[] values = {5, 4, 6, 1};
		CalculateController controller = new CalculateController();
		ResponseData response = controller.calculate(values);
		assertTrue(response.getOutput().equals("8.77"));
	}
	
	//Unit test for less than 2 input
	void testLessDigit() {
		int[] values = {5,6};
		CalculateController controller = new CalculateController();
		ResponseData response = controller.calculate(values);
		assertTrue(response.getOutput().equals("Invalid Request: Array of numeric inputs is less than 3 integers."));
	}
	
	//Unit test for null input
	void testNull() {
		int[] values = null;
		CalculateController controller = new CalculateController();
		ResponseData response = controller.calculate(values);
		assertTrue(response.getOutput().equals("Invalid Request: No request data found."));
	}

}
