package com.mahi.springmvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model model){
		//create student obj
		Student student = new Student();
		
		// add student obj to model
		model.addAttribute("student",student);
		
		 // add the country options to the model 
	    model.addAttribute("countryOptions", countryOptions);
		
		// return student reg form
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student){
		//log the input data
		System.out.println("the student: "+student.getFirstName()+" "+student.getLastName());
		
		return "student-confirmation";
		
	}
}
