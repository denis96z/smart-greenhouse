package com.netracker.edu.smartgreenhouse.server.model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class DeviceData {
    private Long id;
    private Device device;
    private Date timestamp;
    private Double value;
}
