package com.slice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by JavaSchoolStudent on 01.09.2016.
 */
@NoArgsConstructor
@Getter
public class Teacher {
    private int userId;

    String userName;
    String password;

    List<Configuration> configurations;

    public Teacher(String username, String password, List<Configuration> configurations) {
        this.userName = username;
        this.password = password;
        this.configurations = configurations;
    }
}
