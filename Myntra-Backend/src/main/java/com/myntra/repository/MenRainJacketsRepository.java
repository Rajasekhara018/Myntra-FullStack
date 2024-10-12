package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myntra.model.MenRainJackets;

@Repository
public interface MenRainJacketsRepository extends MongoRepository<MenRainJackets, String> {

}
