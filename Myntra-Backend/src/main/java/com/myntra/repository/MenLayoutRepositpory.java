package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myntra.model.MenLayout;



@Repository
public interface MenLayoutRepositpory extends MongoRepository<MenLayout, String> {

}
