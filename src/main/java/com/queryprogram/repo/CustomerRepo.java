package com.queryprogram.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.queryprogram.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {

	@Query(value = "select c from Customer c")
	public List<Customer> fetchAllDatByQuery();
	
	@Query(value = "select c from Customer c where c.name =:name")
    List<Customer> fetchDataByGivenName(@Param("name") String name);
	
	@Query(value = "select c from Customer c where c.salary >:salary and c.department =:dep")
    List<Customer> fetchDataAboveGivenSalary(@Param("salary") int salary, @Param("dep") String department);
	
	
	/*
	 * @Query(value = "select c from Customer c where name = :val") public Customer
	 * fetchDataByUsingName(@Param("val") String name);
	 */

	
	 @Query(value = "select c from Customer c where name = :val and city =:city")
	 public Customer fetchDataByUsingName(@Param("val") String
	 name, @Param("city") String city);
	 
	// @Query(value = "select c from Customer c where e.city = :city like '%g'")
	// public Customer fetchLikeByCity(@Param("city") String city);
	 
	 @Query(value = "select c from Customer c where c.city like :city%")
	// @Query(value = "select c from Customer c where c.city like %:city%")
	 public List<Customer> fetchLikeByCity(@Param("city") String city);

}
