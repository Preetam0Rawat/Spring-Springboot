package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("/say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are u doing";
	}
	
	@RequestMapping("/say-hello-html") 
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb =new StringBuffer();
		
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My first HTML page </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("Body of my html page");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
	
	//JSP    
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/welcome.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
	@RequestMapping("/say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}