package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myntra.model.MenFormalShirts;

@Repository
public interface MenFormalShirstRepository extends MongoRepository<MenFormalShirts, String> {

}
