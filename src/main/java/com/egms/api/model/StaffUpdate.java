package com.egms.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "users_staff")
public class StaffUpdate{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String phoneNo;
    private String email;
    private int areaOfOperation;

    public StaffUpdate(){}

    public StaffUpdate(@JsonProperty("name") String name,
                 @JsonProperty("phone") String phoneNo,
                 @JsonProperty("email") String email,
                 @JsonProperty("area") int areaOfOperation) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.areaOfOperation = areaOfOperation;
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

    public int getAreaOfOperation() {
        return areaOfOperation;
    }

    public void setAreaOfOperation(int areaOfOperation) {
        this.areaOfOperation = areaOfOperation;
    }
}
