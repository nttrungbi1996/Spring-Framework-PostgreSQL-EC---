package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	//	List<Customer> findByEmail(String email);
	//
	//	List<Customer> findByEmailAndByPassword(String email, String password);

}
