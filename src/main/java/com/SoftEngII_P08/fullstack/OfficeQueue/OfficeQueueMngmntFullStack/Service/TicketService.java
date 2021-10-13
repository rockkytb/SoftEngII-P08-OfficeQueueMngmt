package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Service;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Ticket;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket createTicket(int serviceCode) {
        Ticket newTicket = new Ticket();
        newTicket.setCodService(serviceCode);
        newTicket.setServed(0);
        return ticketRepository.save(newTicket);
    }
}
