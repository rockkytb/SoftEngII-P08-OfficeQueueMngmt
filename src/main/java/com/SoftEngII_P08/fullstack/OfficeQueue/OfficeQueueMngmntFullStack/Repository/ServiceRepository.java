package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
