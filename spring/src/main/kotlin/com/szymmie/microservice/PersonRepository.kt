package com.szymmie.microservice

import com.szymmie.microservice.person.Person
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonRepository : JpaRepository<Person, Long> {
    fun findByName(name: String): Optional<Person>
}