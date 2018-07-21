package com.netracker.edu.smartgreenhouse.server.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "alias_name")
    private String aliasName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "greenhouse_id", nullable = false)
    private Greenhouse greenhouse;

    public Device() {}

    public Device(String aliasName, Greenhouse greenhouse) {
        this.aliasName = aliasName;
        this.greenhouse = greenhouse;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public Greenhouse getGreenhouse() {
        return greenhouse;
    }

    public void setGreenhouse(Greenhouse greenhouse) {
        this.greenhouse = greenhouse;
    }
}
