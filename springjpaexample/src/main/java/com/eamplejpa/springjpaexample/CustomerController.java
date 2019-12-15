package com.eamplejpa.springjpaexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	
    @GetMapping("/get/{id}")
    public Customer getCoursesByInstructor(@PathVariable(value = "id") Long id){
    	Customer customer = customerRepository.findById(1L);
        return customer;
    }
    
    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {
    	return customerRepository.save(customer);
    }

}
