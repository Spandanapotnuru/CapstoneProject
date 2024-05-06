package com.capstoneproject.mobilestore.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstoneproject.mobilestore.Entity.Customer;
import com.capstoneproject.mobilestore.Service.CustomerService;



@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
    	List<Customer> customers =customerService.getAllCustomers();
		return  customers;
    }

    @GetMapping("/{id}")
	 public ResponseEntity<Customer> getCustomerById(@PathVariable("id")Long customerId){
	  Customer customer = customerService.getCustomerById(customerId);
	  
	  if(customer == null) {
	   return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<>(customer,HttpStatus.OK);
	 }
    @PostMapping("/save")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    	customerService.saveCustomer(customer);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(customer, HttpStatus.CREATED);
		return responseEntity;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
    	customerService.updateCustomer(customer);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) {
    	customerService.deleteById	(customerId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;

    }
}