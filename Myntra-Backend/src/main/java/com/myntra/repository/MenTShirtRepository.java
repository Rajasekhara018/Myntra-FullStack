package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myntra.model.MenTShirt;

@Repository
public interface MenTShirtRepository extends MongoRepository<MenTShirt,String> {

}
