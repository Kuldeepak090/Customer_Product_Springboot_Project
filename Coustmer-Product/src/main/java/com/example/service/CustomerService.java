package com.example.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entity.Customer;
import com.example.entity.Product;

@Component
public interface CustomerService {
	
	Customer postCustomer(Customer s);

	Customer getCustomer(int id);

	List<Product> getAllCustomers();

	Customer updateCustomer(Customer params, int id);

	String deleteCustomer(int id);

}
