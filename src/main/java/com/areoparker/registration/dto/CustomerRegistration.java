package com.areoparker.registration.dto;

import java.time.Instant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;

@Setter
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegistration  {

	private Integer id;

	private Instant registered;

	@Pattern(regexp = "^(.+)@(.+)$")
	@NotBlank
	private String email;

	@NotBlank
	@Size(max=5)
	private String title;

	@NotBlank
	@Size(max=50)
	private String firstName;


	@NotBlank
	@Size(max=50)
	private String lastName;


	@NotBlank
	@Size(max=255)
	private String addressLine1;

	@Size(max=255)
	private String addressLine2;

	@Size(max=255)
	private String city;

	@NotBlank
	@Size(max=10)
	private String postcode;

	@Size(max=20)
	private String telephoneNumber;

	private String site;

	private String status;


	
}
