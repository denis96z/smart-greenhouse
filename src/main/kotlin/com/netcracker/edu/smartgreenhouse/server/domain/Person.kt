package com.netcracker.edu.smartgreenhouse.server.domain

import com.fasterxml.jackson.annotation.JsonIgnore
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

    @JsonIgnore
    var password: String? = null,

    var role: String? = null,

    var firstName: String? = null,
    var lastName: String? = null
)
