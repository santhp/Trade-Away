package com.tw.tradeaway.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DAOTest {

    @Autowired
    UserDAO dao;

    @Test
    public void DAOTest() {

        Iterator<User> userIterator = dao.findAll().iterator();
        while (userIterator.hasNext()) {
            System.out.println(userIterator.next().toString());
        }
        ;
    }
}
