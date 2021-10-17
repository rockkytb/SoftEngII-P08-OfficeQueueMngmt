package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Controller;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Service;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Service.ServiceService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping("/service")
    public Service GenerationService(@Validated @RequestBody String name) {
        return serviceService.createService(name);
    }

    @GetMapping("/servedClients/{id}")
    public ResponseEntity<?> getCountServedClient(@PathVariable int id) {
        int count = serviceService.countServedClientPerServiceId(id);
        return ResponseEntity.ok(count);
    }
    
    @GetMapping("/allservices") //Crashes because service contains ticket and ticket contains service
    public ResponseEntity<?> getAllServices() {
        List<Service> services = serviceService.getServiceList();
        return ResponseEntity.ok(services);
    }
}
