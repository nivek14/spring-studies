package com.example.simpleSystem.controllers;

import com.example.simpleSystem.domain.Person;
import com.example.simpleSystem.services.PersonServices;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
