package com.netracker.edu.smartgreenhouse.server.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

import static com.netracker.edu.smartgreenhouse.server.constant.Format.DATE_TIME_FORMAT;

@Entity
public class DeviceData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Device device;

    private Float value;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT)
    private Date timestamp;

    public DeviceData() {}

    public DeviceData(Device device, Float value) {
        this(device, value, new Date());
    }

    public DeviceData(Device device, Float value, Date timestamp) {
        this.device = device;
        this.timestamp = timestamp;
        this.value = value;
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

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
