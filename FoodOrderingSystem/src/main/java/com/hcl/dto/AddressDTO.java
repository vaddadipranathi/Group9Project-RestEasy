package com.hcl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

	private int totalquantity;
	private int totalprice;
	private String city;
	private String country;
	private String state;
	private String street;
	private String zipcode;
}
