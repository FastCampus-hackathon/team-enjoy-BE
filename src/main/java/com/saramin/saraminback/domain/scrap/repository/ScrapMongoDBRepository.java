package com.saramin.saraminback.domain.scrap.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.saramin.saraminback.domain.scrap.model.Scrap;

public interface ScrapMongoDBRepository extends MongoRepository<Scrap, String> {

}
