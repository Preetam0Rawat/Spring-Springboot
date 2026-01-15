package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	//private AuthenticationService authenticationService;
	
	//private Logger logger = LoggerFactory.getLogger(getClass());	
//	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
//		model.put("name", name);
//		logger.debug("Request param is {}",name);
//		return "login";
//	}
//	
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

	@RequestMapping(value="/", method= RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedInUsername());		
		return "welcome";
	}
	
	//To get name of currently logged user
	private String getLoggedInUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
		
	}
	
	// not needed as we are about to use springsecurity
//	@RequestMapping(value="login", method= RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		model.put("name", name);		
//		//Authentication
//		// name -in28minutes
//		// password - dummy
//		if(authenticationService.authenticate(name, password)) {
//			return "welcome";
//			
//		}
//		model.put("errorMessage", "Invalid credentials, please try again");
//		return "login";
//	}
}
