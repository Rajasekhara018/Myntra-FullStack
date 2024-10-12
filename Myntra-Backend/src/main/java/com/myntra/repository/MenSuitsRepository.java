package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myntra.model.MenSuits;

@Repository
public interface MenSuitsRepository extends MongoRepository<MenSuits, String> {

}
