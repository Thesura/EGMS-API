package com.egms.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int area;
    private String date_time;
    private String special_notes;
    private int reporter_id;

    public Report() {
    }

    public Report(@JsonProperty("area") int area,
                  @JsonProperty("date_time") String date_time,
                  @JsonProperty("special_notes") String special_notes,
                  @JsonProperty("reporter_id") int reporter_id) {
        this.area = area;
        this.date_time = date_time;
        this.special_notes = special_notes;
        this.reporter_id = reporter_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getSpecial_notes() {
        return special_notes;
    }

    public void setSpecial_notes(String special_notes) {
        this.special_notes = special_notes;
    }

    public int getReporter_id() {
        return reporter_id;
    }

    public void setReporter_id(int reporter_id) {
        this.reporter_id = reporter_id;
    }
}
