package com.areoparker.registration;

import com.areoparker.registration.dto.CustomerRegistration;
import com.areoparker.registration.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RegistrationApplicationTests {

	@Autowired
	private RegistrationService registrationService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void registerCustomerTest(){
		CustomerRegistration registration = CustomerRegistration.builder().site("AceParks").firstName("john").lastName("Lee")
				.email("john.le@gamil.com").title("Mr").addressLine1("26, Sir Thomas House")
				.addressLine2("City Center").postcode("L1 3BA").city("Liverpool")
				.telephoneNumber("07923748494").build();
		registrationService.processRegiration(registration);
		log.info("Added customer as test:"+registration);
		Assert.assertTrue(registrationService.findCustomer(registration.getId()).isPresent());
	}
}
