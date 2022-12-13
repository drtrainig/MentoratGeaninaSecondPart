package com.itfactory.services;

import com.itfactory.dao.PersonDao;
import com.itfactory.exceptions.PersonNotFoundException;
import com.itfactory.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> getAllPersons() throws PersonNotFoundException {
        List<Person> persons = personDao.getPersons();
        if (persons.isEmpty()) {
            throw new PersonNotFoundException();
        }
        return personDao.getPersons();
    }

    public void insertPerson(Person person) {
        personDao.insertPerson(person);
    }

    public Person getPersonById(int id) {
        return personDao.getPersonById(id);
    }

    public void updatePerson(Person person) {
        Person person1 = personDao.getPersonById(person.getId());
        person1.setName(person.getName());
        person1.setAge(person.getAge());
    }

    public void deleteById(int id) {
        Person person = personDao.getPersonById(id);
        personDao.deletePerson(person);
    }
}
