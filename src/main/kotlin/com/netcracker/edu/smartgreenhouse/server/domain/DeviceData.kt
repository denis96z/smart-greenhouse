package com.netcracker.edu.smartgreenhouse.server.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.netcracker.edu.smartgreenhouse.server.constant.Format.DATE_TIME_FORMAT
import java.util.*
import javax.persistence.*

@Entity
data class DeviceData(
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

        @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    var device: Device? = null,

        var value: Float? = null,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT)
    var timestamp: Date? = null
)
