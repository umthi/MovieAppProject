package com.stackroute.ng2boot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.ng2boot.domain.Movie;


public interface CrudsRepository extends CrudRepository<Movie,String> {

}
