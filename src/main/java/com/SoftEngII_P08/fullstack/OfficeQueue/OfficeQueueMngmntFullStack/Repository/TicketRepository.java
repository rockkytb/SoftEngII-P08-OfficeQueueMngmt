package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
/*	  SELECT C.SERVICE_ID
     FROM COUNTER_SERVICE C , TICKET T
     WHERE T.SERVICE_ID=C.SERVICE_ID AND COUNTER_ID=1 AND SERVED=0
     GROUP BY C.SERVICE_ID
     HAVING COUNT(*)=SELECT MAX(CONT)
     FROM (SELECT COUNT(*) AS CONT ,C.SERVICE_ID
     FROM COUNTER_SERVICE C , TICKET T
     WHERE T.SERVICE_ID=C.SERVICE_ID AND COUNTER_ID=1 AND SERVED=0
     GROUP BY C.SERVICE_ID);*/
	/*
    @Query(value="SELECT COUNT(*) FROM Ticket WHERE service_id = :id")
    public int countTicketsInServiceQueue(
        @Param("id") int serviceId
    );*/
	
	@Query(value=" SELECT C.SERVICE_ID  FROM Counter_service C , Ticket T  WHERE T.service_id=C.service_id AND Counter_id=:id AND Served=0   GROUP BY C.service_id")   //  HAVING COUNT(*)= SELECT MAX(CONT)     FROM (SELECT COUNT(*) AS CONT ,C.SERVICE_ID     FROM COUNTER_SERVICE C , TICKET T     WHERE T.SERVICE_ID=C.SERVICE_ID AND COUNTER_ID=:id AND SERVED=0 GROUP BY C.SERVICE_ID)")
	    public int countTicketsInServiceQueue(
	        @Param("id") int counterId
	    );
	
	
	
	
	
	
}