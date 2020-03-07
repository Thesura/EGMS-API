package com.egms.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Coordinate.coordinates")
@IdClass(CoordId.class)
public class Coordinate {
    @Id
    private int area_id;
    private double lat1;
    private double lng1;
    private double lat2;
    private double lng2;
    private double lat3;
    private double lng3;
    private double lat4;
    private double lng4;

    public Coordinate() {
    }

    public Coordinate(@JsonProperty("area_id") int area_id,
                      @JsonProperty("lat1") double lat1,
                      @JsonProperty("lng1") double lng1,
                      @JsonProperty("lat2") double lat2,
                      @JsonProperty("lng2") double lng2,
                      @JsonProperty("lat3") double lat3,
                      @JsonProperty("lng3") double lng3,
                      @JsonProperty("lat4") double lat4,
                      @JsonProperty("lng4") double lng4) {
        this.area_id = area_id;
        this.lat1 = lat1;
        this.lng1 = lng1;
        this.lat2 = lat2;
        this.lng2 = lng2;
        this.lat3 = lat3;
        this.lng3 = lng3;
        this.lat4 = lat4;
        this.lng4 = lng4;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public double getLat1() {
        return lat1;
    }

    public void setLat1(double lat1) {
        this.lat1 = lat1;
    }

    public double getLng1() {
        return lng1;
    }

    public void setLng1(double lng1) {
        this.lng1 = lng1;
    }

    public double getLat2() {
        return lat2;
    }

    public void setLat2(double lat2) {
        this.lat2 = lat2;
    }

    public double getLng2() {
        return lng2;
    }

    public void setLng2(double lng2) {
        this.lng2 = lng2;
    }

    public double getLat3() {
        return lat3;
    }

    public void setLat3(double lat3) {
        this.lat3 = lat3;
    }

    public double getLng3() {
        return lng3;
    }

    public void setLng3(double lng3) {
        this.lng3 = lng3;
    }

    public double getLat4() {
        return lat4;
    }

    public void setLat4(double lat4) {
        this.lat4 = lat4;
    }

    public double getLng4() {
        return lng4;
    }

    public void setLng4(double lng4) {
        this.lng4 = lng4;
    }
}
