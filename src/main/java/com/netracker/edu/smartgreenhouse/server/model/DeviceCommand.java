package com.netracker.edu.smartgreenhouse.server.model;

import javax.persistence.Entity;

@Entity
public class DeviceCommand {
    private Long id;
    private Device device;
    private String command;
    private CommandState state;
}
