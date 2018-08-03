package com.netracker.edu.smartgreenhouse.server.domain

import java.util.*
import javax.persistence.*

@Entity
data class Greenhouse(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    var aliasName: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    var owner: Person? = null
)
