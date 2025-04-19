package com.cloudbee.purchase_assessment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.cloudbee.purchase_assessment.model.ReceiptDetails;
import com.cloudbee.purchase_assessment.model.User;
import com.cloudbee.purchase_assessment.model.UserDetailsWithSeat;

@Service
public class TicketPurchaseServiceImpl implements TicketPurchaseService {

    Map<String, ReceiptDetails> allDetails = new HashMap<>();


    @Override
    public void purchaseTicket(User user) {
        User newUser = new User(user.getUserFirstName(), user.getUserLastName(), user.getUserEmailAddress());
        String seatSection = generateSeatSection();
        ReceiptDetails receiptDetails = new ReceiptDetails("London","France", newUser, 20.0, seatSection);
        allDetails.put(user.getUserEmailAddress(), receiptDetails);        
    }

    @Override
    public Object getReceiptDetails(String emailAddress) {
        if(allDetails.containsKey(emailAddress))
            return allDetails.get(emailAddress);
        else
            return "User detail is not found";
    }

    @Override
    public List<UserDetailsWithSeat> getDetailsBySection(String seatSection) {
        List<UserDetailsWithSeat> userDetailsbySection = allDetails.values()
        .stream()
        .filter(detail -> detail.getSeatSection().equals(seatSection))
        .map(detail -> new UserDetailsWithSeat(detail.getUser().getUserFirstName(),detail.getUser().getUserLastName(),
                            detail.getUser().getUserEmailAddress(), detail.getSeatSection()))
        .toList();
        return userDetailsbySection;
    }

    @Override
    public String removeUser(String emailAddress) {
        if(allDetails.containsKey(emailAddress)){
            allDetails.remove(emailAddress);
            return "User detail removed from the train";
        }else{
            return "User detail is not present to remove";
        }
    }


    @Override
    public String modifyUserSeat(String emailAddress, String newSeatSection) {

        if(!newSeatSection.equals("A") && !newSeatSection.equals("B")){
            return "Given seat section is incorrect, please choose A or B";
        }
        
        if(allDetails.containsKey(emailAddress)){
            ReceiptDetails receiptDetails = allDetails.get(emailAddress);
            receiptDetails.setSeatSection(newSeatSection);
            return "User's seat modified successfully";
        }else{
            return "User detail not available to modify";
        }
    }

    private String generateSeatSection(){
        Random random = new Random();
        return random.nextBoolean() ? "A" : "B";
    }

    

    
    
}
