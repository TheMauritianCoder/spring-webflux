package com.themauritiancoder.spring.webflux.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.themauritiancoder.spring.webflux.domain.Category;
import com.themauritiancoder.spring.webflux.domain.Vendor;
import com.themauritiancoder.spring.webflux.repositories.CategoryRepository;
import com.themauritiancoder.spring.webflux.repositories.VendorRepository;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final CategoryRepository categoryRepository;
	private final VendorRepository vendorRepository;

	public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
		this.categoryRepository = categoryRepository;
		this.vendorRepository = vendorRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(categoryRepository.count().block() == 0) {
			System.out.println("Loading Category Data...");
			categoryRepository.save(Category.builder().description("Fruits").build()).block();
			categoryRepository.save(Category.builder().description("Nuts").build()).block();
			categoryRepository.save(Category.builder().description("Breads").build()).block();
			categoryRepository.save(Category.builder().description("Meat").build()).block();
			categoryRepository.save(Category.builder().description("Eggs").build()).block();
		}

		if(vendorRepository.count().block() == 0) {			
			System.out.println("Loading Vendor Data...");
			vendorRepository.save(Vendor.builder().firstname("Ravi").lastname("Kowlessur").build()).block();
			vendorRepository.save(Vendor.builder().firstname("Roubina").lastname("Pyanee").build()).block();
		}
		
		System.out.println("Category Count ---> "+categoryRepository.count().block());
		System.out.println("Vendors  Count ---> "+vendorRepository.count().block());
		
	}

}
