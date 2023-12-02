package com.szymmie.microservice.person

import jakarta.persistence.*

@Entity
data class Person(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id: Long,
        @Column(name = "name") val name: String,
        @Column(name = "job") val job: String
)
