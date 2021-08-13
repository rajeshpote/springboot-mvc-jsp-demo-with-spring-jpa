package com.areoparker.registration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.areoparker.registration.entity.Customer;
import com.areoparker.registration.entity.Site;

@Repository
public interface SiteRepository extends CrudRepository<Site, Integer> {

    public Site findByName(String name);
}
