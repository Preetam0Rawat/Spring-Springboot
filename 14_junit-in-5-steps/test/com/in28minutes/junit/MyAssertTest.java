package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {
	
	List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

	@Test
	void testAsserts() {
		
		boolean test = todos.contains("AWS");
      assertTrue(test);
      assertEquals(3, todos.size());
	}

}
