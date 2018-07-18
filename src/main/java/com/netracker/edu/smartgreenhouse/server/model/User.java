package com.netracker.edu.smartgreenhouse.server.model;

import javax.persistence.Entity;

@Entity
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
}
