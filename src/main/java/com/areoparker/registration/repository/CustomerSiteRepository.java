package com.areoparker.registration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.areoparker.registration.entity.Customer;
import com.areoparker.registration.entity.CustomerSite;

@Repository
public interface CustomerSiteRepository extends CrudRepository<CustomerSite, Integer> {

}
