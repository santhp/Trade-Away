package com.sample;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserDAO extends CrudRepository<User, Integer> {


    // public User findUSer(String name);
}