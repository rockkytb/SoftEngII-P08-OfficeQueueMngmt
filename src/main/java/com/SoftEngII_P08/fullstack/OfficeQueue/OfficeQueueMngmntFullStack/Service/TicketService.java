package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Service;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.ResponseModel.ClientsTOS;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.ResponseModel.ServiceResponse;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Service;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Ticket;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository.ServiceRepository;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ServiceRepository serviceRepository;

    public Ticket createTicket(int serviceId) {
        Ticket newTicket = new Ticket();
        Integer ticketNumber = getLastTicketNumber();
        if (ticketNumber == null)
            ticketNumber = 1;
        else
            ticketNumber = getLastTicketNumber() + 1;
        Optional<Service> service = serviceRepository.findById(serviceId);
        newTicket.setService(service.get());
        newTicket.setServed(0);
        newTicket.setNumber(ticketNumber);
        return ticketRepository.save(newTicket);
    }

    public List<Ticket> getTicket() {
        List<Ticket> lista = ticketRepository.findAll();
        System.out.println(lista);
        return lista;
    }

    public int getLongestQueueByCounter(int counterId) { 
        int service_id = ticketRepository.getLongestServiceId(counterId);
        return service_id;
    }

    public Ticket getNextTicket(int counterId) {
        Ticket nextTicket = new Ticket();
        nextTicket = ticketRepository.getNextTicketByCounter(counterId);
        if(nextTicket != null){
            nextTicket.setServed(1);
            ticketRepository.save(nextTicket); 
            return nextTicket; 
        }
        return null;
    }

    public Integer getLastTicketNumber() {
        return ticketRepository.lastTicketNumber();
    }
    
    public ClientsTOS getClientsTOS(int serviceId) {
        int tot = ticketRepository.countClients(serviceId);
        ClientsTOS clientsTOS = new ClientsTOS();
        clientsTOS.setServiceId(serviceId);
        clientsTOS.setTotServed(tot);
    	return clientsTOS;
    }
    
 
    

}
