package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
	
	//To be used if needed to retrieve service ID from service name
	@Query(value="SELECT SERVICE_ID FROM SERVICE WHERE NAME = :name", nativeQuery = true)
    public int getServiceId(
        @Param("name") String serviceName
    );
	
	//Count total number of served client for a given service ID
	@Query(value="SELECT COUNT(*) FROM TICKET WHERE SERVED = 1 AND SERVICE_ID = :id", nativeQuery = true)
    public int CountClientServed(
        @Param("id") int serviceId
    );
	
	//Get services available
	@Query(value="	SELECT DISTINCT S.SERVICE_ID, NAME FROM SERVICE S, COUNTER_SERVICE C WHERE S.SERVICE_ID = C.SERVICE_ID",nativeQuery = true)
	public List<Service> getServicesAvailable ();
	
	
	
	
    
}
