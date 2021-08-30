package com.nipuni.test.controller.DTO;

import java.time.LocalDate;

public class Persondto {
    private String firstName;
    private String lastName;
    private int personId;
    private String address;
    private LocalDate dob;
    private String gender;
    private String nic;
    private int phoneNumber;

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Persondto(String firstName, String lastName, int personId, String address, LocalDate dob, String gender, String nic, int phonenumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personId = personId;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.nic = nic;
        this.phoneNumber = phonenumber;
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

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phonenumber) {
        this.phoneNumber = phonenumber;
    }

    public Persondto() {
    }
}
