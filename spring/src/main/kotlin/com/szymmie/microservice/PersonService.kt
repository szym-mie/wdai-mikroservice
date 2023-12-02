package com.szymmie.microservice

import com.szymmie.microservice.person.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService {
    @Autowired
    private lateinit var personRepository: PersonRepository

    fun getPersons(): List<Person> = personRepository.findAll().toList()
    fun getPerson(id: Long): Person? = personRepository.findById(id).orElse(null)
    fun getPerson(name: String): Person? = personRepository.findByName(name).orElse(null)
    fun createPerson(person: Person): Person = personRepository.save(person)
}