package com.nipuni.test.repositories;

import com.nipuni.test.repositories.entity.Bank;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<Bank,Integer> {
}

