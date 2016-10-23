package com.slice.dao;

import com.slice.configs.AWSConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 23/10/2016.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AWSConfig.class)
public class TestDaoImplTest {
    @Autowired
    private TestDao testDao;

    @Before
    public void createTable() {
        testDao.deleteTable();
        testDao.createTable();
    }

    @Test
    public void savePerson() throws Exception {
        Person vasya = new Person("Vasya");
        vasya.setCities(Arrays.asList("Ashdod","Rishon"));
        testDao.savePerson(vasya);

    }



}