package com.egms.api.model;

public class ScheduleToReturn {
    private String type;
    private String start_date_time;
    private String end_date_time;
    private String area;

    public ScheduleToReturn() {
    }

    public ScheduleToReturn(String type, String start_date_time, String end_date_time, String area) {
        this.type = type;
        this.start_date_time = start_date_time;
        this.end_date_time = end_date_time;
        this.area = area;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
