package com.netracker.edu.smartgreenhouse.server.domain;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "address_string")
    private String address;

    public Address() {}

    public Address(String address) {
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
