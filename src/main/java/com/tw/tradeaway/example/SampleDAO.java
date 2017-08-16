package com.tw.tradeaway.example;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface SampleDAO extends CrudRepository<Sample, Integer> {


    // public User findUSer(String name);
}