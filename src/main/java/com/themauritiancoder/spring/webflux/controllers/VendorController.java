package com.themauritiancoder.spring.webflux.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.themauritiancoder.spring.webflux.domain.Vendor;
import com.themauritiancoder.spring.webflux.repositories.VendorRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/vendors")
public class VendorController {

	private final VendorRepository vendorRepository;
	
	public VendorController(VendorRepository vendorRepository) {
		this.vendorRepository = vendorRepository;
	}
	
	
	@GetMapping
	public Flux<Vendor> getVendors(){
		return vendorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Vendor> getVendorById(@PathVariable String id){
		return vendorRepository.findById(id);
	}
	
}
