package com.themauritiancoder.spring.webflux.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.themauritiancoder.spring.webflux.domain.Vendor;

public interface VendorRepository extends ReactiveMongoRepository<Vendor, String>{

}
