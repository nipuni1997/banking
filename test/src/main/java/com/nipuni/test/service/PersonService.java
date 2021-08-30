package com.nipuni.test.service;

import com.nipuni.test.controller.DTO.Bankdto;
import com.nipuni.test.controller.DTO.Persondto;
import com.nipuni.test.repositories.PersonRepository;
import com.nipuni.test.repositories.entity.Bank;
import com.nipuni.test.repositories.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    public void addPerson(Persondto dto){

        personRepository.save(new Person(dto.getPersonId(),dto.getFirstName(),dto.getLastName(),dto.getDob(),dto.getPhoneNumber(),dto.getNic(),dto.getGender(),dto.getAddress()));

    }

    public Persondto givePerson(int personId){
        Person person=personRepository.findById(personId).get();
        return new Persondto(person.getFirstName(),person.getLastName(),person.getPersonId(),person.getAddress(),person.getDob(),person.getGender(),person.getNic(),person.getPhoneNumber());
    }


    public void updatePerson(Persondto persondto){
        Person person=personRepository.findById(persondto.getPersonId()).get();
        person.setFirstName(persondto.getFirstName());
        personRepository.save(person);
    }
    public List<Persondto> getAll(){
        List<Persondto> list=new ArrayList<>();
        for (Person person : personRepository.findAll()) {
            list.add(new Persondto(person.getFirstName(),person.getLastName(),person.getPersonId(),person.getAddress(),person.getDob(),person.getGender(),person.getNic(),person.getPhoneNumber()));
        }

        return list;
    }

    public void deletePerson(int id){
        Person person=personRepository.findById(id).get();
        personRepository.delete(person);
    }
}
