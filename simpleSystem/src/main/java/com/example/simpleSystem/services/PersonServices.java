package com.example.simpleSystem.services;

import com.example.simpleSystem.domain.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){

        logger.info("finding all people!");

        List<Person> people = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            Person person = new Person();
            person.setId(counter.incrementAndGet());
            person.setFirstName("teste" + i);
            person.setLastName("teste" + i);
            person.setAddress("test adress" + i);
            person.setGender("male");
            people.add(person);
        }

        return people;
    }

    public Person findById(String id){

        logger.info("finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("teste");
        person.setLastName("teste");
        person.setAddress("test adress");
        person.setGender("male");

        return person;
    }

    public Person createPerson(Person person){

        logger.info("create one person!");

        Person newPerson = new Person();
        newPerson.setId(counter.incrementAndGet());
        newPerson.setFirstName(person.getFirstName());
        newPerson.setLastName(person.getLastName());
        newPerson.setAddress(person.getAddress());
        newPerson.setGender(person.getGender());

        return newPerson;
    }

    public Person updatePerson(Person person){

        logger.info("update one person!");

        Person newPerson = new Person();
        newPerson.setId(person.getId());
        newPerson.setFirstName(person.getFirstName());
        newPerson.setLastName(person.getLastName());
        newPerson.setAddress(person.getAddress());
        newPerson.setGender(person.getGender());

        return newPerson;
    }

    public ResponseEntity deletePerson(String id){

        logger.info("delete person");

        return ResponseEntity.ok("usuário deletado");

    }

}
