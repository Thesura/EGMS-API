package com.egms.api.model;


import java.io.Serializable;

public class CoordId implements Serializable {
    private int area_id;
    private int coord_no;

    public CoordId() {
    }

    public CoordId(int area_id, int coord_no) {
        this.area_id = area_id;
        this.coord_no = coord_no;
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof CoordId)) return false;
        CoordId pk = (CoordId) obj;
        return pk.area_id == (this.area_id) && pk.coord_no == (this.coord_no);
    }
}
