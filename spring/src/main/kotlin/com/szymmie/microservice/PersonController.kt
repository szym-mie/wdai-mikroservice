package com.szymmie.microservice

import com.szymmie.microservice.person.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class PersonController {
    @Autowired
    private lateinit var personService: PersonService

    @GetMapping("/person")
    fun getPersons() = personService.getPersons()

    @GetMapping("/person/{id}")
    fun getPerson(@PathVariable("id") id: Long) = personService.getPerson(id) ?:
        RequestError(RequestError.Type.NOT_FOUND, "id", id.toString())

    @PostMapping("/create")
    fun createPerson(@RequestBody person: Person) = personService.createPerson(person)
}