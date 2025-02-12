package com.example.mongodb.repositories;

import com.example.mongodb.model.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends MongoRepository<Journal, String> {
}
