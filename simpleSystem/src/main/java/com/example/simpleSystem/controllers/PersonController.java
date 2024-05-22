package com.example.simpleSystem.controllers;

import com.example.simpleSystem.domain.Person;
import com.example.simpleSystem.services.PersonServices;
import java.util.List;
import java.util.Optional;

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
        return personServices.repository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Person> findPersonById(@PathVariable Long id){
         return personServices.repository.findById(id);
    }

    @PostMapping
    private ResponseEntity createPerson(@RequestBody Person person){
        personServices.repository.save(person);
        return ResponseEntity.ok("Person created");
    }

    @PutMapping
    private ResponseEntity updatePerson(@RequestBody Person person){
        Optional<Person> optionalPerson = personServices.repository.findById(person.getId());
        if(optionalPerson.isPresent()){
            personServices.repository.save(person);
            return ResponseEntity.ok("Person updated");
        }
        else return ResponseEntity.ok("Person not found"); // ideal é disparar um erro
    }

    @DeleteMapping("{id}")
    private ResponseEntity deletePerson(@PathVariable Long id){
        personServices.repository.deleteById(id);
        return ResponseEntity.ok("Person deleted");
    }


}
