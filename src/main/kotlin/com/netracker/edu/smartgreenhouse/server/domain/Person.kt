package com.netracker.edu.smartgreenhouse.server.domain

import java.util.*
import javax.persistence.*

@Entity
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    var firstName: String? = null,
    var lastName: String? = null,
    var username: String? = null
)
