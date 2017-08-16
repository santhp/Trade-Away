package com.tw.tradeaway.dao;

import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.entities.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductDAOTest {

    @Autowired
    ProductDAO dao;
    @Autowired
    CategoryDAO cDao;

    @Before
    public void before(){
        cDao.save(new Category(1, "abc"));
        dao.save(new Product( "p1", "d1", 100, null, new Category(1, "abc")));
    }

    @Test
    public void DAOTest() {

        Iterator<Product> iterator = dao.findAll().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}
