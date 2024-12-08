package com.myntra.repository;

import com.myntra.model.EmailResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailResponseReposirory extends MongoRepository<EmailResponse, Long> {
}
