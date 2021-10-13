package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}