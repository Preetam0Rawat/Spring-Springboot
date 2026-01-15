package com.in28minutes.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBeforeAfterTest {
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("Before all");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("After all");
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("Before each test");
	}
	
	
	@AfterEach
	void afterEach() {
		System.out.println("After each test");
	}
	
	@Test
	void test1() {
		System.out.println("Test 1");	
	}
	
	@Test
	void test2() {
		System.out.println("Test 2");	
	}

	@Test
	void test3() {
		System.out.println("Test 3");	
	}

}
