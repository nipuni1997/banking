package com.nipuni.test.service;

import com.nipuni.test.controller.DTO.Bankdto;
import com.nipuni.test.repositories.BankRepository;
import com.nipuni.test.repositories.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;
    public void addBank(Bankdto dto){
//        System.out.println(dto.getBankId()+" "+dto.getBankName());
        bankRepository.save(new Bank(dto.getBankName()));
//        Bank bank=bankRepository.findById(1).get();
//        System.out.println(bank.getBankId()+" / "+bank.getBankName());
//        return bank;


    }

    public Bankdto giveBank(int bankID){
        Bank bank=bankRepository.findById(bankID).get();
        return new Bankdto(bank.getBankName());
    }

    public void updateBank(Bankdto bankdto){
        Bank bank=bankRepository.findById(bankdto.getBankId()).get();
        bank.setBankName(bankdto.getBankName());
        bankRepository.save(bank);
    }
    public List<Bankdto> getAll(){
        List<Bankdto> list=new ArrayList<>();
        for (Bank bank : bankRepository.findAll()) {
            list.add(new Bankdto(bank.getBankName()));
        }

        return list;
    }

    public void deleteBank(int id){
        Bank bank=bankRepository.findById(id).get();
        bankRepository.delete(bank);
    }

}
