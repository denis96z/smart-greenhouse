package com.netracker.edu.smartgreenhouse.server.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DeviceCommand {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Device device;

    private String command;
    private Date timestamp;
    private CommandState state;

    public Long getId() {
        return id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public CommandState getState() {
        return state;
    }

    public void setState(CommandState state) {
        this.state = state;
    }
}