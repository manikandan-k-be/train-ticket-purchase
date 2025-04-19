package com.cloudbee.purchase_assessment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private String userFirstName;
    private String userLastName;
    private String userEmailAddress;
}
