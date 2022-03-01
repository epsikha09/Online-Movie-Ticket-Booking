package com.mts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mts.exception.AccessForbiddenException;
import com.mts.exception.CustomerNotFoundException;
import com.mts.exception.MovieNotFoundException;
import com.mts.model.Customer;
import com.mts.model.Movie;
import com.mts.service.CustomerService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	@Autowired
	LoginController loginController;

	
	@PostMapping("/customer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer)
			throws CustomerNotFoundException, AccessForbiddenException {
		
		ResponseEntity<String> response = null;
		if (customer == null) {
			logger.error("-------------Please Enter Customer Values--------");
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			customer = customerService.addCustomer(customer);
			response = new ResponseEntity<>("Customer is Added", HttpStatus.CREATED);
			logger.info("----------------Customer Created------------------");
		}
		return response;
	}

	
	@DeleteMapping("/delete/{customerId}")
	public Customer removeCustomer(@PathVariable int customerId)
			throws CustomerNotFoundException, AccessForbiddenException {
		
		logger.info("----------------Customer Deleted Successfully--------------");
		return customerService.removeCustomer(customerId);
	}

	
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)
			throws CustomerNotFoundException, AccessForbiddenException {
		
		ResponseEntity<Customer> response = null;
		if (customer == null) {
			logger.error("Enter Customer Details");
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			customer = customerService.updateCustomer(customer);
			response = new ResponseEntity<>(customer, HttpStatus.OK);
			logger.info("--------------Customer Updated Successfully-----------------");
		}
		return response;
	}

	

	@GetMapping("/findall")
	public List<Customer> viewCustomerList() throws AccessForbiddenException {
		
		logger.info("---------------Customer List-----------------");
		return customerService.viewCustomerList();
	}
	
	
	@GetMapping("/view/{customerId}")
	public ResponseEntity<Customer> viewACustomer(@PathVariable int customerId) throws CustomerNotFoundException {

		ResponseEntity<Customer> response = null;
		try {
			Customer movie = customerService.viewCustomer(customerId);
			response = new ResponseEntity<>(movie, HttpStatus.OK);
			logger.info("-------Movie With Movie id " + customerId + " Found---------");
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new CustomerNotFoundException("Customer with " + customerId + " id dosen't exist");
		}
		return response;
		// return ResponseEntity.ok(moviesService.viewMovie(movieId));
	}
}
