package com.mahi.springdemo.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mahi.springdemo.entity.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();
}
