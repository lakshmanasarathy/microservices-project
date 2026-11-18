package com.example.address_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String lane1;
    @Column
    private String lane2;
    @Column
    private String state;
    @Column
    private String zip;

    public void setLane1(String lane1) {
        this.lane1 = lane1;
    }

    public String getLane1() {
        return lane1;
    }

    public void setLane2(String lane2) {
        this.lane2 = lane2;
    }

    public String getLane2() {
        return lane2;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setZip(String Zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}