package com.example.repotest;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.validation.constraints.Null;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.entity.Customer;

import com.example.repository.CustomerRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CustomerRepositoryTest {
	
	@Autowired
	private CustomerRepository repo;
		
	@Test
	@Rollback(false)
	public void TestCustomer(){
			Customer customer =new Customer(1, "deepak@gmail.com", "male", "Deepak", null);
			Customer saveCustomer =repo.save(customer);
			repo.save(customer);
			
			assertNotNull(saveCustomer);
			
		}
	

	
	@Test
	@Rollback(false)
	void TestUpdateCustomer() {
		Customer customer =new Customer(5, "rohitk@gmail.com", "male", "Rohit", null);
		Customer saveCustomer =repo.save(customer);
		repo.save(customer);
		
		assertNotNull(saveCustomer);	
	}
	
	@Test
	void TestCustomerId() {
		// testEntityManager.persist(new Student(11, "a", "a@gmail.com"));
		Customer customer = repo.findById(1).get();
		assertThat(customer.getEmail()).isEqualTo("male");
	}			
		
}

