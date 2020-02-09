package com.egms.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "coordinates")
@IdClass(CoordId.class)
public class Coordinate {
    @Id
    private int area_id;
    @Id
    private int coord_no;
    private double lat;
    private double lng;

    public Coordinate() {
    }

    public Coordinate(@JsonProperty("area_id") int area_id,
                      @JsonProperty("coord_no")int coord_no,
                      @JsonProperty("lat")double lat,
                      @JsonProperty("lng")double lng) {
        this.area_id = area_id;
        this.coord_no = coord_no;
        this.lat = lat;
        this.lng = lng;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public int getCoord_no() {
        return coord_no;
    }

    public void setCoord_no(int coord_no) {
        this.coord_no = coord_no;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
