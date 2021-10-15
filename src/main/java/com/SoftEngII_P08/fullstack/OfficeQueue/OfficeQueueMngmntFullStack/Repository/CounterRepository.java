package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Counter;


public interface CounterRepository extends JpaRepository<Counter, Integer> {
}

