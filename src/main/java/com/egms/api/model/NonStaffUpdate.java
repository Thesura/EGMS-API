package com.egms.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "users_nonstaff")
public class NonStaffUpdate{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String phoneNo;
    private String email;
    private String address;

    public NonStaffUpdate(){}

    public NonStaffUpdate(@JsonProperty("name") String name,
                    @JsonProperty("phone") String phoneNo,
                    @JsonProperty("email") String email,
                    @JsonProperty("address") String address) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
