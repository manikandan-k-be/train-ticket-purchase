package com.cloudbee.purchase_assessment.service;

import java.util.List;

import com.cloudbee.purchase_assessment.model.User;
import com.cloudbee.purchase_assessment.model.UserDetailsWithSeat;

public interface TicketPurchaseService {
    void purchaseTicket(User user);
    Object getReceiptDetails(String emailAddress);
    List<UserDetailsWithSeat> getDetailsBySection(String seatSection);
    String removeUser(String emailAddress);
    String modifyUserSeat(String emailAddress, String newSeatSection);
    
}
