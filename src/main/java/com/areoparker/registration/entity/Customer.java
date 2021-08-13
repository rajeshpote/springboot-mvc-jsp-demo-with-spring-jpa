package com.areoparker.registration.entity;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name="customer")
@Builder(toBuilder=true)
public class Customer {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Instant registered;
	
	@Column(length=255, unique=true)
	private String email;
	
	@Column(length=5)
	private String title;
	
	@Column(length=50)
	private String firstName;
	
	@Column(length=50)
	private String lastName;
	
	@Column(length=255)
	private String addressLine1;
	
	@Column(length=255)
	private String addressLine2;
	
	@Column(length=255)
	private String city;
	
	@Column(length=10)
	private String postcode;
	
	@Column(length=20)
	private String telephoneNumber;
	
	
	
	

}
