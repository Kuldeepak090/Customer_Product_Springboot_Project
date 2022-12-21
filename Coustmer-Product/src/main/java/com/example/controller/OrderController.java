package com.example.controller;

import java.util.List;

import javax.persistence.Id;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.OrderRequest;
import com.example.dto.OrderResponse;
import com.example.entity.Customer;
import com.example.entity.Product;
import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import com.example.repository.ProductRepository;
import com.example.service.CustomerService;




@RestController
public class OrderController {
	
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
	private CustomerService customerService;
    
    
    @PostMapping(value = "/placeOrder")
	public Customer addController(@RequestBody Customer customer) {
		return customerService.postCustomer(customer);
	}

	// get a customer
	@GetMapping(value = "/getOrder/{id}")
	public Customer getController(@PathVariable int id) {
		return customerService.getCustomer(id);
	}


	
	@GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

	// update a customer
	@PutMapping(value = "/updateOrder/{id}")
	public Customer updateController(@PathVariable int id, @RequestBody Customer customer) {
		return customerService.updateCustomer(customer, id);
	}

	// delete a customer

	@DeleteMapping(value = "/deleteOrder/{id}")
	public String deleteController(@PathVariable int id) {
		return customerService.deleteCustomer(id);
	}

	// add a customer (with ResponseEntity)
	@PostMapping("/customersValid")
	public ResponseEntity<Customer> addValidCustomer(@Valid @RequestBody Customer p) {
		Customer savedCustomer = customerService.postCustomer(p);
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);

	}

}