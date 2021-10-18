package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Service;


import java.util.List;
import java.util.stream.Collectors;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.ResponseModel.ServiceResponse;
import org.modelmapper.ModelMapper;
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

    public List<ServiceResponse> getServiceList() {
        ModelMapper modelMapper = new ModelMapper();
        List<Service> services = serviceRepository.findAll();
        List<ServiceResponse> serviceResponses = services
                .stream()
                .map(service -> modelMapper.map(service, ServiceResponse.class))
                .collect(Collectors.toList());
        return serviceResponses;
    }
}