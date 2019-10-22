package com.mahi.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloController2 {
	
	@RequestMapping("/showForm")
	public String displayTheForm(){
		return "hello-world";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree( @RequestParam("studentName") String name, Model model){
		// read the name from html form
		//String name = request.getParameter("studentName");
		
		//convert the name to upper case
		String result = name.toUpperCase();
		
		//create message
		result = "Yo! "+result;
		
		//add message to the model
		model.addAttribute("message", result);
		return "helloworld";
	}
}
