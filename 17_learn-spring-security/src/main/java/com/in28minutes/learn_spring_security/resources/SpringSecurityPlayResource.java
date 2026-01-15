package com.in28minutes.learn_spring_security.resources;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SpringSecurityPlayResource {

	@GetMapping("/csrf-token")
	public CsrfToken retrieveCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
}

//csrf token
//qnfuGBkYkBrqVw5hqvBG0InxC4ufGVgztfe8XhhzbPSwE5etnEaNLix78S7HNGwAnt1ys-zDJrP6KTse0JKKay9KW5LTIKLP
//Use this along your post request as header