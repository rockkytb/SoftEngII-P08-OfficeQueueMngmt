package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
/*	  SELECT *
FROM TICKET 
WHERE TICKET_ID =
(SELECT MIN(T1.TICKET_ID)
FROM TICKET T1
WHERE SERVED = 0
AND SERVICE_ID = 
(SELECT C.SERVICE_ID
     FROM COUNTER_SERVICE C , TICKET T
     WHERE T.SERVICE_ID=C.SERVICE_ID AND COUNTER_ID=1 AND SERVED=0
     GROUP BY C.SERVICE_ID
     HAVING COUNT(*)=SELECT MAX(CONT)
     FROM (SELECT COUNT(*) AS CONT ,C.SERVICE_ID
     FROM COUNTER_SERVICE C , TICKET T
     WHERE T.SERVICE_ID=C.SERVICE_ID AND COUNTER_ID=1 AND SERVED=0
     GROUP BY C.SERVICE_ID)));*/
	
    /*@Query(value="SELECT COUNT(*) FROM Ticket WHERE service_id = :id")
    public int countTicketsInServiceQueue(
        @Param("id") int serviceId
    );*/

    @Query(value = " SELECT C.SERVICE_ID FROM COUNTER_SERVICE C , TICKET T WHERE T.SERVICE_ID=C.SERVICE_ID AND COUNTER_ID=1 AND SERVED=0 GROUP BY C.SERVICE_ID HAVING COUNT(*)=(SELECT MAX(CONT) FROM (SELECT COUNT(*) AS CONT ,C.SERVICE_ID FROM COUNTER_SERVICE C , TICKET T WHERE T.SERVICE_ID=C.SERVICE_ID AND COUNTER_ID=:id AND SERVED=0 GROUP BY C.SERVICE_ID)) ORDER BY MIN(TICKET_ID) LIMIT 1", nativeQuery = true)
    //  HAVING COUNT(*)= SELECT MAX(CONT)     FROM (SELECT COUNT(*) AS CONT ,C.SERVICE_ID     FROM COUNTER_SERVICE C , TICKET T     WHERE T.SERVICE_ID=C.SERVICE_ID AND COUNTER_ID=:id AND SERVED=0 GROUP BY C.SERVICE_ID)")
    public int getLongestServiceId(
            @Param("id") int counterId
    );

    @Query(value = " SELECT * FROM TICKET WHERE SERVED = 0 AND NUMBER = (SELECT MIN(T1.NUMBER) FROM TICKET T1 WHERE SERVED = 0 AND SERVICE_ID = (SELECT C.SERVICE_ID FROM COUNTER_SERVICE C , TICKET T WHERE T.SERVICE_ID=C.SERVICE_ID AND COUNTER_ID=:id AND SERVED=0 GROUP BY C.SERVICE_ID HAVING COUNT(*)=(SELECT MAX(CONT) FROM (SELECT COUNT(*) AS CONT ,C.SERVICE_ID FROM COUNTER_SERVICE C , TICKET T WHERE T.SERVICE_ID=C.SERVICE_ID AND COUNTER_ID=:id AND SERVED=0 GROUP BY C.SERVICE_ID)) ORDER BY MIN(TICKET_ID) LIMIT 1))", nativeQuery = true)
    //  HAVING COUNT(*)= SELECT MAX(CONT)     FROM (SELECT COUNT(*) AS CONT ,C.SERVICE_ID     FROM COUNTER_SERVICE C , TICKET T     WHERE T.SERVICE_ID=C.SERVICE_ID AND COUNTER_ID=:id AND SERVED=0 GROUP BY C.SERVICE_ID)")
    public Ticket getNextTicketByCounter(
            @Param("id") int counterId
    );

    @Query(value = "SELECT max(number) FROM Ticket")
    Integer lastTicketNumber();

    //Count client served per type of service
    @Query (value = "SELECT COALESCE(COUNT (*), 0) FROM TICKET WHERE SERVED = 1 AND SERVICE_ID =:id", nativeQuery = true)
    public int countClients(
            @Param("id") int serviceId
    );
    
//    @Modifying
//    @Query (value = "UPDATE TICKET SET SERVED=1 WHERE TICKET_ID=:id", nativeQuery = true)
//    public int serveTicket(
//            @Param("id") int ticketId
//    );
   
    
}