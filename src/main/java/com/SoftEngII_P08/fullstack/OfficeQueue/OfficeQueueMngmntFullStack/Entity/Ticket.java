package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
@EntityListeners(AuditingEntityListener.class)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id", nullable = false)
    private int id;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;


    @Column(name = "served", nullable = false)
    private int served;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getServed() {
        return served;
    }

    public void setServed(int served) {
        this.served = served;
    }
}