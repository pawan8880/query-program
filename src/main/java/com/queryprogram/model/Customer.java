package com.queryprogram.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "CUSTOMER_NAME")
	private String name;
	@Column(name = "CUSTOMER_AGE")
	private int age;
	@Column(name = "SALARY")
	private int salary;
	@Column(name = "EMAIL")
	private String email;
	private String department;
	@Column(name = "CITY")
	private String city;

}
