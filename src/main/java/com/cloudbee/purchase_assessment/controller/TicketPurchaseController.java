package com.cloudbee.purchase_assessment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudbee.purchase_assessment.model.User;
import com.cloudbee.purchase_assessment.model.UserDetailsWithSeat;
import com.cloudbee.purchase_assessment.service.TicketPurchaseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/ticket")
public class TicketPurchaseController {

    @Autowired
    TicketPurchaseService ticketPurchaseService;

    @PostMapping("/purchase")
    public String purchaseTicket(@RequestBody User user) {
        ticketPurchaseService.purchaseTicket(user);
        return "Train ticket purchased successfully";
    }

    @GetMapping("/getUserDetailsByEmail/{email}")
    public Object getUserDetail(@PathVariable String email) {
        return ticketPurchaseService.getReceiptDetails(email);
    }

    @GetMapping("/getUserDetailsBySeatSection/{seatSection}")
    public List<UserDetailsWithSeat> getUserDetailsBySeats(@PathVariable String seatSection) {
        return ticketPurchaseService.getDetailsBySection(seatSection);
    }

    @DeleteMapping("/deleteUserDetail/{email}")
    public String getMethodName(@PathVariable String email) {
        return ticketPurchaseService.removeUser(email);
    }

    @PatchMapping("/modifySeat/{email}/{newSeat}")
    public String putMethodName(@PathVariable String email, @PathVariable String newSeat) {
        return ticketPurchaseService.modifyUserSeat(email, newSeat);
    }
    
}
