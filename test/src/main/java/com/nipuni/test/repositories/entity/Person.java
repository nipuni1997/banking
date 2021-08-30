package com.nipuni.test.repositories.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int personId;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private int phoneNumber;
    private String nic;
    private String gender;
    private String address;

    public Person() {
    }

    public Person(int personId, String firstName, String lastName, String dob, int phoneNumber, String nic, String gender, String address) {
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBank(List<Bank> bank) {
        this.bank = bank;
    }

    public Person(int personId, String firstName, String lastName, LocalDate dob, int phoneNumber, String nic, String gender, String address) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.nic = nic;
        this.gender = gender;
        this.address = address;
        this.bank = bank;
        this.associatedBank = associatedBank;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "associatedPerson")
    private List<Bank> bank=new ArrayList<>();



    public List<Bank> getBank() {
        return bank;
    }

    @ManyToOne
    @JoinColumn(name = "associated_bank_bank_id")
    private Bank associatedBank;

    public Bank getAssociatedBank() {
        return associatedBank;
    }

    public void setAssociatedBank(Bank associatedBank) {
        this.associatedBank = associatedBank;
    }
}
