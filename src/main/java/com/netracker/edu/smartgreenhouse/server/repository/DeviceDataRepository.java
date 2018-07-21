package com.netracker.edu.smartgreenhouse.server.repository;

import com.netracker.edu.smartgreenhouse.server.domain.DeviceData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.UUID;

public interface DeviceDataRepository extends CrudRepository<DeviceData, UUID> {
    @Query("select d from device_data d where " +
            "(d.device_id = :deviceId) and " +
            "(d.timestamp between :fromDate and :toDate)")
    Iterable<DeviceData> findByDeviceIdAndDatesBetween(@Param("deviceId") UUID deviceId,
                                                       @Param("fromDate") Date fromDate,
                                                       @Param("toDate") Date to);
}
