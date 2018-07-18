package com.netracker.edu.smartgreenhouse.server.model;

import javax.persistence.Entity;

@Entity
public class Greenhouse {
    private Long id;
    private User owner;
    private Address address;
}
