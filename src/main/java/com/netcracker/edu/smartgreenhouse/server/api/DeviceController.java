package com.netcracker.edu.smartgreenhouse.server.api;

import com.netcracker.edu.smartgreenhouse.server.domain.Device;
import com.netcracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netcracker.edu.smartgreenhouse.server.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    private final DeviceService service;

    @Autowired
    public DeviceController(DeviceService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public void addDeviceInfo(@RequestBody Device device) {
        service.addDeviceInfo(device);
    }

    @GetMapping("{deviceId}")
    public Device getDeviceInfo(@PathVariable UUID deviceId) {
        return service.getDeviceInfo(deviceId);
    }

    @PutMapping("{deviceId}")
    public void editDeviceInfo(@PathVariable UUID deviceId, @RequestBody Device device) {
        device.setId(deviceId);
        service.editDeviceInfo(device);
    }

    @DeleteMapping("{deviceId}")
    public void deleteDeviceInfo(@PathVariable UUID deviceId) {
        service.deleteDeviceInfo(deviceId);
    }

    @GetMapping("/greenhouse/{greenhouseId}")
    public List<Device> getDevicesByGreenhouse(@PathVariable UUID greenhouseId) {
        return service.getDevicesByGreenhouse(greenhouseId);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(NotFoundException exception) {
        return exception.getMessage();
    }
}
