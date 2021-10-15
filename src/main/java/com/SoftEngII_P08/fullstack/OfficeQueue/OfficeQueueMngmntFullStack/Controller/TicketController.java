package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Controller;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Counter;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Service;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Ticket;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Service.CounterService;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Service.ServiceService;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Service.TicketService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private CounterService counterService;
    @Autowired
    private ServiceService serviceService;
    
    @PostMapping("/ticket")
    public Ticket GenerateTicket(@Validated @RequestBody int serviceCode) {
        return ticketService.createTicket(serviceCode);
    }

    @PostMapping("/counter")
    public Counter GenerateCounter(@Validated @RequestBody  String name) {
        return counterService.createCounter(name);
    }
    
    @PostMapping("/service")
    public Service GenerationService(@Validated @RequestBody String name) {
    	return serviceService.createService(name);
    }
    
    
    @GetMapping("/get")
    public ResponseEntity<?> getTicket () {
    	List<Ticket> resource= ticketService.getTicket();
    	return ResponseEntity.ok(resource);
    }

}
