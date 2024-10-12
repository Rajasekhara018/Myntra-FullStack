package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myntra.model.MenSweatShirts;

@Repository
public interface MenSweatShirtsRepository extends MongoRepository<MenSweatShirts, String> {

}
