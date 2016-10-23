package com.slice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by JavaSchoolStudent on 01.09.2016.
 */
@Data
@NoArgsConstructor
public class SpecificNumber {
    private int id;
    private int value;

    public SpecificNumber(int value) {
        this.value = value;
    }
    public SpecificNumber(String value) {
        this.value =  Integer.valueOf(value);
    }
}
