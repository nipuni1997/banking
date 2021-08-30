package com.nipuni.test.controller;

import com.nipuni.test.controller.DTO.Bankdto;
import com.nipuni.test.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "bankcon")
public class Bankcontroller {
    @Autowired
    private BankService bankService;
    @PostMapping(value = "addbank")

    public void addBank(@RequestBody Bankdto dto){
        bankService.addBank(dto);
    }

    @GetMapping(value="getbank/{id}")
    public Bankdto getBAnk(@PathVariable int id){
        return bankService.giveBank(id);
    }

    @PutMapping(value = "updatebank")
    public void updateBAnk(@RequestBody Bankdto bankdto){
        bankService.updateBank(bankdto);
    }

    @GetMapping(value = "getallbank")
    public List<Bankdto> getAll(){
        return bankService.getAll();
    }

    @DeleteMapping(value = "deletebank/{id}")
    public void deleteBank(@PathVariable int id){
        bankService.deleteBank(id);
    }

}
