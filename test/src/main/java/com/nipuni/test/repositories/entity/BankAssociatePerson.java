package com.nipuni.test.repositories.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class BankAssociatePerson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int associateId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="personId" ,referencedColumnName = "personId")
    private Person associatedPerson;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="bankId" ,referencedColumnName = "bankId")
    private Bank associatedBank;

    public BankAssociatePerson() {
    }

    public BankAssociatePerson(Person associatedPerson, Bank associatedBank) {
        this.associatedPerson = associatedPerson;
        this.associatedBank = associatedBank;
    }

    public int getAssociateId() {
        return associateId;
    }

    public void setAssociateId(int associateId) {
        this.associateId = associateId;
    }

    public Person getAssociatedPerson() {
        return associatedPerson;
    }

    public void setAssociatedPerson(Person associatedPerson) {
        this.associatedPerson = associatedPerson;
    }

    public Bank getAssociatedBank() {
        return associatedBank;
    }

    public void setAssociatedBank(Bank associatedBank) {
        this.associatedBank = associatedBank;
    }
}
