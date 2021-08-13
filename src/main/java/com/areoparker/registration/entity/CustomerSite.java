package com.areoparker.registration.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_site")
@Builder(toBuilder=true)
public class CustomerSite {
	@Id
	private Integer customerId;

	private Integer siteId;



}
