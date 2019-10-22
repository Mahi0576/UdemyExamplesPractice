package com.mahi.springmvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// add initbinder.. it preprocesses every string from data coming from web requests
	// removes leading and trailing whitespaces
	// If string has only whitespaces.. trim it null
	@InitBinder
	public void initbinder(WebDataBinder dataBinder){
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model){
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
		System.out.println("First Name: |"+customer.getFirstName()+"|");
		System.out.println("Binding result: "+bindingResult);
		System.out.println("\n\n\n");
		if(bindingResult.hasErrors())
			return "customer-form";
		else
			return "customer-confirmation";
	}
	
}
