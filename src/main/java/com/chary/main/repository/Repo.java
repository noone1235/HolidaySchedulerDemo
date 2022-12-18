package com.chary.main.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chary.main.model.DateStr;

//import com.chary.main.model.Dates;

@Repository
public interface Repo extends MongoRepository<DateStr,String>{
	
}
