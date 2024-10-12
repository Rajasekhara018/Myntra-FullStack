package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myntra.model.AuthLogin;
import com.myntra.model.AuthRegister;

@Repository
public interface AuthRegistrationRepository extends MongoRepository<AuthRegister, String> {

	AuthLogin findByEmailAndPassword(String email, String password);

}
