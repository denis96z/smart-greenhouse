package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.Device;
import com.netcracker.edu.smartgreenhouse.server.exception.DataFormatException;
import com.netcracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netcracker.edu.smartgreenhouse.server.repository.DeviceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RunWith(SpringRunner.class)
public class DeviceServiceImplTest {
    private DeviceService deviceService;
    private Device existingDevice, nonExistingDevice, newDevice;

    @Mock
    private DeviceRepository mockDeviceRepository;

    @Before
    public void setup() {
        existingDevice = new Device();
        existingDevice.setId(UUID.randomUUID());

        newDevice = new Device();
        newDevice.setId(null);

        nonExistingDevice = new Device();
        do {
            nonExistingDevice.setId(UUID.randomUUID());
        } while (nonExistingDevice.getId() == existingDevice.getId());

        deviceService = new DeviceServiceImpl(mockDeviceRepository);

        Mockito
                .when(mockDeviceRepository.findById(existingDevice.getId()))
                .thenReturn(Optional.of(existingDevice));
        Mockito
                .when(mockDeviceRepository.findById(nonExistingDevice.getId()))
                .thenReturn(Optional.empty());

        Mockito
                .when(mockDeviceRepository.save(newDevice))
                .thenReturn(existingDevice);

        Mockito
                .when(mockDeviceRepository.save(existingDevice))
                .thenReturn(existingDevice);

        Mockito
                .when(mockDeviceRepository.findByGreenhouse_Id(Mockito.any()))
                .thenReturn(new ArrayList<>());
    }

    @Test
    public void addDeviceInfoAddsDeviceInfoOnNewDevice() {
        Assert.assertEquals(existingDevice, deviceService.addDeviceInfo(newDevice));
    }

    @Test(expected = DataFormatException.class)
    public void addDeviceInfoThrowsExceptionOnNonNullId() {
        deviceService.addDeviceInfo(existingDevice);
    }

    @Test
    public void getDeviceInfoReturnsDeviceInfoOnExistingDevice() {
        var deviceId = getDeviceId(existingDevice);
        Assert.assertEquals(existingDevice, deviceService.getDeviceInfo(deviceId));
    }

    @Test(expected = NotFoundException.class)
    public void getDeviceInfoThrowsExceptionOnNonExistingDevice() {
        var deviceId = getDeviceId(nonExistingDevice);
        deviceService.getDeviceInfo(deviceId);
    }

    @Test
    public void editDeviceInfoEditsDeviceInfoOnExistingDevice() {
        Assert.assertEquals(existingDevice, deviceService.editDeviceInfo(existingDevice));
    }

    @Test(expected = NotFoundException.class)
    public void editDeviceInfoThrowsExceptionOnNonExistingDevice() {
        deviceService.editDeviceInfo(nonExistingDevice);
    }

    @Test
    public void deleteDeviceInfoDeletesDeviceInfoOnExistingDevice() {
        var deviceId = getDeviceId(existingDevice);
        Assert.assertEquals(existingDevice, deviceService.deleteDeviceInfo(deviceId));
    }

    @Test(expected = NotFoundException.class)
    public void deleteDeviceInfoThrowsExceptionOnNonExistingDevice() {
        var deviceId = getDeviceId(nonExistingDevice);
        deviceService.deleteDeviceInfo(deviceId);
    }

    @Test
    public void getDevicesByGreenhouseReturnsList() {
        var greenhouseId = UUID.randomUUID();
        Assert.assertNotNull(deviceService.getDevicesByGreenhouse(greenhouseId));
    }

    private UUID getDeviceId(Device device) {
        return Objects.requireNonNull(device.getId());
    }
}
