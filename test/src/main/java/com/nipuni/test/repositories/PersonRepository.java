package com.nipuni.test.repositories;

import com.nipuni.test.repositories.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.time.Period;

public interface PersonRepository extends CrudRepository<Person,Integer> {
}
