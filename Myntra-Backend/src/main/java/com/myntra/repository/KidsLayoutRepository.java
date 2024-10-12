package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myntra.model.KidsLayout;

@Repository
public interface KidsLayoutRepository extends MongoRepository<KidsLayout, String> {

}
