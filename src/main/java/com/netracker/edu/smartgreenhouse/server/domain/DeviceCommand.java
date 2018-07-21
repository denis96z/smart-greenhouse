package com.netracker.edu.smartgreenhouse.server.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

import static com.netracker.edu.smartgreenhouse.server.constant.Format.DATE_TIME_FORMAT;

@Entity
public class DeviceCommand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Device device;

    private String command;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT)
    private Date timestamp;

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
