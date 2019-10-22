package com.mahi.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	//need a controller method to show intial HTML form
	@RequestMapping("/showForm")
	public String showForm(){
		return "hello-world";
	}
	
	//need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm(){
		return "helloworld";
	}
	
	//need a controller method to read the data
	@RequestMapping("/processFormVersionTwo")
	public String readData(HttpServletRequest request, Model model){
		// read the name from html form
		String name = request.getParameter("studentName");
		
		//convert the name to upper case
		String result = name.toUpperCase();
		
		//create message
		result = "Yo! "+result;
		
		//add message to the model
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree( @RequestParam("srudentName") String name, Model model){
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
