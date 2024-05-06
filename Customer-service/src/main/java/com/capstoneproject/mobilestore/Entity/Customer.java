package com.capstoneproject.mobilestore.Entity;

import java.util.List;
import java.util.Objects;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Customer")
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_seq")
    private long customerId;
	
	@Column
	private String customerPassword;
	
	@Column
	private String customerName;
	
	@Column
	private long mobileNumber;
	
	@Column
	private String email;

	
	
}
	
	
	