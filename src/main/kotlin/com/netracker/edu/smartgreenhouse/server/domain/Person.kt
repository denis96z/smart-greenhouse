package com.netracker.edu.smartgreenhouse.server.domain

import javax.persistence.*

@Entity
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    var username: String? = null,
    var password: String? = null,

    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null
)
