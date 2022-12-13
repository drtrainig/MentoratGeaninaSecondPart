package com.itfactory.controller;

import com.itfactory.exceptions.PersonNotFoundException;
import com.itfactory.model.Person;
import com.itfactory.services.PersonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        try {
            return ResponseEntity.ok(personService.getAllPersons());
        } catch (PersonNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public Person getAllPersonById(@PathVariable int id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    public String insertPerson(@RequestBody Person person) {
        personService.insertPerson(person);
        return "true";
    }

    @PutMapping
    public String updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
        return "true";
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id) {
        personService.deleteById(id);
    }

}
