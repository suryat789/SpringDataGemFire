package com.dev.surya.springdata.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.surya.springdata.data.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message,Integer>{

}
