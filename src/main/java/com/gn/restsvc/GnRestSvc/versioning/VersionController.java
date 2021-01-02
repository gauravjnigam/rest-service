package com.gn.restsvc.GnRestSvc.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

	// uri verson
	@GetMapping("v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Gaurav Nigam");
	}
	
	@GetMapping("v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Gaurav","Nigam"));
	}
	
	// request param versioning
	@GetMapping(value = "person/param", params = "version=1")
	public PersonV1 getParamV1() {
		return new PersonV1("Gaurav Nigam");
	}
	
	@GetMapping(value = "person/param", params = "version=2")
	public PersonV2 getParamV2() {
		return new PersonV2(new Name("Gaurav","Nigam"));
	}
	
	// accept header versioning
	@GetMapping(value = "person/header", headers = "X-API-VERSION=1")
	public PersonV1 getHeaderV1() {
		return new PersonV1("Gaurav Nigam");
	}
	
	@GetMapping(value = "person/header", headers = "X-API-VERSION=2")
	public PersonV2 getHeaderV2() {
		return new PersonV2(new Name("Gaurav","Nigam"));
	}
	
	// 
	@GetMapping(value = "person/produces", produces = "application/v1+json")
	public PersonV1 getProducesV1() {
		return new PersonV1("Gaurav Nigam");
	}
	
	@GetMapping(value = "person/produces", produces = "application/v2+json")
	public PersonV2 getProducesV2() {
		return new PersonV2(new Name("Gaurav","Nigam"));
	}
}
