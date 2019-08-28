package com.example.bt2.fragmentstudient;

import java.io.Serializable;

public class StudientFrag implements Serializable {
    private String name;
    private int yearofbirt;
    private String address;
    private String email;

    public StudientFrag(String name, int yearofbirt, String address, String email) {
        this.name = name;
        this.yearofbirt = yearofbirt;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearofbirt() {
        return yearofbirt;
    }

    public void setYearofbirt(int yearofbirt) {
        this.yearofbirt = yearofbirt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
