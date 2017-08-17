package com.tw.tradeaway.dao;

import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.entities.Product;
import com.tw.tradeaway.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserDAO extends CrudRepository<User, Integer> {

    @Query("select u from User u where u.emailId=:emailId and u.password=:password")
    User getUser(@Param("emailId")String emailId, @Param("password")String password);

}
