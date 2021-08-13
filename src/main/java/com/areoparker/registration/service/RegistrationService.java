package com.areoparker.registration.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.areoparker.registration.entity.CustomerSite;
import com.areoparker.registration.entity.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.areoparker.registration.dto.CustomerRegistration;
import com.areoparker.registration.entity.Customer;
import com.areoparker.registration.repository.CustomerRepository;
import com.areoparker.registration.repository.CustomerSiteRepository;
import com.areoparker.registration.repository.SiteRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private SiteRepository siteRepository;

	@Autowired
	private CustomerSiteRepository customerSiteRepository;

	@Transactional
	public void processRegiration(CustomerRegistration form){
		Customer customer = Customer.builder().email(form.getEmail()).title(form.getTitle())
				.firstName(form.getFirstName()).lastName(form.getLastName())
				.addressLine1(form.getAddressLine1()).addressLine2(form.getAddressLine2())
				.city(form.getCity()).postcode(form.getPostcode()).telephoneNumber(form.getTelephoneNumber())
				.registered(Instant.now()).build();
		customerRepository.save(customer);
		Site site = siteRepository.findByName(form.getSite());
		CustomerSite customerSite = CustomerSite.builder().customerId(customer.getId())
				.siteId(site.getId()).build();
		customerSiteRepository.save(customerSite);
		form.setId(customer.getId());
	}

	@PostConstruct
	private void init(){
		siteRepository.save(Site.builder().name("Avalon City").build());
		siteRepository.save(Site.builder().name("AceParks").build());
	}

	public List<Customer> findAllCustomer() {
		return (List<Customer>) customerRepository.findAll();
	}

	public String getCustomerSite(Integer id) {
		Integer siteId = customerSiteRepository.findById(id).get().getSiteId();
		return siteRepository.findById(siteId).get().getName();
	}

	public Optional<Customer> findCustomer(Integer id) {
		return customerRepository.findById(id);
	}
}
