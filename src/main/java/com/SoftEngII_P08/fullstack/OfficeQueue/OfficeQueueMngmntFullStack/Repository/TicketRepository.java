package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query(value="SELECT COUNT(*) FROM Ticket WHERE service_id = :id")
    public int countTicketsInServiceQueue(
        @Param("id") int serviceId
    );
}