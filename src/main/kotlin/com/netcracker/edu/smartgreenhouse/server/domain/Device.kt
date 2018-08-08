package com.netcracker.edu.smartgreenhouse.server.domain

import java.util.*
import javax.persistence.*

@Entity
data class Device(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    var aliasName: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    var greenhouse: Greenhouse? = null
)
