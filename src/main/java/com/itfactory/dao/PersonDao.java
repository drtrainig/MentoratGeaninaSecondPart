package com.itfactory.dao;

import com.itfactory.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {

    List<Person> persons;

    public PersonDao() {
        persons = new ArrayList<>();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void insertPerson(Person person) {
        persons.add(person);
    }

    public Person getPersonById(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void deletePerson(Person person) {
        persons.remove(person);
    }
}
