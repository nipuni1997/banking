package com.nipuni.test.repositories.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bankId;
    private String bankName;

    public List<Person> getPersonList() {
        return personList;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "associatedBank")
    private List<Person> personList=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "associated_person_person_id")
    private Person associatedPerson;

    public Person getAssociatedPerson() {
        return associatedPerson;
    }

    public void setAssociatedPerson(Person associatedPerson) {
        this.associatedPerson = associatedPerson;
    }

    public Bank() {
    }

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
