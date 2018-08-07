package com.netracker.edu.smartgreenhouse.server.domain

import javax.persistence.*

@Entity
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Column(unique = true)
    var username: String? = null,

    @Column(unique = true)
    var email: String? = null,

    var password: String? = null,

    var role: String? = null,

    var firstName: String? = null,
    var lastName: String? = null
)
