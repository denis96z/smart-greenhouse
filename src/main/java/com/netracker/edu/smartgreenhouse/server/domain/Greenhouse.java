package com.netracker.edu.smartgreenhouse.server.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Greenhouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String aliasName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Person owner;

    public Greenhouse() {}

    public Greenhouse(String aliasName, Person owner) {
        this.aliasName = aliasName;
        this.owner = owner;
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

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
