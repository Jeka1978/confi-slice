package com.slice.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JavaSchoolStudent on 31.08.2016.
 */
@lombok.Getter
@Data
@NoArgsConstructor
public class Configuration {

    private int configurationId;

    private String title;

    private List<Email> emails;

    @Getter
    @JsonUnwrapped
    private List<OperationConstraint> operationConstraints;

    @Getter
    private int frameCols;
    @Getter
    private int frameRows;

    public Configuration(String title, List<Email> emails, List<OperationConstraint> operationConstraints, int frameCols, int frameRows) {
        this.title = title;
        this.emails = emails;
        this.operationConstraints = operationConstraints;
        this.frameCols = frameCols;
        this.frameRows = frameRows;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "configurationId=" + configurationId +
                ", title='" + title + '\'' +
                ", emails=" + emails +
                ", operationConstraints=" + operationConstraints +
                ", frameCols=" + frameCols +
                ", frameRows=" + frameRows +
                '}';
    }


    public List<String> getListEmailsString() {
        List<String> stringEmails = new ArrayList<String>();
        for (Email email : emails) {
            stringEmails.add(email.getAddress());
        }
        return stringEmails;
    }
}
