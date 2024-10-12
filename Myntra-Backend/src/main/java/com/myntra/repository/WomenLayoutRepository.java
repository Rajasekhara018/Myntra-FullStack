package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myntra.model.WomenLayout;

@Repository
public interface WomenLayoutRepository extends MongoRepository<WomenLayout, String> {

}
