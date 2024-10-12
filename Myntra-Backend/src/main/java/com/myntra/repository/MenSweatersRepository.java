package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myntra.model.MenSweaters;

@Repository
public interface MenSweatersRepository extends MongoRepository<MenSweaters, String> {

}
