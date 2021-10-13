package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "TICKET")
@EntityListeners(AuditingEntityListener.class)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name = "COD_SERVICE", nullable = false)
    private int codService;

    @Column(name = "SERVED", nullable = false)
    private int served;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCodService() {
        return codService;
    }

    public void setCodService(int codService) {
        this.codService = codService;
    }

    public int getServed() {
        return served;
    }

    public void setServed(int served) {
        this.served = served;
    }
}