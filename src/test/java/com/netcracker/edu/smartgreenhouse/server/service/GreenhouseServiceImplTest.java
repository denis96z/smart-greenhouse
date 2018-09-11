package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.Greenhouse;
import com.netcracker.edu.smartgreenhouse.server.exception.DataFormatException;
import com.netcracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netcracker.edu.smartgreenhouse.server.repository.GreenhouseRepository;
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
public class GreenhouseServiceImplTest {
    private GreenhouseService greenhouseService;
    private Greenhouse existingGreenhouse, nonExistingGreenhouse, newGreenhouse;

    @Mock
    private GreenhouseRepository mockGreenhouseRepository;

    @Before
    public void setup() {
        existingGreenhouse = new Greenhouse();
        existingGreenhouse.setId(UUID.randomUUID());

        newGreenhouse = new Greenhouse();
        newGreenhouse.setId(null);

        nonExistingGreenhouse = new Greenhouse();
        do {
            nonExistingGreenhouse.setId(UUID.randomUUID());
        } while (nonExistingGreenhouse.getId() == existingGreenhouse.getId());

        greenhouseService = new GreenhouseServiceImpl(mockGreenhouseRepository);

        Mockito
                .when(mockGreenhouseRepository.findById(existingGreenhouse.getId()))
                .thenReturn(Optional.of(existingGreenhouse));
        Mockito
                .when(mockGreenhouseRepository.findById(nonExistingGreenhouse.getId()))
                .thenReturn(Optional.empty());

        Mockito
                .when(mockGreenhouseRepository.save(newGreenhouse))
                .thenReturn(existingGreenhouse);

        Mockito
                .when(mockGreenhouseRepository.save(existingGreenhouse))
                .thenReturn(existingGreenhouse);

        Mockito
                .when(mockGreenhouseRepository.findByOwner_Id(Mockito.any()))
                .thenReturn(new ArrayList<>());
    }

    @Test
    public void addGreenhouseInfoAddsGreenhouseInfoOnNewGreenhouse() {
        Assert.assertEquals(existingGreenhouse, greenhouseService.addGreenhouseInfo(newGreenhouse));
    }

    @Test(expected = DataFormatException.class)
    public void addGreenhouseInfoThrowsExceptionOnNonNullId() {
        greenhouseService.addGreenhouseInfo(existingGreenhouse);
    }

    @Test
    public void getGreenhouseInfoReturnsGreenhouseInfoOnExistingGreenhouse() {
        var greenhouseId = getGreenhouseId(existingGreenhouse);
        Assert.assertEquals(existingGreenhouse, greenhouseService.getGreenhouseInfo(greenhouseId));
    }

    @Test(expected = NotFoundException.class)
    public void getGreenhouseInfoThrowsExceptionOnNonExistingGreenhouse() {
        var greenhouseId = getGreenhouseId(nonExistingGreenhouse);
        greenhouseService.getGreenhouseInfo(greenhouseId);
    }

    @Test
    public void editGreenhouseInfoEditsGreenhouseInfoOnExistingGreenhouse() {
        Assert.assertEquals(existingGreenhouse, greenhouseService.editGreenhouseInfo(existingGreenhouse));
    }

    @Test(expected = NotFoundException.class)
    public void editGreenhouseInfoThrowsExceptionOnNonExistingGreenhouse() {
        greenhouseService.editGreenhouseInfo(nonExistingGreenhouse);
    }

    @Test
    public void deleteGreenhouseInfoDeletesGreenhouseInfoOnExistingGreenhouse() {
        var greenhouseId = getGreenhouseId(existingGreenhouse);
        Assert.assertEquals(existingGreenhouse, greenhouseService.deleteGreenhouseInfo(greenhouseId));
    }

    @Test(expected = NotFoundException.class)
    public void deleteGreenhouseInfoThrowsExceptionOnNonExistingGreenhouse() {
        var greenhouseId = getGreenhouseId(nonExistingGreenhouse);
        greenhouseService.deleteGreenhouseInfo(greenhouseId);
    }

    @Test
    public void getGreenhousesByOwnerReturnsList() {
        var ownerId = Long.valueOf(1L);
        Assert.assertNotNull(greenhouseService.getGreenhousesByOwner(ownerId));
    }

    private UUID getGreenhouseId(Greenhouse greenhouse) {
        return Objects.requireNonNull(greenhouse.getId());
    }
}
