package com.themauritiancoder.spring.webflux.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.themauritiancoder.spring.webflux.domain.Vendor;
import com.themauritiancoder.spring.webflux.repositories.VendorRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class VendorControllerTest {
    
	WebTestClient webTestClient;
    VendorRepository vendorRepository;
    VendorController vendorController;
    
    @BeforeAll
    public void setUp() throws Exception {
    	vendorRepository = Mockito.mock(VendorRepository.class);
    	vendorController = new VendorController(vendorRepository);
        webTestClient = WebTestClient.bindToController(vendorController).build();
    }

    @Test
    public void findAll() {
        BDDMockito.given(vendorRepository.findAll())
        .willReturn(
        		Flux.just(
        				Vendor.builder().firstname("ravi").lastname("kowlessur").build(),
        				Vendor.builder().firstname("roubina").lastname("pyanee").build()));
        
        webTestClient.get()
        .uri("/api/v1/vendors/")
        .exchange()
        .expectBodyList(Vendor.class)
        .hasSize(2);
    }
    
    @Test
    public void getById() {
        BDDMockito.given(vendorRepository.findById("someid"))
                .willReturn(Mono.just(Vendor.builder().firstname("ravi").lastname("kowlessur").build()));

        webTestClient.get()
                .uri("/api/v1/vendors/someid")
                .exchange()
                .expectBody(Vendor.class);

    }
}
