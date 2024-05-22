package com.example.simpleSystem.services;

import com.example.simpleSystem.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServices {

    @Autowired
    public PersonRepository repository;

}
