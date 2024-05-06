package com.capstoneproject.mobilestore.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capstoneproject.mobilestore.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}