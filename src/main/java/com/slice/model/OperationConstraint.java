package com.slice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JavaSchoolStudent on 31.08.2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationConstraint {
    private String sign;
    private int minA;
    private int maxA;
    private int minB;
    private int maxB;
    private int minAnswer;
    private int maxAnswer;
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Integer> exceptA;

//    @Transient
    private List<Integer> exceptB;
//    @Transient
    private List<Integer> specialA;

//    @Transient

    private List<Integer> specialB;
    private boolean allowedNegativeAnswer;
    private boolean divisionWithoutRemainder;

    private int constraintId;


    public List<Integer> getExceptAListInteger() {
        return getListInteger(exceptA);
    }

    public List<Integer> getSpecialAListInteger() {
        return getListInteger(specialA);
    }

    public List<Integer> getExceptBListInteger() {
        return getListInteger(exceptB);
    }

    public List<Integer> getSpecialBListInteger() {
        return getListInteger(specialB);
    }

    private static List<Integer> getListInteger(List<Integer> list) {
        if (list == null) {
            return null;
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (Integer specificNumber : list) {
            ans.add(specificNumber);
        }
        return ans;
    }
}
