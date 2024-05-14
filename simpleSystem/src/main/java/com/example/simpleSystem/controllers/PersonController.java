package com.example.simpleSystem.controllers;

import com.example.simpleSystem.domain.Person;
import com.example.simpleSystem.services.PersonServices;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    @Autowired
    private PersonServices personServices;

    @GetMapping
    public List<Person> findAllPeople(){
        return personServices.findAll();
    }

    @GetMapping("{id}")
    public Person findPersonById(@PathVariable String id){
         return personServices.findById(id);
    }

    @PostMapping
    private Person createPerson(@RequestBody Person person){
        return personServices.createPerson(person);
    }

    @PutMapping
    private Person updatePerson(@RequestBody Person person){
        return personServices.updatePerson(person);
    }

    @DeleteMapping("{id}")
    private ResponseEntity deletePerson(@PathVariable String id){
        return personServices.deletePerson(id);
    }


}
