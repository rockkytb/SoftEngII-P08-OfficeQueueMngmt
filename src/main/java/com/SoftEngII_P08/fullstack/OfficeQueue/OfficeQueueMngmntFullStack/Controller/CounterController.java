package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Controller;

import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity.Counter;
import com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CounterController {

    @Autowired
    private CounterService counterService;

    @PostMapping("/counter")
    public Counter GenerateCounter(@Validated @RequestBody String name) {
        return counterService.createCounter(name);
    }
    
    @PostMapping("/linkCounterService")
    public ResponseEntity<?> linkCounterService (@Validated @RequestBody int serviceId, @Validated @RequestBody int counterId) {
    	int response = counterService.linkSC(serviceId, counterId);
    	return ResponseEntity.ok(response);
    
    }
    

}
