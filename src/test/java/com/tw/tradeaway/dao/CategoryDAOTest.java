package com.tw.tradeaway.dao;

import com.tw.tradeaway.entities.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CategoryDAOTest {

    @Autowired
    CategoryDAO dao;

    @Before
    public void before(){

        // TODO Mock really!
        dao.save(new Category(1002, "cat1"));
    }

    @Test
    public void DAOTest() {

        Iterator<Category> iterator = dao.findAll().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}
