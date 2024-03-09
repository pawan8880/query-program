package com.queryprogram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.queryprogram.model.Customer;
import com.queryprogram.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo repo;

	public Customer saveReord(Customer cus) {
		return repo.save(cus);
	}

	public List<Customer> fetchAllData() {
		return repo.fetchAllDatByQuery();
	}

	public Customer fetchDataOnlyOneByName() {
		return repo.fetchDataByUsingName("amit","goa");
	}

	public List<Customer> getDetailsByName(String name) {
		return repo.fetchDataByGivenName(name);
	}
	
	public List<Customer> getDetailsBySalary(int s, String dep) {
		return repo.fetchDataAboveGivenSalary(s,dep);
	}
	
	public List<Customer> getLikeByCity(String city) {
		return repo.fetchLikeByCity(city);
	}
	
}
