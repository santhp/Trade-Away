package com.tw.tradeaway.dao;

import com.tw.tradeaway.entities.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserDAOTest {

    @Autowired
    UserDAO cDao;
    User user1;

    @Before
    public void before(){
        // TODO Mock really!
        user1 = new User("pavan", "kumar","test@gmail.com", "9000384053","buyer", "501Hyd", "password");
        cDao.save(user1);
    }

    @Test
    public void getUserTest() {

        User user2 = cDao.getUser("test@gmail.com", "password");
        assertEquals(user1, user2);
    }
}
