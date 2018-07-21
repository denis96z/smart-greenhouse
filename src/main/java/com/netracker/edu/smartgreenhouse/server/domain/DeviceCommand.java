package com.netracker.edu.smartgreenhouse.server.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "device_command")
public class DeviceCommand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    @Column(name = "command_string")
    private String command;

    @Column(name = "timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy-hh:mm:ss")
    private Date timestamp;

    @Column(name = "state")
    private CommandState state;

    public DeviceCommand() {}

    public DeviceCommand(Device device, String command) {
        this(device, command, new Date(), CommandState.NOT_EXECUTED);
    }

    public DeviceCommand(Device device, String command,
                         Date timestamp, CommandState state) {
        this.device = device;
        this.command = command;
        this.timestamp = timestamp;
        this.state = state;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
