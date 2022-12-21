package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Customer;
import com.example.entity.Product;
import com.example.repository.CustomerRepository;
import com.example.repository.ProductRepository;
import com.example.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{


		@Autowired
		private CustomerRepository customerRepository;
		
		@Autowired
	    private ProductRepository productRepository;

		@Override
		public Customer postCustomer(Customer c) {

			return customerRepository.save(c);
		}

		@Override
		public Customer getCustomer(int id) {
			// TODO Auto-generated method stub
			return customerRepository.findById(id).get();
		}

		@Override
		public List<Product> getAllCustomers() {
			// TODO Auto-generated method stub
			return productRepository.findAll();
		}

		@Override
		public Customer updateCustomer(Customer params, int id) {
			// TODO Auto-generated method stub
			Customer _customer = customerRepository.findById(id).get();
			_customer.setName(params.getName());
			_customer.setEmail(params.getEmail());
			return customerRepository.save(_customer);
		}

		@Override
		public String deleteCustomer(int id) {
			// TODO Auto-generated method stub
			customerRepository.deleteById(id);
			return "the customer with id " + id + " has been deleted...";
		}
}
