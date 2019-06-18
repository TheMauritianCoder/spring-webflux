package com.themauritiancoder.spring.webflux.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.themauritiancoder.spring.webflux.domain.Category;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String>{

}
