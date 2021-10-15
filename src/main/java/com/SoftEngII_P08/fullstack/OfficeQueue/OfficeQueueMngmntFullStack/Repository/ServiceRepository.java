package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
    
}
