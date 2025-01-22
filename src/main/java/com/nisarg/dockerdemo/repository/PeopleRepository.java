package com.nisarg.dockerdemo.repository;

import com.nisarg.dockerdemo.bean.Person;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface PeopleRepository extends ListCrudRepository<Person, UUID> {
}
