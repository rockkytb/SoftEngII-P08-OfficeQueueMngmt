package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "SERVICE_CODE")
@EntityListeners(AuditingEntityListener.class)
public class ServiceCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME_SERVICE", nullable = false)
    private int nameService;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNameService() {
        return nameService;
    }

    public void setNameService(int nameService) {
        this.nameService = nameService;
    }
}
