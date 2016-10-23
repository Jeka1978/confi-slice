package com.slice.dao;

/**
 * Created by Evegeny on 23/10/2016.
 */
public interface TestDao {
    void createTable();

    void savePerson(Person person);

    void deleteTable();
}
