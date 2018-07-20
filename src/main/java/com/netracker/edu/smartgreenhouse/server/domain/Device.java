package com.netracker.edu.smartgreenhouse.server.domain;

import javax.persistence.*;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Greenhouse greenhouse;

    public Long getId() {
        return id;
    }

    public Greenhouse getGreenhouse() {
        return greenhouse;
    }

    public void setGreenhouse(Greenhouse greenhouse) {
        this.greenhouse = greenhouse;
    }
}
