package com.nipuni.test.controller;


import com.nipuni.test.controller.DTO.Bankdto;
import com.nipuni.test.controller.DTO.Persondto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nipuni.test.service.PersonService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "personcon")
public class PersonController {
    @Autowired
    private PersonService personService;
    @PostMapping(value = "addperson")

    public void addPerson(@RequestBody Persondto dto){
        personService.addPerson(dto);
    }
    @GetMapping(value="getperson/{id}")
    public Persondto getPerson(@PathVariable int id){
        return personService.givePerson(id);
    }

    @PutMapping(value = "updateperson")
    public void updateperson(@RequestBody Persondto persondto){
        personService.updatePerson(persondto);
    }

    @GetMapping(value = "getallperson")
    public List<Persondto> getAll(){
        return personService.getAll();
    }

    @DeleteMapping(value = "deleteperson/{id}")
    public void deletePerson(@PathVariable int id){
        personService.deletePerson(id);
    }
}
