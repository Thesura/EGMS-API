package com.egms.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String type;
    private String start_date_time;
    private String end_date_time;
    private int area;
    private int poster_id;

    public Schedule() {
    }

    public Schedule(@JsonProperty("type") String type,
                    @JsonProperty("start_date_time") String start_date_time,
                    @JsonProperty("end_date_time") String end_date_time,
                    @JsonProperty("area") int area,
                    @JsonProperty("poster_id")  int poster_id) {
        this.type = type;
        this.start_date_time = start_date_time;
        this.end_date_time = end_date_time;
        this.area = area;
        this.poster_id = poster_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStart_date_time() {
        return start_date_time;
    }

    public void setStart_date_time(String start_date_time) {
        this.start_date_time = start_date_time;
    }

    public String getEnd_date_time() {
        return end_date_time;
    }

    public void setEnd_date_time(String end_date_time) {
        this.end_date_time = end_date_time;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPoster_id() {
        return poster_id;
    }

    public void setPoster_id(int poster_id) {
        this.poster_id = poster_id;
    }
}
