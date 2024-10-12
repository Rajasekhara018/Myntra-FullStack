package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myntra.model.MenJackets;

@Repository
public interface MenJacketsRepository extends MongoRepository<MenJackets, String> {

}
