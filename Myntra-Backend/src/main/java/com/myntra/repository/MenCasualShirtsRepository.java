package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myntra.model.MenCasualShirts;

@Repository
public interface MenCasualShirtsRepository extends MongoRepository<MenCasualShirts,String> {

}
