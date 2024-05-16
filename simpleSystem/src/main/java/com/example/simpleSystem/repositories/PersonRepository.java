package com.example.simpleSystem.repositories;

import com.example.simpleSystem.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String> {
    Optional<Person> findById(String id);
}
