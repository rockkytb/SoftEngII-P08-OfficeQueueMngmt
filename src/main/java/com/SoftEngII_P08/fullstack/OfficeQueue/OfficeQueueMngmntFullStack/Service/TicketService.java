package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Service;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Service;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Ticket;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository.ServiceRepository;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ServiceRepository serviceRepository;

    public Ticket createTicket(int serviceId) {
        Ticket newTicket = new Ticket();
        Optional<Service> service = serviceRepository.findById(serviceId);
        newTicket.setService(service.get());
        newTicket.setServed(0);
        return ticketRepository.save(newTicket);
    }
    
    public List<Ticket> getTicket() {
    	List<Ticket> lista = ticketRepository.findAll();
    	System.out.println(lista);
    	return lista;
    }

    public int getCountQueue(int counterId){
        int countqueue = ticketRepository.countTicketsInServiceQueue(counterId);
        return countqueue;
    }

}
