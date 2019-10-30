package com.mahi.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mahi.springdemo.dao.CustomerDao;
import com.mahi.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject the customer dao
	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping("/list")
	public String listCustomers(Model model){
		
		//get customers from dao
		List<Customer> customers = customerDao.getCustomers();
		
		//add the customers to the model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
}
