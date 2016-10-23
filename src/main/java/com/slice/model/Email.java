package com.slice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by JavaSchoolStudent on 01.09.2016.
 */
@Data
@NoArgsConstructor
public class Email {
    private int id;
    private String address;

    public Email(String address) {
        this.address = address;
    }
}
