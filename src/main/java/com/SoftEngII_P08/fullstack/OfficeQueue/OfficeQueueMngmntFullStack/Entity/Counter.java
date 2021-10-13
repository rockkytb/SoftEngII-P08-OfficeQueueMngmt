package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "COUNTER")
@EntityListeners(AuditingEntityListener.class)
public class Counter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name = "COUNTER_NAME", nullable = false)
    private String counterName;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }
}
