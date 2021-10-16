package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Service;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService {
    
    @Autowired
    private ServiceRepository serviceRepository;

    public Service createService(String name) {
        Service newService = new Service();
        newService.setName(name);
        return serviceRepository.save(newService);
    }
    
    public int countServedClientPerServiceId(int serviceId) {
    	return serviceRepository.CountClientServed(serviceId);
    }
    
    public List<Service> getServiceList(){
    	return serviceRepository.getServicesAvailable();
    	
    }
}