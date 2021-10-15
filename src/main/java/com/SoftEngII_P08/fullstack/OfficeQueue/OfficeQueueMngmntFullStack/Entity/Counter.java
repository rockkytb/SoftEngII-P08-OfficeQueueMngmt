package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "counter")
@EntityListeners(AuditingEntityListener.class)
public class Counter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "counter_id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "counter_service",
            joinColumns = {@JoinColumn(name = "counter_id")},
            inverseJoinColumns = {@JoinColumn(name = "service_id")}
    )
    Set<Service> services = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
