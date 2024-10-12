package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myntra.model.MenBlazer;

@Repository
public interface MenBlazerRepository extends MongoRepository<MenBlazer,String> {

}
