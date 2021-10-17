package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Counter;


public interface CounterRepository extends JpaRepository<Counter, Integer> {
	
	//INSERT INTO COUNTER_SERVICE (COUNTER_ID, SERVICE_ID) VALUES (6,1)
	@Query(value="INSERT INTO COUNTER_SERVICE (COUNTER_ID, SERVICE_ID) VALUES (:cid,:sid)",nativeQuery = true)
	public int link(
			@Param("sid") int serviceId,
			@Param("cid") int counterId
			);
}

