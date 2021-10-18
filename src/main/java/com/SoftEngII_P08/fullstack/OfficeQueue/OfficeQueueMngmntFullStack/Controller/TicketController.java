package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Controller;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Ticket;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Service.TicketService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @PostMapping("/ticket")
    public Ticket GenerateTicket(@Validated @RequestBody Integer serviceCode) {
        return ticketService.createTicket(serviceCode.intValue());
    }


    @GetMapping("/get")
    public ResponseEntity<?> getTicket() {
        List<Ticket> resource = ticketService.getTicket();
        return ResponseEntity.ok(resource);
    }

    @GetMapping("/counter/{id}/nextticket") 
    public ResponseEntity<?> getNextTicket(@PathVariable int id) {
        Ticket nextTicket = ticketService.getNextTicket(id);
        if(nextTicket != null)
            return ResponseEntity.ok(nextTicket);
        return ResponseEntity.notFound().build(); //let's try
    }
    
    @GetMapping("/served/{serviceId}")
    public ResponseEntity <?> getServedClientsTOS(@PathVariable int serviceId){
    	int totalServed = ticketService.getClientsTOS(serviceId);
    	return ResponseEntity.ok(totalServed);
    }

   

}
