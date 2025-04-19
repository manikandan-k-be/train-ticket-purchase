package com.cloudbee.purchase_assessment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ReceiptDetails {
    private String from;
    private String to;
    private User user;
    private double pricePaid;
    private String seatSection;
}
