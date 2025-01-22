package com.nisarg.dockerdemo.controller;

import com.nisarg.dockerdemo.bean.Person;
import com.nisarg.dockerdemo.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/people")
@Slf4j
@AllArgsConstructor
public class PeopleController {

    private PeopleRepository peopleRepository;

    @GetMapping("echo")
    public String echo() {
        log.info("Echo controller!");
        return "Service is up";
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPeople() {
        log.info("Fetching all people!");
        return ResponseEntity.ok(peopleRepository.findAll());
    }

    @GetMapping("/{id}")
    @Cacheable("findById")
    public ResponseEntity<Person> getById(@PathVariable UUID id) {
        log.info("Fetching person with id:{}", id);
        Optional<Person> person = peopleRepository.findById(id);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
