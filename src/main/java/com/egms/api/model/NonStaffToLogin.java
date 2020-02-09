package com.egms.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NonStaffToLogin {
    String name;
    String pwd;

    public NonStaffToLogin(@JsonProperty("name") String name,
                        @JsonProperty("password") String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
