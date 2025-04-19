package com.cloudbee.purchase_assessment.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class UserDetailsWithSeat {

    private String userFirstName;
    private String userLastName;
    private String userEmailAddress;
    private String seatSection;
    
}
