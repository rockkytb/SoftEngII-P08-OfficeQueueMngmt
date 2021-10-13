package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "COUNTER_SERVICE")
@EntityListeners(AuditingEntityListener.class)
public class CounterService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "COUNTER_NUMBER", nullable = false)
    private int counterNumber;

    @Column(name = "SERVICE_ID", nullable = false)
    private int serviceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCounterNumber() {
        return counterNumber;
    }

    public void setCounterNumber(int counterNumber) {
        this.counterNumber = counterNumber;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}
