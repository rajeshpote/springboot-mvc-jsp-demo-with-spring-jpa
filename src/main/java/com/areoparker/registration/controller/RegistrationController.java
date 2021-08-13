package com.areoparker.registration.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.areoparker.registration.dto.CustomerRegistration;
import com.areoparker.registration.entity.Customer;
import com.areoparker.registration.service.RegistrationService;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("customer")
@RequestMapping("/customer")
public class RegistrationController {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RegistrationController.class);

	@Autowired
	private RegistrationService registrationService;

	@RequestMapping(method = RequestMethod.POST)
    public String submitForm(@Valid @ModelAttribute("customer") CustomerRegistration customerReg, BindingResult result, SessionStatus status) 
    {
    	try {
			if (result.hasErrors()) {
				Map<String, String> errorMap = new HashMap<String, String>();
				result.getFieldErrors().forEach(e -> errorMap.put(e.getField(), e.getDefaultMessage()));
				errorMap.entrySet().stream().forEach((e) -> {
					log.info(e.getKey() + " " + e.getValue());
					result.reject(e.getKey(), e.getValue());
				});
				return "registration";
			}
			registrationService.processRegiration(customerReg);
			status.setComplete();
			return "redirect:customer/success";
		}catch (Throwable t){
    		log.error("exception "+t);
			ObjectError error = new ObjectError("status","Registration Failed:"+t.getLocalizedMessage());
			result.addError(error);
			result.rejectValue("status", "customer.status", "Registration Failed:"+t.getLocalizedMessage());
    		return "registration";
		}

    }

	@RequestMapping(method=RequestMethod.GET)
	public String home(@RequestParam(name="site",defaultValue="Avalon City") String site, Model model) {
		model.addAttribute("customer", CustomerRegistration.builder().site(site).build());
		//model.addAttribute("exception",null);
		return "registration";
	}
	
	@RequestMapping(value="/success", method=RequestMethod.GET)
	public ModelAndView addSuccess(Model model) {
		ModelAndView map = new ModelAndView("addSuccess");
		List<CustomerRegistration> customerRegistrations = new ArrayList<>();
		List<Customer> customerList = registrationService.findAllCustomer();
		customerList.forEach(c->{
			log.info("customer:"+c);
			customerRegistrations.add(CustomerRegistration.builder().registered(c.getRegistered())
					.id(c.getId()).site(registrationService.getCustomerSite(c.getId()))
					.title(c.getTitle()).firstName(c.getFirstName()).lastName(c.getLastName())
					.email(c.getEmail()).telephoneNumber(c.getTelephoneNumber())
					.build());
		});
		map.addObject("lists", customerRegistrations);
		return map;
	}
	

}
