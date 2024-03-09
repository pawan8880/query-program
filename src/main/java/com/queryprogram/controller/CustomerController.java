package com.queryprogram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.queryprogram.model.Customer;
import com.queryprogram.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	
	@PostMapping("/save")
	public ResponseEntity<Customer> createRecord(@RequestBody Customer cus){
		Customer costomerRecord = service.saveReord(cus);
		return ResponseEntity.ok(costomerRecord);
		
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Customer>> fetchByController(){
		List<Customer> fetchRecord = service.fetchAllData();
		return ResponseEntity.ok(fetchRecord);
	}
	
	
	@GetMapping("/fetchOne")
	public ResponseEntity<Customer> fetchByControllerOne(){
		Customer fetchRecord = service.fetchDataOnlyOneByName();
		return ResponseEntity.ok(fetchRecord);
	}
	
	@GetMapping("/fetchByName/{name}")
    public List<Customer> getDetailsByName(@PathVariable String name) {
        return service.getDetailsByName(name);
    }
	
	@GetMapping("/fetchBySalary/{salary}/{depatment}")
    public List<Customer> getDetailsBySalary(@PathVariable int salary, @PathVariable String depatment) {
        return service.getDetailsBySalary(salary,depatment);
    }
	
	
	@GetMapping("/fetchByLikeCity/{city}")
    public List<Customer> getDetailsBySalary(@PathVariable String city) {
        return service.getLikeByCity(city);
    }
}
