package com.nisarg.dockerdemo.util;

import com.nisarg.dockerdemo.bean.Person;
import com.nisarg.dockerdemo.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@AllArgsConstructor
public class DBCommandLineRunner implements CommandLineRunner {

    private PeopleRepository peopleRepository;

    @Override
    public void run(String... args) {
        log.info("Adding people into database table...");
        peopleRepository.save(new Person(UUID.randomUUID(), "Nisarg", "nisarg@gmail.com"));
        peopleRepository.save(new Person(UUID.randomUUID(), "ABC", "abc@gmail.com"));
        peopleRepository.save(new Person(UUID.randomUUID(), "XYZ", "xyz@gmail.com"));
    }
}
