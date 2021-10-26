package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Service;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Counter;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;



@org.springframework.stereotype.Service
public class CounterService {

    @Autowired
    private CounterRepository counterRepository;

    public Counter createCounter( String name) {
        Counter newCounter = new Counter();
        newCounter.setName(name);
         
    
        return counterRepository.save(newCounter);
    }

    public List<Counter> getAllCounter(){
        List<Counter> allcount = counterRepository.findAll();
        return allcount;
    }
    
    public int linkSC (int serviceId,int counterId) {
    	return counterRepository.link(serviceId, counterId);
    }
}
